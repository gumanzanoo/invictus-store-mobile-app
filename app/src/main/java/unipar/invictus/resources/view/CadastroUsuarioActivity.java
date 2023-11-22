package unipar.invictus.resources.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import unipar.invictus.R;
import unipar.invictus.app.controller.UsuarioController;
import unipar.invictus.app.helpers.Response;
import unipar.invictus.app.helpers.SessionManager;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText edNomeCadastro;
    private EditText edEmailCadastro;
    private EditText edSenhaCadastro;
    private Button btCadastrar;
    private TextView tvErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        edNomeCadastro = findViewById(R.id.edNomeCadastro);
        edEmailCadastro = findViewById(R.id.edEmailCadastro);
        edSenhaCadastro = findViewById(R.id.edSenhaCadastro);
        btCadastrar = findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(view -> cadastrarUsuario());
    }

    private void cadastrarUsuario() {
        UsuarioController usuarioController = new UsuarioController(this);

        String nome = edNomeCadastro.getText().toString();
        String email = edEmailCadastro.getText().toString();
        String senha = edSenhaCadastro.getText().toString();

        Response<String> response = usuarioController.cadastrarUsuario(nome, email, senha);

        String status = response.getStatus();
        String message = response.getMessage();

        if (status.equals(Response.ERROR)) {
            tvErro.setText(message);
            tvErro.setVisibility(View.GONE);
        } else {
            SessionManager sessionManager = new SessionManager(this);
            sessionManager.login(edEmailCadastro.getText().toString());
            redirectBackToLogin();
        }
    }

    private void redirectBackToLogin() {
        Intent redirectBackToLoginIntent = new Intent(this, LoginActivity.class);
        startActivity(redirectBackToLoginIntent);
    }
}
