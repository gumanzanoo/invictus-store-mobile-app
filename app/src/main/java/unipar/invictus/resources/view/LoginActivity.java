package unipar.invictus.resources.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import unipar.invictus.R;
import unipar.invictus.app.controller.UsuarioController;
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

        tvErro = findViewById(R.id.tvErro);

        btLogin.setOnClickListener(view -> realizarLogin());
    }

    private void realizarLogin() {
        UsuarioController usuarioController = new UsuarioController(this);

        try {
            Response<String> response = usuarioController.login(
                    edEmail.getText().toString(),
                    edSenha.getText().toString()
            );

            String status = response.getStatus();
            String message = response.getMessage();

            if (status.equals(Response.ERROR)) {
                tvErro.setText(message);
                tvErro.setVisibility(View.GONE);
            } else {
                SessionManager sessionManager = new SessionManager(this);
                sessionManager.login(edEmail.getText().toString());
                abrirHome();
            }

        } catch (Exception e) {
            tvErro.setText(e.getMessage());
            tvErro.setVisibility(View.VISIBLE);
        }
    }

    public void abrirHome() {
        Intent abrirHomeIntent = new Intent(this, HomeActivity.class);
        startActivity(abrirHomeIntent);
    }
}
