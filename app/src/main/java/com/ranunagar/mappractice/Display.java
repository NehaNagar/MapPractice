package com.ranunagar.mappractice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by nehan_000 on 21-04-2016.
 */
public class Display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
String address = getIntent().getStringExtra("Address");
        TextView tv = (TextView)findViewById(R.id.TVaddress);
        tv.setText(address);
    }

}
