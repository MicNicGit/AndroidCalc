package com.example.michael.calculator;

import android.content.Intent;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public Calculator calc;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = Calculator.getInstance();
        t = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                t.setText(calc.inputConst(data.getStringExtra("chosenCharacter")));
            }
        }
    }

    public void pickConstant(View v) {
        Intent pickConstantIntent = new Intent(this, Constants.class);
        startActivityForResult(pickConstantIntent, 1);
    }

    public void onClick(View v) {

        //TextView dBug = (TextView) findViewById(R.id.textView2);
        Button b = (Button) v;

        switch ((String) b.getText()) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                /*if(num1.isEmpty() && !num2.isEmpty()){ //Displaying an Answer, needs to clear
                    num2 = "";
                }
                if (onStringOne){ //On first number
                    num1 = num1 + b.getText();
                    t.setText(num1);
                }
                else if (!onStringOne){ //On second number
                    num2 = num2 + b.getText();
                }
                updateText(t,num1,num2,oper);*/
                t.setText(calc.addDigit((String) b.getText()));
                break;
            case ".":
                /*if(num1.isEmpty() && !num2.isEmpty()){ //Displaying an Answer, needs to clear
                    num2 = "";
                }
                if(onStringOne) {
                    if(!num1.contains(".")) {
                        num1 = num1 + ".";
                    }
                }
                else if(!oper.isEmpty() && !num2.contains(".")) {
                    num2 = num2 + ".";
                }
                updateText(t,num1,num2,oper);*/
                t.setText(calc.addPeriod());
                break;
            /*case "–":
                if(num1.isEmpty() && !num2.isEmpty())
                {
                    num1 = num2;
                    num2 = "";
                }
                if(oper.isEmpty() && !num1.isEmpty()){
                    oper = "-";
                    onStringOne = false;
                }
                updateText(t,num1,num2,oper);
                break;
            case "*":
                if(num1.isEmpty() && !num2.isEmpty())
                {
                    num1 = num2;
                    num2 = "";
                }
                if(oper.isEmpty() && !num1.isEmpty()){
                    oper = "*";
                    onStringOne = false;
                }
                updateText(t,num1,num2,oper);
                break;
            case "÷":
                if(num1.isEmpty() && !num2.isEmpty())
                {
                    num1 = num2;
                    num2 = "";
                }
                if(oper.isEmpty() && !num1.isEmpty()){
                    oper = "/";
                    onStringOne = false;
                }
                updateText(t,num1,num2,oper);
                break;
            case "+":
                if(num1.isEmpty() && !num2.isEmpty())
                {
                    num1 = num2;
                    num2 = "";
                }
                if(oper.isEmpty() && !num1.isEmpty()){
                    oper = "+";
                    onStringOne = false;
                }
                updateText(t,num1,num2,oper);
                break;*/
            case "-":
            case "*":
            case "÷":
            case "+":
                t.setText(calc.addOper((String) b.getText()));
                break;
            case "⌫":
                /*if(onStringOne && !num1.isEmpty()) {
                    num1 = num1.substring(0, num1.length()-1);
                }
                else if(!onStringOne && num2.isEmpty() && !oper.isEmpty()) {
                    oper = "";
                    onStringOne = true;
                }
                else if(!onStringOne && !oper.isEmpty()){
                    num2 = num2.substring(0, num2.length()-1);
                }
                updateText(t,num1,num2,oper);*/
                t.setText(calc.backspace());
                break;
            case "Clear":
                /*num1 = "";
                num2 = "";
                oper = "";
                onStringOne = true;
                updateText(t,num1,num2,oper);*/
                calc.clear();
                t.setText("");
                break;
            case "=":
                /*if (!num1.isEmpty() && !num2.isEmpty()) {
                    boolean isInt;
                    if (!num1.contains(".") && !num2.contains(".")) {
                        isInt = true;
                    } else {
                        isInt = false;
                        if (!num1.contains(".")) {
                            num1 = num1 + ".0";
                        }
                        if (!num2.contains(".")) {
                            num2 = num2 + ".0";
                        }
                    }

                    switch (oper) {
                        case "+":
                            if (isInt) {
                                num2 = Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
                            } else {

                                num2 = Double.toString(Double.parseDouble(num1) + Double.parseDouble(num2));
                            }
                            num1 = "";
                            oper = "";
                            onStringOne = true;
                            break;
                        case "-":
                            if (isInt) {
                                num2 = Integer.toString(Integer.parseInt(num1) - Integer.parseInt(num2));
                            } else {
                                num2 = Double.toString(Double.parseDouble(num1) - Double.parseDouble(num2));
                            }
                            num1 = "";
                            oper = "";
                            onStringOne = true;
                            break;
                        case "*":
                            if (isInt) {
                                num2 = Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2));
                            } else {
                                num2 = Double.toString(Double.parseDouble(num1) * Double.parseDouble(num2));
                            }
                            num1 = "";
                            oper = "";
                            onStringOne = true;
                            break;
                        case "/":
                            num2 = Double.toString(Double.parseDouble(num1) / Double.parseDouble(num2));
                            num1 = "";
                            oper = "";
                            onStringOne = true;
                            if (num2.substring(num2.length() - 2, num2.length()) == ".0") {
                                num2 = num2.substring(0, num2.length() - 2);
                            }
                            break;
                    }
                }
                break;*/
                t.setText(calc.equals());
                break;
        }
    }
}
