package com.example.persistentstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        EditText firstTextField = (EditText) findViewById(R.id.username);
        String name = firstTextField.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.persistentstorage", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", name).apply();
        goToResult(name);
    }

    public void goToResult(String result) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.persistentstorage", Context.MODE_PRIVATE);
        if(!sharedPreferences.getString(usernameKey, "").equals("")) {
            String name = sharedPreferences.getString(usernameKey, "");
            goToResult(name);
        } else {
            setContentView(R.layout.activity_main);
        }


    }
}