package com.example.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.calculadoradeimc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );


    }


    public void validarCampos(View view) {

        String altura = binding.editTextAltura.getText().toString();
        String peso = binding.editTextPeso.getText().toString();


        if (!altura.isEmpty()) {
            if (!peso.isEmpty()) {


                Intent i = new Intent(getApplicationContext(), ResultadoActivity.class);
                i.putExtra("peso", peso);
                i.putExtra("altura", altura);
                startActivity(i);

            } else {
                Toast.makeText(this, "Digite o sua peso!", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Digite o seu altura!", Toast.LENGTH_SHORT).show();
        }

    }

}