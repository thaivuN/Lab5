package com.example.mdthai.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by MDThai on 9/28/2016.
 */
public class Activity2 extends AppCompatActivity {

    boolean returnBtnHit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
    }

    public void returnMessage(View view)
    {
        Button btn = (Button) view;
        String message;
        if (btn.getId() == R.id.act2_btn1) {
            message = getString(R.string.act2_btn1);
            logMethod("Return Button 1");

        }
        else {
            message = getString(R.string.act2_btn2);
            logMethod("Return Button 2");
        }

        Intent i = new Intent();
        i.putExtra("Act2", message);
        setResult(RESULT_OK, i);
        returnBtnHit = true;
        finish();


    }

    @Override
    public void finish(){
        if(returnBtnHit == false)
        {
            Intent i = new Intent();
            i.putExtra("Act2",getString(R.string.nodata));
            setResult(RESULT_CANCELED, i);
        }

        super.finish();
    }

    public static void logMethod(String message){
        Log.d("Intent 2", message);
    }

}
