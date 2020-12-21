package com.example.demo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

public class Example9 {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("xx1", "xx2", "xx3");
        source.subscribe(x -> System.out.println("observer1: " + x));
        source.subscribe(x -> System.out.println("observer2: " + x));
    }
}
