package com.example.michael.calculator;

/**
 * Created by Michael on 09/07/16.
 */
public class Calculator {
    String num1 = "";
    String num2 = "";
    String oper = "";
    boolean onStringOne = true;

    private static Calculator instance = null;

    private Calculator(){}

    public static Calculator getInstance() {
        if(instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    private boolean ifOnAnswer() {
        if(num1.isEmpty() && !num2.isEmpty()) {
            num2 = "";
            return true;
        }
        return false;
    }

    public String addDigit(String i) {
        ifOnAnswer();
        if (onStringOne){ //On first number
            num1 = num1 + i;
        }
        else if (!onStringOne){ //On second number
            num2 = num2 + i;
        }
        return (num1 + oper + num2);
    }

    public String addPeriod() {
        ifOnAnswer();
        if(onStringOne) {
            if(!num1.contains(".")) {
                num1 = num1 + ".";
            }
        }
        else if(!oper.isEmpty() && !num2.contains(".")) {
            num2 = num2 + ".";
        }
        return (num1 + oper + num2);
    }

    private void switchNums() {
        if(num1.isEmpty() && !num2.isEmpty()) {
            num1 = num2;
            num2 = "";
        }
    }

    private void setOper(String c) {
        if(oper.isEmpty() && !num1.isEmpty()) {
            oper = c;
            onStringOne = false;
        }
    }

    public String addOper(String c) {
        switch (c) {
            case "-":
                switchNums();
                setOper(c);
                break;
            case "*":
                switchNums();
                setOper(c);
                break;
            case "÷":
                switchNums();
                setOper(c);
                break;
            case "+":
                switchNums();
                setOper(c);
                break;
        }
        return (num1 + oper + num2);
    }

    public String backspace() {
        if(onStringOne && !num1.isEmpty()) {
            num1 = num1.substring(0, num1.length()-1);
        }
        else if(!onStringOne && num2.isEmpty() && !oper.isEmpty()) {
            oper = "";
            onStringOne = true;
        }
        else if(!onStringOne && !oper.isEmpty()){
            num2 = num2.substring(0, num2.length()-1);
        }
        return (num1 + oper + num2);
    }

    public void clear() {
        num1 = "";
        num2 = "";
        oper = "";
        onStringOne = true;
    }

    public String equals() {
        if (!num1.isEmpty() && !num2.isEmpty()) {
            boolean isInt = (!num1.contains(".") && !num2.contains("."));

            if (!isInt) { //makes the other numbers doubles if not already
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
                        break;
                    } else {
                        num2 = Double.toString(Double.parseDouble(num1) + Double.parseDouble(num2));
                        break;
                    }
                case "-":
                    if (isInt) {
                        num2 = Integer.toString(Integer.parseInt(num1) - Integer.parseInt(num2));
                        break;
                    } else {
                        num2 = Double.toString(Double.parseDouble(num1) - Double.parseDouble(num2));
                        break;
                    }
                case "*":
                    if (isInt) {
                        num2 = Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2));
                        break;
                    } else {
                        num2 = Double.toString(Double.parseDouble(num1) * Double.parseDouble(num2));
                        break;
                    }
                case "/":
                    num2 = Double.toString(Double.parseDouble(num1) / Double.parseDouble(num2));
                    if (num2.substring(num2.length() - 1, num2.length()) == ".0") {
                        num2 = num2.substring(0, num2.length() - 2);
                    }
                    break;
            }
            num1 = "";
            oper = "";
            onStringOne = true;
        }
        return(num1 + oper + num2);
    }

    public String inputConst(String c) {
        ifOnAnswer(); //check whether we are looking at a answer
        if(num1.isEmpty() && onStringOne) {

        }
        //check whether string one is empty and we are on it
            //add const
        //check whether string two is empty and we are on it

        return(num1 + oper + num2);
    }
}
