package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    EditText name;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Intent i=getIntent();
        if(i.hasExtra("knoxID")){
            name=findViewById(R.id.name);
            btn=findViewById(R.id.sendbtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String actualName=name.getText().toString();
                    if(actualName.isEmpty()){
                        Toast.makeText(NameActivity.this,"Please enter your correct name",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Intent i=new Intent();
                        i.putExtra("name",actualName);
                        setResult(1,i);
                        finish();
                    }
                }
            });
        }
    }
}