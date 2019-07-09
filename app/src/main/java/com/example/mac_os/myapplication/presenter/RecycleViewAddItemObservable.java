package com.example.mac_os.myapplication.presenter;

import com.example.mac_os.myapplication.model.Item;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class RecycleViewAddItemObservable implements ObservableOnSubscribe {

    private Item listItem;

    public RecycleViewAddItemObservable(Item listItem) {
        this.listItem = listItem;
    }

    @Override
    public void subscribe(ObservableEmitter emitter) throws Exception {
        try {
            emitter.onNext(this.listItem);
        } catch (Exception e) {
            emitter.onError(e);
        }
    }
}
