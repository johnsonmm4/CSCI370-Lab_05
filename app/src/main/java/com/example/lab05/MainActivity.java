package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView currName;
    EditText newNameInput;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currName = findViewById(R.id.currName);
        newNameInput = findViewById(R.id.newNameInput);
        confirmButton = findViewById(R.id.confirmButton);

        final SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor myEditor = sharedPreferences.edit();

        String defaultName = "Default";
        if(sharedPreferences.getString("name", null) == null){
            currName.setText(defaultName);
        }
        else{
            String temp = sharedPreferences.getString("name", null);
            currName.setText(temp);
        }


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = newNameInput.getText().toString();
                currName.setText(newName);
                
                myEditor.putString(newName, "name");
                myEditor.apply();
            }
        });
    }
}
