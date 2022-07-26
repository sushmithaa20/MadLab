package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btnEqual, btnDot, btnClear;
    EditText textResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne= (Button)findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);
        btnTwo= (Button)findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(this);
        btnThree= (Button)findViewById(R.id.btnThree);
        btnThree.setOnClickListener(this);
        btnFour= (Button)findViewById(R.id.btnFour);
        btnFour.setOnClickListener(this);

        btnFive= (Button)findViewById(R.id.btnFive);
        btnFive.setOnClickListener(this);
        btnSix= (Button)findViewById(R.id.btnSix);
        btnSix.setOnClickListener(this);
        btnSix= (Button)findViewById(R.id.btnSix);
        btnSix.setOnClickListener(this);
        btnSeven= (Button)findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(this);
        btnEight= (Button)findViewById(R.id.btnEight);
        btnEight.setOnClickListener(this);
        btnNine= (Button)findViewById(R.id.btnNine);
        btnNine.setOnClickListener(this);
        btnZero= (Button)findViewById(R.id.btnZero);
        btnZero.setOnClickListener(this);
        btnAdd= (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnSub= (Button)findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);
        btnMul= (Button)findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnDiv= (Button)findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        btnEqual= (Button)findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);
        btnClear= (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnDot= (Button)findViewById(R.id.btnDot);
        btnDot.setOnClickListener(this);
        textResults=(EditText)findViewById(R.id.EditText);
        textResults.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnOne))
            textResults.append("1");
        if(v.equals(btnTwo))
            textResults.append("2");
        if(v.equals(btnThree))
            textResults.append("3");
        if(v.equals(btnFour))
            textResults.append("4");
        if(v.equals(btnFive))
            textResults.append("5");
        if(v.equals(btnSix))
            textResults.append("6");
        if(v.equals(btnSeven))
            textResults.append("7");
        if(v.equals(btnEight))
            textResults.append("8");
        if(v.equals(btnNine))
            textResults.append("9");
        if(v.equals(btnZero))
            textResults.append("0");
        if(v.equals(btnAdd))
            textResults.append("+");
        if(v.equals(btnDiv))
            textResults.append("/");
        if(v.equals(btnSub))
            textResults.append("-");
        if(v.equals(btnMul))
            textResults.append("*");
        if(v.equals(btnDot))
            textResults.append(".");
        if(v.equals(btnClear))
            textResults.setText("");
        if(v.equals(btnEqual))
        {
            try
            {
                String data=textResults.getText().toString();
                if(data.contains("/"))
                {
                    Div(data);
                }
                else if(data.contains("+"))
                {
                    Add(data);
                }
                else if(data.contains("-"))
                {
                    Sub(data);
                }
                else if(data.contains("*"))
                {
                    Mul(data);
                }

            }
            catch (Exception e)
            {
                diplayInvalidMessage("Invalid Input");
            }

        }

    }
    private void diplayInvalidMessage(String invalid_input) {
        Toast.makeText(getBaseContext(),invalid_input,Toast.LENGTH_LONG).show();
    }
    private void Add(String data) {
        String[] operands= data.split(Pattern.quote("+"));
        if(operands.length==2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double Result = operand1+operand2;
            textResults.setText(String.valueOf(Result));
        }
        else
            diplayInvalidMessage("Invalid Input");
    }

    private void Sub(String data) {
        String[] operands= data.split(Pattern.quote("-"));
        if(operands.length==2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double Result = operand1-operand2;
            textResults.setText(String.valueOf(Result));
        }
        else
            diplayInvalidMessage("Invalid Input");

    }
    private void Mul(String data) {
        String[] operands= data.split(Pattern.quote("*"));
        if(operands.length==2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double Result = operand1*operand2;
            textResults.setText(String.valueOf(Result));
        }
        else
            diplayInvalidMessage("Invalid Input");

    }


    private void Div(String data)
    {
        String[] operands= data.split(Pattern.quote("/"));
        if(operands.length==2)
        {
           double operand1 = Double.parseDouble(operands[0]);
           double operand2 = Double.parseDouble(operands[1]);
           double Result = operand1/operand2;
           textResults.setText(String.valueOf(Result));
        }
        else
            diplayInvalidMessage("Invalid Input");

    }
}
