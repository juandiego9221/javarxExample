package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Chap1 {
    public static void main(String[] args) {
        Observable<String> myStrings = Observable.just("ALpha", "Beta", "Gamma");
        myStrings.subscribe(System.out::println);
    }
}
