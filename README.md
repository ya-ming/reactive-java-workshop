# Reactive Programming

## Why?
* Compare to concurrency APIs (Future and CompletatbleFuture)
    * Much simpler than the manual concurrent way
    * Few reusable flexible functions
    * Combine and reuse in powerful ways

## Stream
* Represent a sequence of data
* Focus on computations
* vs collections which focus on storage
* Internal iteration

* Operators
    * map
    * filter
    * flatMap
    * findFirst
    * ... and many more

## Design Patterns
* Iterator
* Observer

## Reactive Streams
* subscribe - the glue that connects an observer to an Observable
* publisher and subscriber

###
* Flux - async sequence of events, return 0 or n times
* Mono - async item, return 0 or 1 time

### What's coming?
* An item
* A complete event, a terminate event
* A failure event, a terminate event

* Operators
    * filter
    * map
    * defaultIfEmpty
    * log
        ```java
            List<Integer> numbers = ReactiveSources
            .intNumbersFlux()
            .log()
            .toStream()
            .collect(Collectors.toList());
        ```
        ```
        [ INFO] (main) onSubscribe(FluxConcatMap.ConcatMapImmediate)
        [ INFO] (main) request(256)
        [ INFO] (parallel-1) onNext(1)
        [ INFO] (parallel-2) onNext(2)
        [ INFO] (parallel-3) onNext(3)
        [ INFO] (parallel-4) onNext(4)
        [ INFO] (parallel-5) onNext(5)
        [ INFO] (parallel-6) onNext(6)
        [ INFO] (parallel-7) onNext(7)
        [ INFO] (parallel-8) onNext(8)
        [ INFO] (parallel-9) onNext(9)
        [ INFO] (parallel-10) onNext(10)
        [ INFO] (parallel-10) onComplete()
        ```
    * subscribe

## Return values

## Error
* Terminal event
* Original sequence does not continue
* Calls the `onError` method of the Subscriber