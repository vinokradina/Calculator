package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String operator;
    private double firstValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        String currentText = resultTextView.getText().toString();
        resultTextView.setText(currentText + button.getText());
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        firstValue = Double.parseDouble(resultTextView.getText().toString());
        operator = button.getText().toString();
        resultTextView.setText("");
    }

    public void onEqualsClick(View view) {
        double secondValue = Double.parseDouble(resultTextView.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    resultTextView.setText("Error");
                    return;
                }
                break;
        }
        resultTextView.setText(String.valueOf(result));
    }

    public void onClearClick(View view) {
        resultTextView.setText("");
        firstValue = 0;
        operator = null;
    }
}