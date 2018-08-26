package com.ritikgupta.textanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextAnimation textAnimation;
    EditText editText;
    RadioGroup radioGroup;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit);
        radioGroup = findViewById(R.id.radiogrp);
        Integer[] delay = new Integer[]{0, 10, 25, 50, 70, 80, 100, 150, 200, 300, 500, 750, 900, 1000, 1300, 1500, 2000, 2500, 2800, 3000, 3500, 4000, 5000};

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,delay);
        spinner.setAdapter(adapter);

        textAnimation = findViewById(R.id.text);
        Button button = findViewById(R.id.play);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textAnimation.setDelay(Long.parseLong(spinner.getSelectedItem().toString()));

                if (radioGroup.getCheckedRadioButtonId() == R.id.type1)
                    textAnimation.animateText(editText.getText().toString(), TextAnimation.CharWiseTransition);
                if (radioGroup.getCheckedRadioButtonId() == R.id.type2)
                    textAnimation.animateText(editText.getText().toString(), TextAnimation.WordWiseTransition);

            }
        });

    }
}
