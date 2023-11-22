package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;

public class CadastroCliente extends AppCompatActivity {

    private EditText edClienteNm;
    private EditText edClienteEmail;
    private EditText edClienteCpf;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edClienteNm = findViewById(R.id.edClienteNm);
        edClienteEmail = findViewById(R.id.edClienteEmail);
        edClienteCpf = findViewById(R.id.edClienteCpf);
        btSalvar = findViewById(R.id.btSalvar);

    }

}
