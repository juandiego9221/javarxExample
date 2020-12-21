package com.example.demo;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Example7 {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("xx1", "xx2", "xx3");
        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("received: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        };
        source.map(String::length).filter(i -> i > 2).subscribe(myObserver);

    }
}
