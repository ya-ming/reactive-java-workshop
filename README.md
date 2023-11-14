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