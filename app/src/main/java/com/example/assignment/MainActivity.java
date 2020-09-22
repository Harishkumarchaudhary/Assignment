package com.example.assignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText txt;
    TextView textView;
    Button impbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.knoxid);
        textView=findViewById(R.id.nameText);
        impbtn=findViewById(R.id.impbtn);
        impbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String knoxID=txt.getText().toString();
                if(knoxID.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter your knoxID to get Name",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(MainActivity.this, NameActivity.class);
                    i.putExtra("knoxID",knoxID);
                    startActivityForResult(i,1);
                }
            }
        });
        Log.d("onCreate","onCreate Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart","onStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","onResume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","onPause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop","onStop Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy Called");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(data.hasExtra("name")) {
                String name = data.getStringExtra("name");
                textView.setText(name);
            }
        }
    }

    //Implicit Intent Example

    private void sendData() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Choose App which can handle text type data");
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }
}