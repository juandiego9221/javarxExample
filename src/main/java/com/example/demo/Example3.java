package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Example3 {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("x1");
                emitter.onNext("xxxxxxx2");
                emitter.onNext("xxx3");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        Observable<Integer> lengths = source.map(String::length);
        Observable<Integer> filtered = lengths.filter(integer -> integer >= 5);
        filtered.subscribe(s -> System.out.println("received: " + s));
    }
}
