package com.quy.ab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterItemName extends RecyclerView.Adapter<AdapterItemName.ItemName> {
    private Context context;
    private ArrayList<String> arrName;

    public AdapterItemName(Context context,ArrayList<String> arrName){
        this.context = context;
        this.arrName = arrName;
    }

    @NonNull
    @Override
    public ItemName onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemName(LayoutInflater.from(context).inflate(R.layout.itemname,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemName holder, int position) {
        holder.name.setText(arrName.get(position));
    }

    @Override
    public int getItemCount() {
        return arrName.size();
    }

    class ItemName extends RecyclerView.ViewHolder{
        TextView name;
        public ItemName(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView3);
        }
    }
}
