package unipar.invictus.resources.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import unipar.invictus.R;
import unipar.invictus.app.controller.ClienteController;
import unipar.invictus.app.helpers.Response;

public class CadastroClienteActivity extends AppCompatActivity {
    private EditText edNomeCadastro;
    private EditText edEmailCadastro;
    private EditText edDocCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edNomeCadastro = findViewById(R.id.edNomeCadastro);
        edEmailCadastro = findViewById(R.id.edEmailCadastro);
        edDocCadastro = findViewById(R.id.edDocCadastro);

        Button btCadastrar = findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(view -> cadastrarCliente());
    }

    private void cadastrarCliente() {
        ClienteController clienteController = new ClienteController(this);

        String nome = edNomeCadastro.getText().toString();
        String email = edEmailCadastro.getText().toString();
        String doc = edDocCadastro.getText().toString();

        Response response = clienteController.create(nome, email, doc);
        if (response.getStatus().equals(Response.SUCCESS)) {
            Toast.makeText(this,
                    response.getMessage(),
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,
                    response.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
