package com.example.demo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

public class Example8 {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("xxx1", "xx2", "xxx3sasd");
        source.map(String::length)
                .filter(x -> x > 5)
                .subscribe(x -> System.out.println("receivded " + x),
                        Throwable::printStackTrace, () -> System.out.println("Done")
                );
    }
}
