package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Example10 {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("x1", "xsdas", "sdasd");
        source.subscribe(x -> System.out.println("Observable1: " + x));
        source.map(String::length).filter(x -> x > 2).subscribe(x -> System.out.println("Observer2: " + x));
    }
}
