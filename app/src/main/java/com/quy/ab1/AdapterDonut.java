package com.quy.ab1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDonut extends RecyclerView.Adapter<AdapterDonut.ItemView> implements Filterable {

    private Context context;
    ArrayList<Donut> arrDonut;
    FilterDonut filterDonut;

    public AdapterDonut(Context ctx, ArrayList<Donut> arrDonut){
        this.context = ctx;
        this.arrDonut = arrDonut;
    }



    @NonNull
    @Override
    public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_donut,parent,false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemView holder, int position) {
        final Donut donut = arrDonut.get(position);
        holder.img_Donut.setImageResource(donut.getImage());
        holder.header.setText(donut.getHeader());
        holder.description.setText(donut.getDescription());
        holder.prices.setText(donut.getPrices());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Detail.class);
                intent.putExtra("data",donut);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrDonut.size();
    }

    @Override
    public Filter getFilter() {
        if (filterDonut == null){
            filterDonut = new FilterDonut(arrDonut,this);
        }
        return filterDonut;
    }

    class ItemView extends RecyclerView.ViewHolder{
        private ImageView img_Donut;
        private TextView header;
        private TextView description;
        private TextView prices;
        private Button add;

        public ItemView(@NonNull View view) {
            super(view);
            img_Donut = view.findViewById(R.id.image_donut);
            header = view.findViewById(R.id.tv_header);
            description = view.findViewById(R.id.tv_des);
            prices = view.findViewById(R.id.tv_prices);
            add = view.findViewById(R.id.btn_add_quantity);
        }
    }
}
