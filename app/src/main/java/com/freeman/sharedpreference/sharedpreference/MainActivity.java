package com.freeman.sharedpreference.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputName, inputEmail;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputName = (EditText) findViewById(R.id.input_name);
        saveButton = (Button) findViewById(R.id.save_btn);
        saveButton.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("USER_DATA",MODE_PRIVATE);
        inputName.setText(sharedPreferences.getString("NAME", ""));
        inputEmail.setText(sharedPreferences.getString("EMAIL", ""));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_btn){
            SharedPreferences sharedPreferences = getSharedPreferences("USER_DATA", MODE_PRIVATE); // "USER_DATA" - имя файла (он же и ключ)
            SharedPreferences.Editor editor = sharedPreferences.edit(); // Открытие на редакцию
            editor.putString("NAME", String.valueOf(inputName.getText()));
            editor.putString("EMAIL", String.valueOf(inputEmail.getText()));
            editor.commit();
        }
    }
}
