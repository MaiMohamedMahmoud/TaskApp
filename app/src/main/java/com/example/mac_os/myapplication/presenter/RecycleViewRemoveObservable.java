package com.example.mac_os.myapplication.presenter;

import com.example.mac_os.myapplication.model.Item;

import java.util.ArrayList;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class RecycleViewRemoveObservable implements ObservableOnSubscribe {

    private ArrayList<Item> arrayList;

    public RecycleViewRemoveObservable(ArrayList<Item> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void subscribe(ObservableEmitter emitter) throws Exception {
        try {
            emitter.onNext(this.arrayList);
        } catch (Exception e) {
            emitter.onError(e);
        }
    }
}
