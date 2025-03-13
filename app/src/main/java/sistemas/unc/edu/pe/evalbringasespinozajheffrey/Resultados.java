package sistemas.unc.edu.pe.evalbringasespinozajheffrey;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Resultados extends AppCompatActivity {

    ListView listaResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_resultados);

        listaResultados = findViewById(R.id.listaResultados);

                ArrayList<String> resultados = getIntent().getStringArrayListExtra("resultados");

        if (resultados != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultados);
            listaResultados.setAdapter(adapter);
        }
    }
}
