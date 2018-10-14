package com.example.djamel.tp1maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_LOCALITATION="com.example.djamel.tp1maps";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */


    public void getMaps(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);

        if(editText.getText().toString().trim().length()>0){
    Intent intent = new Intent(this, MapsActivity.class);
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_LOCALITATION, message);
    startActivity(intent);

}else Toast.makeText(this,"Add your place Search please!",Toast.LENGTH_LONG).show();

    }
}
