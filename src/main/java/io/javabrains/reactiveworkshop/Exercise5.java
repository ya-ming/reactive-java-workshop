package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono()
                .subscribe(number -> System.out.println(number),
                            error -> System.out.println(error.getMessage()),
                            () -> System.out.println("Complete"));

        ReactiveSources.userMono()
                .subscribe(user -> System.out.println(user),
                            error -> System.out.println(error.getMessage()),
                            () -> System.out.println("Complete"));
                            
        ReactiveSources.userFlux()
                .subscribe(user -> System.out.println(user),
                            error -> System.out.println(error.getMessage()),
                            () -> System.out.println("Complete"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        // ask for 2 more
        request(2);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        // ask for 1 more
        request(1);
    }
}