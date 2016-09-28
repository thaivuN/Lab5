package com.example.mdthai.lab5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = (TextView)findViewById(R.id.act1_result);

    }

    public void launchAct2(View view)
    {
       Intent i = new Intent(this, Activity2.class);

        logMethod("Launching Activity 2");
        startActivityForResult(i, 0);

    }

    public void launchAct3(View view)
    {
        Intent i = new Intent(this, Activity3.class);

        logMethod("Launching Activity 3");
        startActivityForResult(i, 0);
    }

    public void launchBrowser(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.ca/"));
        startActivity(intent);
    }

    public void launchGeo(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="));
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int request, int result, Intent i)
    {

        String value = "No return";

        if (result == RESULT_OK){
            if (i != null)
            {
                if(i.hasExtra("Act2"))
                {
                    value = i.getExtras().getString("Act2");
                }
                else
                {
                    value = "No Activity data";
                }

            }
        }
        else
        {
            value = "Cancel return";
        }

        resultView.setText(value);

    }


    public static void logMethod(String message){
        Log.d("Intent 1", message);
    }



}
