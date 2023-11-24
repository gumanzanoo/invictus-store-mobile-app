package unipar.invictus.resources.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import unipar.invictus.R;
import unipar.invictus.app.controller.UsuarioController;
import unipar.invictus.resources.helpers.Activity;
import unipar.invictus.app.helpers.Response;
import unipar.invictus.app.helpers.SessionManager;

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail;
    private EditText edSenha;
    private TextView tvErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);
        Button btLogin = findViewById(R.id.btLogin);
        Button btCadastro = findViewById(R.id.btCadastro);

        tvErro = findViewById(R.id.tvErro);

        btLogin.setOnClickListener(view -> realizarLogin());
        btCadastro.setOnClickListener(view -> abrirCadastro());
    }

    private void realizarLogin() {
        UsuarioController usuarioController = new UsuarioController(this);

        try {
            Response response = usuarioController.login(
                    edEmail.getText().toString(),
                    edSenha.getText().toString()
            );

            String status = response.getStatus();
            String message = response.getMessage();

            if (status.equals(Response.SUCCESS)) {
                SessionManager sessionManager = new SessionManager(this);
                sessionManager.login(edEmail.getText().toString());
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                Activity.run(this, HomeActivity.class);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                tvErro.setText(message);
                tvErro.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            tvErro.setText(e.getMessage());
            tvErro.setVisibility(View.VISIBLE);
        }
    }

    public void abrirCadastro() {
        Activity.run(this, CadastroUsuarioActivity.class);
    }
}
