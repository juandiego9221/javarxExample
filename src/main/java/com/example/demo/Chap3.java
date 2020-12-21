package com.example.demo;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Chap3 {
    public static void main(String[] args) {
        Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);
        secondIntervals.subscribe(System.out::println);
        sleep(5000);
    }

    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
