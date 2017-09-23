package cl.duocuc.maximilianoguerra_prueba1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPacienteActivity extends AppCompatActivity {

    private EditText etUsuario, etClave;
    private Button btnEntrar, btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_paciente);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etClave = (EditText)findViewById(R.id.etClave);
        btnEntrar= (Button) findViewById(R.id.btnEntrar);
        btnLlamar= (Button) findViewById(R.id.btnCall);
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLlamada();
            }
        });
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario();
            }
        });
    }

    private void realizarLlamada() {
        try{
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+5695555555")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void validarUsuario() {
        if(etUsuario.getText().toString().equals("admin") && etClave.getText().toString().equals("admin") || etUsuario.getText().toString().equals("usuario") && etClave.getText().toString().equals("clave") || etUsuario.getText().toString().equals("morty") && etClave.getText().toString().equals("morty")){
            Intent i = new Intent(this, TomarHoraMedicaActivity.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this, "Usuario invalido", Toast.LENGTH_LONG).show();
        }
    }
}
