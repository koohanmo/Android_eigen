package com.tistory.coderkoo.androideigen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tistory.coderkoo.androideigen.adapter.EigenRecyclerAdapter;
import com.tistory.coderkoo.androideigen.model.EigenOperation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<EigenOperation> dataSet;
    EigenRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeData();

        mAdapter = new EigenRecyclerAdapter(this,dataSet);
        mRecyclerView = (RecyclerView)findViewById(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }


    private void makeData(){
        dataSet= new ArrayList<>();
        dataSet.add(new EigenOperation("NDK_initial_code","used string to JNI",NdkinitialActivity.class));
        dataSet.add(new EigenOperation("Simple first program with Eigen","simple matrix +operation",EigenStartActivity.class));
    }

}
