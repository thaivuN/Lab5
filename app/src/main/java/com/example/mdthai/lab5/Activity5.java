package com.example.mdthai.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MDThai on 9/28/2016.
 */
public class Activity5 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_main);
    }

    @Override
    public void finish(){
        Intent i = new Intent();
        i.putExtra("Act5","Dave. I'm afraid I can't do that.");
        setResult(RESULT_CANCELED);

        super.finish();

    }
}
