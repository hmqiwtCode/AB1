package com.quy.ab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetail extends Fragment {
    TextView header;
    TextView des;
    TextView prices;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.detail_fragment,container,false);
        header = view.findViewById(R.id.textView9);
        des = view.findViewById(R.id.textView10);
        prices = view.findViewById(R.id.textView11);
        imageView = view.findViewById(R.id.imageView2);
        if(getArguments().containsKey("data")) {
            Donut donut = (Donut) getArguments().getSerializable("data");
            header.setText(donut.getHeader());
            des.setText(donut.getDescription());
            prices.setText(donut.getPrices());
            imageView.setImageResource(donut.getImage());
        }
        return view;
    }
}
