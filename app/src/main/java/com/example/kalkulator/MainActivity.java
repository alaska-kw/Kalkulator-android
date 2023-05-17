package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTextView;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonClear;
    private String currentNumber = "";
    private double operand1, operand2;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonClear = findViewById(R.id.buttonClear);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                appendNumber("0");
                break;
            case R.id.button1:
                appendNumber("1");
                break;
            case R.id.button2:
                appendNumber("2");
                break;
            case R.id.button3:
                appendNumber("3");
                break;
            case R.id.button4:
                appendNumber("4");
                break;
            case R.id.button5:
                appendNumber("5");
                break;
            case R.id.button6:
                appendNumber("6");
                break;
            case R.id.button7:
                appendNumber("7");
                break;
            case R.id.button8:
                appendNumber("8");
                break;
            case R.id.button9:
                appendNumber("9");
                break;
            case R.id.buttonAdd:
                performOperation("+");
                break;
            case R.id.buttonSubtract:
                performOperation("-");
                break;
            case R.id.buttonMultiply:
                performOperation("*");
                break;
            case R.id.buttonDivide:
                performOperation("/");
                break;
            case R.id.buttonEqual:
                calculateResult();
                break;
            case R.id.buttonClear:
                clearCalculator();
                break;
        }
    }

    private void appendNumber(String number) {
        currentNumber += number;
        resultTextView.setText(currentNumber);
    }

    private void performOperation(String operator) {
        if (!currentNumber.isEmpty()) {
            operand1 = Double.parseDouble(currentNumber);
            operation = operator;
            currentNumber = "";
            resultTextView.setText("");
        }
    }

    private void calculateResult() {
        if (!currentNumber.isEmpty() && !operation.isEmpty()) {
            operand2 = Double.parseDouble(currentNumber);
            double result = 0;
            switch (operation) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        resultTextView.setText("Error");
                        return;
                    }
                    break;
            }
            resultTextView.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
            operation = "";
        }
    }

    private void clearCalculator() {
        currentNumber = "";
        operand1 = 0;
        operand2 = 0;
        operation = "";
        resultTextView.setText("");
    }
}

