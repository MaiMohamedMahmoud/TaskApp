package com.example.mac_os.myapplication.presenter;


import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;

import com.example.mac_os.myapplication.model.Item;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RecycleViewRemoveObserver implements Observer {

    private ArrayList<Item> arrayList;
    private ItemAdapter itemAdapter;
    Context context;

    public RecycleViewRemoveObserver(ArrayList<Item> arrayList, ItemAdapter itemAdapter,Context context) {
        this.arrayList = arrayList;
        this.itemAdapter = itemAdapter;
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("onSubscribe");
        System.out.println("Item Deleted");
        if (this.arrayList != null && this.arrayList.size() > 0) {
            this.arrayList.remove(arrayList.size() - 1);
            this.itemAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(context, "You Have To Add Some Thing in the list to Delete it", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNext(Object o) {
        System.out.println("onNext: " + o.toString());
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
