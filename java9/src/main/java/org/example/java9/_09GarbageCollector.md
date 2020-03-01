
### Garbage-First Garbage Collector (G1GC) 

The Garbage-First (G1) garbage collector is targeted for multiprocessor machines with a large amount of memory. It attempts to meet garbage collection pause-time goals with high probability while achieving high throughput with little need for configuration. G1 aims to provide the best balance between latency and throughput using current target applications and environments whose features include:

* Heap sizes up to ten of GBs or larger, with more than 50% of the Java heap occupied with live data.
* Rates of object allocation and promotion that can vary significantly over time.
* A significant amount of fragmentation in the heap.
* Predictable pause-time target goals that aren’t longer than a few hundred milliseconds, avoiding long garbage collection pauses.

G1 replaces the Concurrent Mark-Sweep (CMS) collector. It is also the default collector.

The G1 collector achieves high performance and tries to meet pause-time goals in several ways described in the following sections.


[More about G1GC](https://docs.oracle.com/javase/9/gctuning/garbage-first-garbage-collector.htm#JSGCT-GUID-0394E76A-1A8F-425E-A0D0-B48A3DC82B42)