package com.quy.ab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame_rv;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RecyclerView recyclerView;

    private EditText searchDonut;
    private ImageButton btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        frame_rv = findViewById(R.id.rv_donut);
        searchDonut = findViewById(R.id.editTextTextPersonName);
        btn_search = findViewById(R.id.button);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        final FragmentDonut fragmentDonut = new FragmentDonut();
        fragmentTransaction.add(frame_rv.getId(),fragmentDonut);
        fragmentTransaction.commit();
        recyclerViewHorizon();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentDonut.adapter.getFilter().filter(searchDonut.getText().toString());
            }
        });

    }

    private void recyclerViewHorizon(){
        ArrayList<String> nameDonut = new ArrayList<>();
        nameDonut.add("Donut");
        nameDonut.add("Pink Donut");
        nameDonut.add("Mess Donut");
        nameDonut.add("Hot Donut");

        AdapterItemName adapter = new AdapterItemName(this,nameDonut);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);

    }
}
