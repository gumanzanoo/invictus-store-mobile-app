package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;

public class CadastroUsuario extends AppCompatActivity {

    private EditText edEmailUser;
    private EditText edSenhaUser;
    private EditText edSenhaConfirm;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        edEmailUser = findViewById(R.id.edEmailUser);
        edSenhaUser = findViewById(R.id.edSenhaUser);
        edSenhaConfirm = findViewById(R.id.edSenhaConfirm);
        btSalvar = findViewById(R.id.btSalvar);



    }
}
