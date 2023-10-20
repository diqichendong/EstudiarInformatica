package com.example.estudiarinformatica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner sprCiclo, sprPoblacion, sprTipo;
    private TextView lblInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblInfo = findViewById(R.id.lblInfo);
        lblInfo.setText("");

        sprCiclo = findViewById(R.id.sprCiclo);
        sprCiclo.setOnItemSelectedListener(this);

        sprPoblacion = findViewById(R.id.sprPoblacion);
        sprPoblacion.setOnItemSelectedListener(this);

        sprTipo = findViewById(R.id.sprTipo);
        sprTipo.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (allSpinnersReady()) {
            String ciclo = sprCiclo.getSelectedItem().toString();
            String poblacion = sprPoblacion.getSelectedItem().toString();
            String tipo = sprTipo.getSelectedItem().toString();
            lblInfo.setText(ciclo + " en " + poblacion + " de forma " + tipo.toLowerCase());
        } else {
            lblInfo.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void borrar(View v) {
        sprCiclo.setSelection(0);
        sprPoblacion.setSelection(0);
        sprTipo.setSelection(0);
    }

    private boolean allSpinnersReady() {
        return !sprCiclo.getSelectedItem().toString().isEmpty() &&
                !sprPoblacion.getSelectedItem().toString().isEmpty() &&
                !sprTipo.getSelectedItem().toString().isEmpty();
    }
}