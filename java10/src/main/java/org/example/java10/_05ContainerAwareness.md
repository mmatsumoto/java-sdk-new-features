### Container Awareness

The JVM now knows when it is running inside a Docker Container. This means the application now has accurate information about what the docker container allocates to memory, CPU, and other system resources.

Previously, the JVM queried the host operating system to get this information. This causes a problem when the docker container would actually like to advertise a different resource set.

For example, let’s say that you wanted to create a Java-based docker image where the running JVM was allocated 25 percent of the available memory specified by the container. On a box that has 2G of memory, running a container configured for 0.5G of memory, Java 9 and earlier would incorrectly calculate the Java process’s heap size based on the 2G number instead of 0.5G.

But, now, in Java 10, the JVM is capable of looking up this information from container control groups (cgroups), which is where Docker places these details.


[Dzone articles #whats-new-in-java-10](https://dzone.com/articles/whats-new-in-java-10)