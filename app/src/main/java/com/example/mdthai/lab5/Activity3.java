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
public class Activity3 extends AppCompatActivity {


    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);
        value = getString(R.string.nodata);

    }

    public void launchBtn(View view)
    {
        Button btn = (Button) view;
        Intent intent = null;
        int request;
        if (btn.getId() == R.id.act3_btn1) {
            intent = new Intent(this, Activity4.class);
            request = 4;
        }
        else {
            intent = new Intent(this, Activity5.class);
            request = 5;
        }
        startActivityForResult(intent, request);
    }

    public void onActivityResult(int request, int result, Intent i)
    {
        Log.d("Act3 request", request + "");
        Log.d("Act3 result", result + "");


        if (result == RESULT_OK)
        {
            if(request == 4){
                if(i.hasExtra("Act4"))
                {
                    value = i.getExtras().getString("Act4");
                    if (value == null)
                    {
                        value = "MISSING DATA";
                    }
                }

            }
            else if (request == 5)
            {
                if(i.hasExtra("Act5"))
                {
                    value = i.getExtras().getString("Act5");
                    if (value == null)
                    {
                        value = "MISSING DATA";
                    }
                }


            }
            else
            {
                value = "UNKNOWN";
            }
        }
        else
        {
            value = getString(R.string.nodata);
        }

    }


    @Override
    public void finish(){


        Intent i = new Intent();
        Log.d("Act3", value);

        if (value != null)
            i.putExtra("Act3",value);
        else
            i.putExtra("Act3", getString(R.string.nodata));

        setResult(RESULT_OK);


        Log.d("Act3", ""+ i);

        super.finish();

    }
}
