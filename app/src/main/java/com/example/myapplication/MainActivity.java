package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button fromDecimalBtn,fromBinaryBtn,fromOctalBtn,fromHexadecimalBtn;
    Button toDecimalBtn,toBinaryBtn,toOctalBtn,toHexadecimalBtn;
    TextView fromDisplay,toDisplay;
    EditText textInput;
    Button convertBtn;
    TextView inputDisplay,outputDisplay;

    String fromInput=null,toInput=null;
    String answer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fromDecimalBtn = findViewById(R.id.fromDecimalBtn);
        fromBinaryBtn = findViewById(R.id.fromBinaryBtn);
        fromOctalBtn = findViewById(R.id.fromOctalBtn);
        fromHexadecimalBtn = findViewById(R.id.fromHexadecimalBtn);
        toDecimalBtn = findViewById(R.id.toDecimalBtn);
        toBinaryBtn = findViewById(R.id.toBinaryBtn);
        toOctalBtn = findViewById(R.id.toOctalBtn);
        toHexadecimalBtn = findViewById(R.id.toHexadecimalBtn);
        fromDisplay = findViewById(R.id.fromDisplay);
        toDisplay = findViewById(R.id.toDisplay);
        textInput = findViewById(R.id.textInput);
        convertBtn = findViewById(R.id.convertBtn);
        inputDisplay = findViewById(R.id.inputDisplay);
        outputDisplay = findViewById(R.id.outputDisplay);

        fromDecimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInput="Decimal";
                fromDisplay.setText("Decimal");
            }
        });

        fromBinaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInput="Binary";
                fromDisplay.setText("Binary");
            }
        });

        fromOctalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInput="Octal";
                fromDisplay.setText("Octal");
            }
        });

        fromHexadecimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInput="Hexadecimal";
                fromDisplay.setText("Hexadecimal");
            }
        });

        toDecimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInput = "Decimal";
                toDisplay.setText("Decimal");
            }
        });


        toBinaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInput = "Binary";
                toDisplay.setText("Binary");
            }
        });

        toOctalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInput = "Octal";
                toDisplay.setText("Octal");
            }
        });

        toHexadecimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInput = "Hexadecimal";
                toDisplay.setText("Hexadecimal");
            }
        });


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = textInput.getText().toString();

                convertFunction(input,fromInput,toInput);

            }
        });




    }

    public void convertFunction(String input, String from, String to) {
        inputDisplay.setText(input);
        String result = "";

        if(from.equals("Decimal")){
            if(to.equals("Binary")){
                int decimalNumber = Integer.parseInt(input);
                result = Integer.toBinaryString(decimalNumber);
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            } else if (to.equals("Octal")) {
                int decimalNumber = Integer.parseInt(input);
                result = Integer.toOctalString(decimalNumber);
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            } else if (to.equals("Hexadecimal")) {
                int decimalNumber = Integer.parseInt(input);
                result =  Integer.toHexString(decimalNumber);
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            }
        } else if (from.equals("Binary")) {
            if (to.equals("Decimal")) {
                int binaryNumber = Integer.parseInt(input, 2);
                result = String.valueOf(binaryNumber);
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            } else if (to.equals("Octal")) {
                int binaryNumber = Integer.parseInt(input, 2);
                result = Integer.toOctalString(binaryNumber);
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            } else if (to.equals("Hexadecimal")) {
                int binaryNumber = Integer.parseInt(input, 2);
                result = Integer.toHexString(binaryNumber);
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            }

        } else if (from.equals("Octal")) {
            if(to.equals("Decimal")){
                int octalNumber = Integer.parseInt(input, 8);
                result = String.valueOf(octalNumber);
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            } else if (to.equals("Binary")) {
                try {
                    int octalNumber = Integer.parseInt(input, 8);
                    result = Integer.toBinaryString(octalNumber);
                    inputDisplay.setText(input);
                    outputDisplay.setText(result);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "An arithmetic exception occurred!", Toast.LENGTH_SHORT).show();
                }

            } else if (to.equals("Hexadecimal")) {
                int octalNumber = Integer.parseInt(input, 8);
                result = Integer.toHexString(octalNumber).toUpperCase();
                inputDisplay.setText(input);
                outputDisplay.setText(result);
            }
        } else if (from.equals("Hexadecimal")) {
            if(to.equals("Decimal")){
                try {
                    int hexadecimalNumber = Integer.parseInt(input, 16);
                    result = String.valueOf(hexadecimalNumber);
                    inputDisplay.setText(input);
                    outputDisplay.setText(result);
                }catch (Exception e){
                    Toast.makeText(this, "An arithmetic exception error occurred!", Toast.LENGTH_SHORT).show();
                }
            } else if (to.equals("Binary")) {
                try {
                    int hexadecimalNumber = Integer.parseInt(input, 16);
                    result = Integer.toBinaryString(hexadecimalNumber);
                    inputDisplay.setText(input);
                    outputDisplay.setText(result);
                }catch (Exception e){
                    Toast.makeText(this, "An arithmetic exception error occurred!", Toast.LENGTH_SHORT).show();
                }
            } else if (to.equals("Octal")) {
                
            }

        }


        try {

        }catch (Exception e){
            Toast.makeText(this, "An arithmetic exception error occurred!", Toast.LENGTH_SHORT).show();
        }


    }



}