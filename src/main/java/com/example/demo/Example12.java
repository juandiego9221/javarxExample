package com.example.demo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Example12 {
    public static void main(String[] args) {
//IMPLEMENTACION FRIA
//        Observable<String> source = Observable.just("xxx1", "xxdsad", "asda");
//        source.subscribe(System.out::println);
//        source.subscribe(System.out::println);

//        IMPLEMENTACION FRIA PERO TRANSFORMADA A CALIENTE
//        ConnectableObservable<String> source = Observable.just("xxx1", "xxdsad", "asda").publish();
//        source.subscribe(x -> System.out.println("Observer 1: " + x));
//        source.map(String::length).subscribe(x -> System.out.println("Observer 2: " + x));
//        source.connect();

        //IMPLEMENTACION POR RANGO
//        Observable.range(5, 9).subscribe(integer -> System.out.println("number: " + integer));

        //IMPLEMENTACION POR INTERVALO
//        Observable
//                .interval(1, TimeUnit.SECONDS)
//                .subscribe(integer ->
//                        System.out.println(LocalDateTime.now().getSecond() + " " + integer + ""));

        //MULTIMPLE OBSERVERS EN INTERVALO
//        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
//        seconds.subscribe(x -> System.out.println("Observer1: " + x));
//        sleep(3000);
//        seconds.subscribe(x -> System.out.println("Observer2: " + x));
//        sleep(3000);
    }


//    private static void sleep(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
}
