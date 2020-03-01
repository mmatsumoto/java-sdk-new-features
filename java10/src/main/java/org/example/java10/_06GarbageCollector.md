### G1GC Improvements


Java 9 made the Garbage-First Garbage Collector (G1GC) the default, replacing the Concurrent Mark-Sweep Garbage Collector (CMS). Java 10 introduces performance improvements to G1GC.

In Java 10, G1GC is getting a performance boost with the introduction of full parallel processing  during a Full GC. This change won’t help the best-case performance times of the garbage collector, but it does significantly reduce the worst-case latencies. This makes pauses for garbage collection far less stressful on application performance.

When concurrent garbage collection falls behind, it triggers a Full GC collection. The performance improvement modifies the full collection so that it is no longer single-threaded, which significantly reduces the time needed to do a full garbage collection.