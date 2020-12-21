package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class Example6 {
    public static void main(String[] args) {
        List<String> items = List.of("xx1", "dx2", "xxxx23123");
        Observable<String> source = Observable.fromIterable(items);
        source.map(String::length).filter(x -> x > 2).subscribe(s -> System.out.println("received:" + s));
    }
}
