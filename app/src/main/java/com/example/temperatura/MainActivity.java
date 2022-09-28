package com.example.temperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtGrados = null;
    private TextView txtKelvin = null;
    private TextView txtFarenheit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtGrados = (EditText) findViewById(R.id.edit_Centigrados);
        txtKelvin = (TextView) findViewById(R.id.txt_kelvin);
        txtFarenheit = (TextView) findViewById(R.id.txt_Farenheit);
    }

    public void convertirTemperatura(View view){
        double kelvin = 0;
        double farenheit = 0;

        String texto = String.valueOf(edtGrados.getText());
        if(texto.isEmpty()){
            edtGrados.setError("Debes escribir los grados");
            return;
        }
        double valorG = Double.valueOf(texto);
        DecimalFormat df = new DecimalFormat("#.00");

        kelvin = valorG  + 273.53;
        farenheit = (valorG * 9/5) + 32;
        txtKelvin.setText(String.valueOf(kelvin)+" ºk");
        txtFarenheit.setText(String.valueOf(farenheit)+ " ºF");
    }

    public void reset(View view){
        txtKelvin.setText("0 ºk");
        txtFarenheit.setText("0 ºF");
        edtGrados.setText(null);
    }
}
