package sistemas.unc.edu.pe.evalbringasespinozajheffrey;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import sistemas.unc.edu.pe.evalbringasespinozajheffrey.AppJuego;
import sistemas.unc.edu.pe.evalbringasespinozajheffrey.R;

public class Jugar extends AppCompatActivity {

    TextView txtPalabraOculta, txtIntentos;
    EditText txtEntrada;
    Button btnVerificar, btnNuevoJuego;
    String palabraSecreta;
    int intentosRestantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        txtPalabraOculta = findViewById(R.id.txtPalabraOculta);
        txtIntentos = findViewById(R.id.txtIntentos);
        txtEntrada = findViewById(R.id.txtEntrada);
        btnVerificar = findViewById(R.id.btnVerificar);
        btnNuevoJuego = findViewById(R.id.btnNuevoJuego);

        iniciarJuego();

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarEntrada();
            }
        });

        btnNuevoJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJuego();
            }
        });
    }

    private void iniciarJuego() {
        Random random = new Random();
        palabraSecreta = AppJuego.palabras.get(random.nextInt(AppJuego.palabras.size()));
        intentosRestantes = AppJuego.maxIntentos;
        txtIntentos.setText("Intentos restantes: " + intentosRestantes);
        txtPalabraOculta.setText(ocultarPalabra(palabraSecreta));
    }

    private String ocultarPalabra(String palabra) {
        char[] oculto = palabra.toCharArray();
        int letrasOcultas = palabra.length() * 60 / 100;
        Random random = new Random();

        for (int i = 0; i < letrasOcultas; i++) {
            int index = random.nextInt(palabra.length());
            oculto[index] = '_';
        }

        return new String(oculto);
    }

    private void verificarEntrada() {
        String entrada = txtEntrada.getText().toString();

        if (entrada.equalsIgnoreCase(palabraSecreta)) {
            txtPalabraOculta.setText("¡Ganaste! La palabra era: " + palabraSecreta);
        } else {
            intentosRestantes--;
            txtIntentos.setText("Intentos restantes: " + intentosRestantes);

            if (intentosRestantes == 0) {
                txtPalabraOculta.setText("¡Perdiste! La palabra era: " + palabraSecreta);
            }
        }
    }
}




