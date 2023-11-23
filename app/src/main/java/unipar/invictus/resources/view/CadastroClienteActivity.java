package unipar.invictus.resources.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import unipar.invictus.R;
import unipar.invictus.app.controller.ClienteController;
import unipar.invictus.app.helpers.Response;

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText edNomeCadastro;
    private EditText edEmailCadastro;
    private EditText edSenhaCadastro;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edNomeCadastro = findViewById(R.id.edNomeCadastro);
        edEmailCadastro = findViewById(R.id.edEmailCadastro);
        edSenhaCadastro = findViewById(R.id.edSenhaCadastro);
        btCadastrar = findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(view -> cadastrarCliente());
    }

    private void cadastrarCliente() {
        ClienteController clienteController = new ClienteController(this);

        String nome = edNomeCadastro.getText().toString();
        String email = edEmailCadastro.getText().toString();
        String senha = edSenhaCadastro.getText().toString();

        Response<String> response = clienteController.create(nome, email, senha).getContent();

        String status = response.getStatus();
        String message = response.getMessage();

        if (status.equals(Response.ERROR)) {
            // Trate o erro aqui, se necessário
        } else {
            // Cadastro realizado com sucesso
            // Você pode adicionar lógica adicional aqui, como redirecionar para a tela de login, por exemplo.
        }
    }
}
