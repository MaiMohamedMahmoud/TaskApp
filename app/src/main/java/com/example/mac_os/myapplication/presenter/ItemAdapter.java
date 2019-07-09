package com.example.mac_os.myapplication.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mac_os.myapplication.R;
import com.example.mac_os.myapplication.model.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>  {

    private int listItemLayout;
    private ArrayList<Item> item_list;
    // Constructor of the class
    public ItemAdapter(int layoutId, ArrayList<Item> itemList) {
        listItemLayout = layoutId;
        this.item_list = itemList;
    }
    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItemLayout, viewGroup, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder viewHolder, int i) {
        TextView item = viewHolder.item;
        Log.i("Binding",item_list.get(i).getName() +"");
        item.setText(item_list.get(i).getName().toString());
    }

    @Override
    public int getItemCount() {
        if(item_list == null){
            return 0;
        }
        else
        {
           return item_list.size();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView item ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.row_item);
        }
    }
}
