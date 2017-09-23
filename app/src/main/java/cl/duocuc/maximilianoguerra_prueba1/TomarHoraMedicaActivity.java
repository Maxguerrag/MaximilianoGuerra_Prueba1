package cl.duocuc.maximilianoguerra_prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TomarHoraMedicaActivity extends AppCompatActivity {

    private EditText etFecha, etHora, etNombre, etTelefono;
    private Button btnGuardar, btnLimpiar, btnVerlistado, btnCerrarSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar_hora_medica);
        etNombre = (EditText) findViewById(R.id.etNombrePaciente);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etHora = (EditText) findViewById(R.id.etHora);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnVerlistado = (Button) findViewById(R.id.btnVerListado);
        btnCerrarSession = (Button) findViewById(R.id.btnEntrar);
        btnCerrarSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSession();
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
        btnVerlistado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verListado();
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });
    }

    private void guardar() {
        if(!etNombre.getText().toString().equals("") ||
                !etTelefono.getText().toString().equals("") ||
                !etFecha.getText().toString().equals("") ||
                !etHora.getText().toString().equals("") ){
            //Guardar en Array


            Intent i = new Intent(this, ListadoDeHorasTomadasActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Falta Completar un campo", Toast.LENGTH_LONG).show();
        }
    }

    private void verListado() {
        Intent i = new Intent(this, ListadoDeHorasTomadasActivity.class);
        startActivity(i);
    }

    private void limpiar() {
        etNombre.setText("");
        etFecha.setText("");
        etHora.setText("");
        etTelefono.setText("");
        etNombre.requestFocus();
    }

    private void cerrarSession() {
        finish();
    }
}
