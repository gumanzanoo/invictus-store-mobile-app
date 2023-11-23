package unipar.invictus.resources.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;

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
        btSalvar = findViewById(R.id.btSalvar);
        menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(view -> abrirActivity(MenuActivity.class));

    }

    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

}
