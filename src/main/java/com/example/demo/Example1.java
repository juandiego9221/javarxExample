package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Example1 {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("x1");
            emitter.onNext("x2");
            emitter.onComplete();
        });
        source.subscribe(s -> System.out.println("received: " + s));
    }
}
