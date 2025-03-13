package sistemas.unc.edu.pe.evalbringasespinozajheffrey;

import static sistemas.unc.edu.pe.evalbringasespinozajheffrey.R.id.txtPalabras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AppJuego extends AppCompatActivity {

    EditText txtPalabras, txtIntentos;
    Button btnIniciarJuego;
    public static ArrayList<String> palabras = new ArrayList<>();
    public static int maxIntentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_juego);


        txtPalabras = findViewById(R.id.txtPalabras);
        txtIntentos = findViewById(R.id.txtIntentos);
        btnIniciarJuego = findViewById(R.id.btnIniciarJuego);


        btnIniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] palabrasIngresadas = txtPalabras.getText().toString().split(",");
                for (String palabra : palabrasIngresadas) {
                    palabras.add(palabra.trim());
                }

                maxIntentos = Integer.parseInt(txtIntentos.getText().toString());
                Intent intent = new Intent(AppJuego.this,Jugar.class);
                startActivity(intent);
            }
        });




    }


}








