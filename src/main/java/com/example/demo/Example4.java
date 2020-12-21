package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Example4 {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("x1");
                emitter.onNext("xxxxxx2");
                emitter.onNext("xxx3");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        source
                .map(String::length)
                .filter(value -> value >= 5)
                .subscribe(s -> System.out.println("received: " + s));
    }
}
