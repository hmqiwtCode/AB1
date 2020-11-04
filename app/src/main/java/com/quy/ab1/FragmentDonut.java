package com.quy.ab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentDonut extends Fragment {

    RecyclerView real_rv;
    AdapterDonut adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.fragment_donut,container,false);
        real_rv = view.findViewById(R.id.real_rv);

        ArrayList<Donut> arrDonut = new ArrayList<>();
        arrDonut.add(new Donut(R.drawable.donut,"Pink Donut", "So delicious","$10.00"));
        arrDonut.add(new Donut(R.drawable.donut1,"Tasty Donut", "So good","$90.00"));
        arrDonut.add(new Donut(R.drawable.donut2,"Pink Donut", "So cool","$7.00"));
        arrDonut.add(new Donut(R.drawable.donut3,"Test Donut", "So handsome","$9.00"));
        arrDonut.add(new Donut(R.drawable.donut2,"Vip Donut", "So fresh","$10.00"));
        arrDonut.add(new Donut(R.drawable.donut1,"Get Donut", "So mess","$10.00"));
        arrDonut.add(new Donut(R.drawable.donut,"Haizz Donut", "So cool","$10.00"));
        arrDonut.add(new Donut(R.drawable.donut3,"Hey Donut", "So so","$10.00"));
        arrDonut.add(new Donut(R.drawable.donut1,"Hihi Donut", "So so too","$10.00"));
        adapter = new AdapterDonut(getActivity(),arrDonut);
        real_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        real_rv.setAdapter(adapter);
        return view;
    }
}
