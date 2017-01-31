package com.tistory.coderkoo.androideigen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EigenStartActivity extends AppCompatActivity {

    static{
        System.loadLibrary("eigenstart");
    }

    AppCompatEditText txt_m1_00;
    AppCompatEditText txt_m1_01;
    AppCompatEditText txt_m1_10;
    AppCompatEditText txt_m1_11;

    AppCompatEditText txt_m2_00;
    AppCompatEditText txt_m2_01;
    AppCompatEditText txt_m2_10;
    AppCompatEditText txt_m2_11;

    AppCompatEditText txt_m3_00;
    AppCompatEditText txt_m3_01;
    AppCompatEditText txt_m3_10;
    AppCompatEditText txt_m3_11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eigen_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_m1_00 = (AppCompatEditText)findViewById(R.id.mat1_00);
        txt_m1_01 = (AppCompatEditText)findViewById(R.id.mat1_01);
        txt_m1_10 = (AppCompatEditText)findViewById(R.id.mat1_10);
        txt_m1_11 = (AppCompatEditText)findViewById(R.id.mat1_11);

        txt_m2_00 = (AppCompatEditText)findViewById(R.id.mat2_00);
        txt_m2_01 = (AppCompatEditText)findViewById(R.id.mat2_01);
        txt_m2_10 = (AppCompatEditText)findViewById(R.id.mat2_10);
        txt_m2_11 = (AppCompatEditText)findViewById(R.id.mat2_11);

        txt_m3_00 = (AppCompatEditText)findViewById(R.id.mat3_00);
        txt_m3_01 = (AppCompatEditText)findViewById(R.id.mat3_01);
        txt_m3_10 = (AppCompatEditText)findViewById(R.id.mat3_10);
        txt_m3_11 = (AppCompatEditText)findViewById(R.id.mat3_11);

        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mulMat();
            }
        });
    }

    private void mulMat(){

        //Read Matrix M1, M2
        int m1[] = {Integer.parseInt(txt_m1_00.getText().toString()),
                Integer.parseInt(txt_m1_01.getText().toString()),
                Integer.parseInt(txt_m1_10.getText().toString()),
                Integer.parseInt(txt_m1_11.getText().toString())};

        int m2[] = {Integer.parseInt(txt_m2_00.getText().toString()),
                Integer.parseInt(txt_m2_01.getText().toString()),
                Integer.parseInt(txt_m2_10.getText().toString()),
                Integer.parseInt(txt_m2_11.getText().toString())};


        //Calculate M1*M2 = M3
        int m3[] = matrixAddFromEigen(m1,m2);
        txt_m3_00.setText(m3[0]+"");
        txt_m3_01.setText(m3[1]+"");
        txt_m3_10.setText(m3[2]+"");
        txt_m3_11.setText(m3[3]+"");
    }

    public native int[] matrixAddFromEigen(int[] m1, int[] m2);


}
