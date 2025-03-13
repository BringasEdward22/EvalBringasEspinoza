package sistemas.unc.edu.pe.evalbringasespinozajheffrey;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ListActivity {

    String[] ejercicios={"Juego","Elecciones"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ejercicios));

    }
    protected void onListItemClick(ListView l, View v, int index, long id) {
        super.onListItemClick(l, v, index, id);

        Intent oIntento = null;
        try {
            Class<?> ActividadDestino = Class.forName("sistemas.unc.edu.pe.evalbringasespinozajheffrey.App" + ejercicios[index]);
            oIntento = new Intent(this, ActividadDestino);
            startActivity(oIntento);
        } catch (Exception ex) {
            Log.d("Error", ex.getMessage());
        }

    }
}