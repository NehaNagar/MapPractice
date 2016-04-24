package com.ranunagar.mappractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void addDetails(View v)
    {

        EditText name = (EditText) findViewById(R.id.editText1);
        EditText contact = (EditText) findViewById(R.id.editText3);
        EditText address = (EditText) findViewById(R.id.editText2);

        String name1 = name.getText().toString();
        String contact1 = contact.getText().toString();
        String address1 = address.getText().toString();

        //now will insert details in database
      Contacts c = new Contacts();
        c.setName(name1);
        c.setAddress(address1);
        c.setContact(contact1);
        helper.insertContact(c);
    }
}
