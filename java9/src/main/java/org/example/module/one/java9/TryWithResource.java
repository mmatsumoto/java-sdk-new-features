package org.example.module.one.java9;

/**
 * 4) TryWithResource - AutoCloseable
 */
class TryWithResource {
    static class Resource implements AutoCloseable {
        public Resource() {
            System.out.println("Resource created!");
        }

        public void op1() {
            System.out.println("op1 invoked");
        }

        @Override
        public void close() {
            System.out.println("Resource cleanup!");
        }
    }

    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            resource.op1();
        }
        // or
        // try(resource) { ... }
    }
}
