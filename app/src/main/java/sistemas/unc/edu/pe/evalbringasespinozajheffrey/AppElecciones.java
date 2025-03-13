package sistemas.unc.edu.pe.evalbringasespinozajheffrey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import Models.Votacion;

public class AppElecciones extends AppCompatActivity {

    Button btnIniciarVotacion, btnVerResultados;
    Votacion votacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_elecciones);

        btnIniciarVotacion = findViewById(R.id.btnIniciarVotacion);
        btnVerResultados = findViewById(R.id.btnVerResultados);
        votacion = new Votacion();

        btnIniciarVotacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnVerResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppElecciones.this, Resultados.class);


            }
        });
    }


}











