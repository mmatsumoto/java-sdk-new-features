package org.example.java15;

import java.util.NoSuchElementException;
import java.util.function.Function;

public class _05Sealed {
    public static void main(String[] args) {

        final Either<String, String> e1 = Either.left("wrong value");

        System.out.println(e1);
        System.out.println(e1.isLeft());
        System.out.println(e1.isRight());
        System.out.println("My left value: " + e1.failure());

        Function<String, String> fallback = (f) -> "recovering from "+ f;
        Function<String, String> success = String::toUpperCase;

        System.out.println("fold result: " + e1.fold(fallback, success));
        if (e1 instanceof Left<String, String> left) {
            System.out.println(left.<String>recovery(v -> "after recovery " + v));
        }



        final Either<String, String> e2 = Either.right("good value");
        System.out.println(e2);
        System.out.println(e2.isLeft());
        System.out.println(e2.isRight());
        System.out.println("My right value: " + e2.get());
        System.out.println("fold result: " + e2.fold(fallback, success));
        if (e2 instanceof Right<String, String> right) {
            System.out.println(right.<String>map(v -> "after map " + v));
        }


        // in the future? pattern matching
//        Either someEither = e1;
//        int r = switch (someEither) {
//            case Left  l -> l.failure();
//            case Right c -> r.get() ;
//        };
//        System.out.println("someEither: " + r);
    }
}

abstract sealed class Either<L, R> permits Left, Right {
    abstract L component1();
    abstract R component2();

    public static <L, R> Either<L, R> left(L left) {
        return new Left<>(left);
    }

    public static <L, R> Either<L, R> right(R right) {
        return new Right<>(right);
    }

    public boolean isLeft() {
        return this instanceof Left;
    }

    public boolean isRight() {
        return !isLeft();
    }

    public <T> T fold(Function<L, T> onFailure, Function<R, T> onSuccess) {
        return isLeft() ? onFailure.apply(component1()) : onSuccess.apply(component2());
    }

    public R get() {
        if(isRight()) return this.component2();
        throw new NoSuchElementException("Not a right value");
    }

    public L failure() {
        if(isLeft()) return this.component1();
        throw new NoSuchElementException("Not a left value");
    }
}

final class Left<L,R> extends Either<L, R> {
    private final L left;
    public Left(final L left) {
        this.left = left;
    }

    @Override
    L component1() {
        return this.left;
    }

    @Override
    R component2() {
        return null;
    }

    @Override
    public String toString() {
        return "Left{" +
                "left=" + left +
                '}';
    }

    public <T> T recovery(Function<L, T> f) {
        return f.apply(this.left);
    }
}

final class Right<L,R> extends Either<L, R> {
    private final R right;
    public Right(final R right) {
        this.right = right;
    }

    @Override
    L component1() {
        return null;
    }

    @Override
    R component2() {
        return this.right;
    }

    @Override
    public String toString() {
        return "Right{" +
                "right=" + right +
                '}';
    }

    public <T> T map(Function<R, T> f) {
        return f.apply(this.right);
    }
}