package org.example.java14;

public class _01Switch {

    private static String getAnimal1(String sound) {
        return switch(sound) {
                case "meaw" -> "cat";
                case "huff", "au", "woof" -> {
                    System.out.println("Looks like a dog");
                    yield "dog";
                }
                default -> throw new IllegalStateException("Unexpected value!");
            };
    }

    enum Sound {
        MEAW, HUFF, WOOF;
    }

    //Exhaustiveness
    private static String getAnimal2(Sound sound) {
        return switch(sound) {
            case MEAW -> "cat 2";
            case HUFF, WOOF -> "dog 2";
            // no need for default, all cases covered
            // default -> throw new IllegalStateException("Unexpected value!");
        };
    }

    private static int getAnimal(Sound sound) {
        return switch (sound) {
            case MEAW -> 0;
            case HUFF -> 1;
            default -> {
                // block of code
                int result = sound.ordinal() * 2;
                System.out.println("I did something before yield");
                yield  result;
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(getAnimal1("meaw"));
        System.out.println(getAnimal1("huff"));
        System.out.println(getAnimal1("woof"));
        System.out.println(getAnimal1("au"));

        try {
            System.out.println(getAnimal1("Hallo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(getAnimal2(Sound.HUFF));
    }

}
