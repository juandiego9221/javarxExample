package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Example2 {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("x1");
                emitter.onNext("x2");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        source.subscribe(s -> System.out.println("received: " + s), Throwable::printStackTrace);
    }
}
