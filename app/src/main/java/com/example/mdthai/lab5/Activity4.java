package com.example.mdthai.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by MDThai on 9/28/2016.
 */
public class Activity4 extends AppCompatActivity {


    boolean hasReturnBtn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_main);

    }

    public void submit(View view){
        EditText input = (EditText) findViewById(R.id.act4_input);
        String value = input.getText().toString();

        if (value != null && value.isEmpty() == false)
        {
            Intent i = new Intent();
            i.putExtra("Act4", value);
            setResult(RESULT_OK, i);
            hasReturnBtn = true;

            finish();
        }

    }

    @Override
    public void finish(){

        if (hasReturnBtn == false)
        {
            Intent i = new Intent();
            i.putExtra("Act4", "Cancelled return");
            setResult(RESULT_CANCELED);
        }
        super.finish();


    }
}
