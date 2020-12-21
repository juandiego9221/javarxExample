package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

public class Chap2 {
    public static void main(String[] args) {
        Observable<String> myString2 = Observable.just("xxxxxx1", "x2", "xxx3");
        myString2.map(String::length).subscribe(System.out::println);
    }
}
