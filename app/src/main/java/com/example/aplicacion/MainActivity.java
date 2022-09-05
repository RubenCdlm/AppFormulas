package com.example.aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private EditText numValor;
    private Button bfibonacci;
    private TextView rFibonacci;
    private Button bfactorial;
    private TextView rFactorial;
    private Button blimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numValor = (EditText) findViewById(R.id.numValor);
        bfibonacci =(Button) findViewById(R.id.bfibonacci);
        rFibonacci =(TextView) findViewById(R.id.rFibonacci);
        bfactorial =(Button) findViewById(R.id.bfactorial);
        rFactorial =(TextView) findViewById(R.id.rFactorial);
        blimpiar =(Button) findViewById(R.id.blimpiar);

        bfactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    int n = Integer.parseInt(numValor.getText().toString());
                    rFactorial.setText("" +String.format(Locale.getDefault(),"%.0f",factorial(n)));
                }
            }
        });
        bfibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validar()){
                    rFibonacci.setText(fibonacci(Integer.parseInt(numValor.getText().toString())));
                }
            }
        });
        blimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    numValor.setText("");
                    rFibonacci.setText("");
                    rFactorial.setText("");
            }
        });
    }

    private boolean validar(){
        boolean result = true;

        String valor = numValor.getText().toString();

        if(valor.isEmpty())
        {
            numValor.setError("Este campo no puede quedar vacio");
            result = false;
        }

        return result;
    }

    private String fibonacci(int n){
        String result = "0";
        ArrayList<BigInteger> array = new ArrayList<>();
        BigInteger primero = new BigInteger("0");
        BigInteger segundo = new BigInteger("1");
        array.add(primero);
        array.add(segundo);
        for(int i = 1; i < n; i++){
            array.add(array.get(i).add(array.get(i-1)));
        }
        for(int i = 1; i <= n; i++){
            result = array.get(i).toString();
        }
        return result;
    }

    private double factorial(int n){
        double result = 1;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }


}