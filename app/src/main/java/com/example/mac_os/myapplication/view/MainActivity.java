package com.example.mac_os.myapplication.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mac_os.myapplication.model.Item;
import com.example.mac_os.myapplication.presenter.Consumer;
import com.example.mac_os.myapplication.presenter.ItemAdapter;
import com.example.mac_os.myapplication.R;
import com.example.mac_os.myapplication.presenter.Producer;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView rv_list;
    Button btnLeft;
    Button btnRight;
    ArrayList<Item> list;
    ItemAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_list = (RecyclerView) findViewById(R.id.list);

        btnLeft = (Button) findViewById(R.id.btn_left);
        btnRight = (Button) findViewById(R.id.btn_right);

        list = new ArrayList<>();
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Producer producer = new Producer(list, itemArrayAdapter);
                        Item listItem = new Item("new item to be added");
                        producer.produce(listItem);
                        handler.postDelayed(this, 3000);
                    }
                }, 3000);

            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        if (list != null && list.size() > 0) {
                            Consumer consumer = new Consumer(list, itemArrayAdapter, getApplicationContext());
                            consumer.consume(list);
                        } else {
                            Toast.makeText(getApplicationContext(), "You Have To Add Some Thing in the list to Delete it", Toast.LENGTH_SHORT).show();
                        }

                        handler.postDelayed(this, 4000);
                    }
                }, 4000);

            }
        });


        itemArrayAdapter = new ItemAdapter(R.layout.list_item, list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(itemArrayAdapter);


    }

}