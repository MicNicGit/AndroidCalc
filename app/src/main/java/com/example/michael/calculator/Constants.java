package com.example.michael.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Constants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constants);
    }

    public void onClick(View v) {
        Button b = (Button)v;
        Intent resultIntent = new Intent();
        resultIntent.putExtra("chosenCharacter",b.getText());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public String constToString(Button b) {
        switch ((String)b.getText()){
            case "\u03c0": //pi
                return "3.141592653589793";
                break;
            case "e":
                return "2.718281828459045";
                break;
            case "\u03D5": //phi (golden ratio)
                return "1.618033988749894";
                break;
            case "c":
                return ""
            case "G":
        }
    }
}
