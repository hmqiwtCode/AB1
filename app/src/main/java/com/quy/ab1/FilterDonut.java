package com.quy.ab1;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterDonut extends Filter {
    private ArrayList<Donut> listDonutOriginal;
    private AdapterDonut adapter;

    public FilterDonut(ArrayList<Donut> listDonutOriginal,AdapterDonut adapter){
        this.listDonutOriginal = listDonutOriginal;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        ArrayList<Donut> listResults;
        if (charSequence.length() == 0){
            listResults = listDonutOriginal;
        }else {
            listResults = getResult(charSequence.toString().toLowerCase());
        }
        FilterResults results = new FilterResults();
        results.count = listResults.size();
        results.values = listResults;
        return results;
    }

    private ArrayList<Donut> getResult(String value){
        ArrayList<Donut> result = new ArrayList<>();
        for (Donut donut : listDonutOriginal){
            if (donut.getHeader().toLowerCase().contains(value) || donut.getDescription().toLowerCase().contains(value)){
                result.add(donut);
            }
        }
        return result;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.arrDonut = (ArrayList<Donut>) filterResults.values;
        adapter.notifyDataSetChanged();
    }
}
