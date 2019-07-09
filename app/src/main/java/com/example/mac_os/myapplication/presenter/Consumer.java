package com.example.mac_os.myapplication.presenter;


import android.content.Context;

import com.example.mac_os.myapplication.model.Item;

import java.util.ArrayList;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class Consumer {
    private ArrayList<Item> arrayList;
    private ItemAdapter itemAdapter;
    Context context;
    public Consumer( ArrayList<Item> arrayList,ItemAdapter itemAdapter,Context context) {
        this.arrayList = arrayList;
        this.itemAdapter = itemAdapter;
        this.context = context;

    }

    public RecycleViewRemoveObserver getRemoveObserver() {
        RecycleViewRemoveObserver recycleViewRemoveObserver = new RecycleViewRemoveObserver(this.arrayList,this.itemAdapter,context);
        return recycleViewRemoveObserver;
    }

    public RecycleViewRemoveObservable getRemoveObservable(ArrayList<Item> listItemsArray) {
        RecycleViewRemoveObservable recycleViewRemoveObservable = new RecycleViewRemoveObservable(listItemsArray);
        return recycleViewRemoveObservable;
    }

    public void consume(ArrayList<Item> listItemsArray) {
        Observable observable = Observable.create(this.getRemoveObservable(listItemsArray));

        observable.subscribe(this.getRemoveObserver());
    }
}