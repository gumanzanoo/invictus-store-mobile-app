package unipar.invictus.resources.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import unipar.invictus.R;
import unipar.invictus.app.controller.UsuarioController;
import unipar.invictus.app.helpers.Activity;
import unipar.invictus.app.helpers.Response;
import unipar.invictus.app.helpers.SessionManager;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText edNomeCadastro;
    private EditText edEmailCadastro;
    private EditText edSenhaCadastro;
    private TextView tvErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        edNomeCadastro = findViewById(R.id.edNomeCadastro);
        edEmailCadastro = findViewById(R.id.edEmailCadastro);
        edSenhaCadastro = findViewById(R.id.edSenhaCadastro);
        Button btCadastrar = findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(view -> cadastrarUsuario());
    }

    private void cadastrarUsuario() {
        UsuarioController usuarioController = new UsuarioController(this);

        String nome = edNomeCadastro.getText().toString();
        String email = edEmailCadastro.getText().toString();
        String senha = edSenhaCadastro.getText().toString();

        Response response = usuarioController.cadastrarUsuario(nome, email, senha);

        String status = response.getStatus();
        String message = response.getMessage();

        if (status.equals(Response.SUCCESS)) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        if (status.equals(Response.ERROR)) {
            tvErro.setText(message);
            tvErro.setVisibility(View.GONE);
        } else {
            SessionManager sessionManager = new SessionManager(this);
            sessionManager.login(edEmailCadastro.getText().toString());

            Activity.run(this, LoginActivity.class);
        }
    }
}
