package com.example.mac_os.myapplication.presenter;

import com.example.mac_os.myapplication.model.Item;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class RecycleViewAddItemObserver implements Observer {

    private ArrayList<Item> recycleViewItemsList;
    private ItemAdapter itemAdapter;

    public RecycleViewAddItemObserver(ArrayList<Item> recycleViewItemsList, ItemAdapter itemAdapter) {
        this.recycleViewItemsList = recycleViewItemsList;
        this.itemAdapter = itemAdapter;
    }

    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("onSubscribe");
    }

    @Override
    public void onNext(Object o) {
        System.out.println("onNext: " + o.toString());
        this.recycleViewItemsList.add((Item) o);
        this.itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("onError: " + e.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
