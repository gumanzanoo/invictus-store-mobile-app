package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;
import unipar.invictus.resources.helpers.Activity;

public class CadastroProduto extends AppCompatActivity {

    private EditText edDescProd;
    private EditText edVlrProd;
    private EditText edQtdProd;
    private Button btSalvar;
    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        edDescProd = findViewById(R.id.edDescProd);
        edVlrProd = findViewById(R.id.edVlrProd);
        edQtdProd = findViewById(R.id.edQtdProd);
        btSalvar = findViewById(R.id.btCadastrar);
        menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
    }
}
