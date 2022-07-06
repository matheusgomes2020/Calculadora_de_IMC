package com.example.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.calculadoradeimc.databinding.ActivityResultadoBinding;

public class ResultadoActivity extends AppCompatActivity {

    private ActivityResultadoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResultadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            String peso = String.valueOf(bundle.get("peso"));
            String altura = String.valueOf(bundle.get("altura"));

            binding.textRPeso.setText("Peso Informado:" + peso + " kg");
            binding.textRAltura.setText("Altura Informada:" + altura + " m");

            Double imc = Double.valueOf(peso) / ( Double.valueOf( altura ) * Double.valueOf( altura ) );
            String imc2 = String.format( "%.2f", imc );

            binding.textRImc.setText(imc2);

            String resultado = "";

            if ( imc >0 && imc < 18.5 ){
                resultado = "Magreza";
                binding.textDiagnostico.setTextColor( getResources().getColor( R.color.azulclaro) );
            } else if ( imc >= 18.5 && imc < 25 ) {
                resultado = "Normal";
                binding.textDiagnostico.setTextColor( getResources().getColor( R.color.azul) );
            }else if ( imc >= 25 && imc < 30 ) {
                resultado = "Sobrepeso";
                binding.textDiagnostico.setTextColor( getResources().getColor( R.color.amarelo) );
            }else if ( imc >30 && imc < 40 ) {
                resultado = "Obesidade";
                binding.textDiagnostico.setTextColor( getResources().getColor( R.color.laranja) );
            }
            else if ( imc >40 ) {
                resultado = "Obesidade grave";
                binding.textDiagnostico.setTextColor( getResources().getColor( R.color.vermelho) );
            }

            binding.textDiagnostico.setText( resultado );

        }



    }
}