package com.example.quizrapidoparcial1programacionmovil1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);

    EditText numero1 = findViewById(R.id.numero1);
    EditText numero2 = findViewById(R.id.numero2);
    Button sumar = findViewById(R.id.sumar);
    Button restar = findViewById(R.id.restar);
    Button dividir = findViewById(R.id.dividir);
    Button multiplicar = findViewById(R.id.multiplicar);
    Operaciones operaciones = new Operaciones();

    sumar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());
        int resultado = operaciones.sumar(num1, num2);
        mostrarResultado(resultado);
      }
    });

    restar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());
        int resultado = operaciones.restar(num1, num2);
        mostrarResultado(resultado);

      }
    });

    multiplicar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());
        int resultado = operaciones.multiplicar(num1, num2);
        mostrarResultado(resultado);

      }
    });

    dividir.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());
        int resultado = operaciones.dividir(num1, num2);
        mostrarResultado(resultado);
      }
    });


    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });
  }
  private void mostrarResultado(int resultado) {
    Intent intent = new Intent(MainActivity.this, Resultado.class);
    intent.putExtra("resultado", resultado);
    startActivity(intent);
  }
}