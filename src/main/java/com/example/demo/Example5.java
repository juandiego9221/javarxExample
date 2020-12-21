package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Example5 {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("xxxxxxx1", "xx2", "xx3");
        source
                .map(String::length).filter(x -> x >= 5)
                .subscribe(s -> System.out.println("received: " + s));
    }
}
