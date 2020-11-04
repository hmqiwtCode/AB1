package com.quy.ab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    private FrameLayout frame_rv;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Donut donut = (Donut) intent.getSerializableExtra("data");
        frame_rv = findViewById(R.id.frameLayout);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        FragmentDetail fragmentDetail = new FragmentDetail();

        Bundle bundle = new Bundle();
        bundle.putSerializable("data",donut);
        fragmentDetail.setArguments(bundle);

        fragmentTransaction.add(frame_rv.getId(),fragmentDetail);
        fragmentTransaction.commit();
    }
}