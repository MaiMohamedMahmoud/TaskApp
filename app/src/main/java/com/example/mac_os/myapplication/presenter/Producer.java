package com.example.mac_os.myapplication.presenter;

import android.util.Log;

import com.example.mac_os.myapplication.model.Item;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Producer {


    private ArrayList<Item> recycleViewItemsList;
    private ItemAdapter itemAdapter;

    public Producer(ArrayList<Item> recycleViewItemsList, ItemAdapter itemAdapter) {
        this.recycleViewItemsList = recycleViewItemsList;
        this.itemAdapter = itemAdapter;
    }


    private RecycleViewAddItemObserver getObserver() {
        return new RecycleViewAddItemObserver(this.recycleViewItemsList, this.itemAdapter);
    }

    private RecycleViewAddItemObservable getObservable(Item listItem) {
        return new RecycleViewAddItemObservable(listItem);
    }

    public void produce(Item listItem) {
        Observable observable = Observable.create(this.getObservable(listItem));
        observable.subscribe(this.getObserver());
    }
}