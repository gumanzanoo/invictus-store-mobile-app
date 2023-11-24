package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.helpers.Response;
import unipar.invictus.resources.helpers.Activity;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText edDescProd;
    private EditText edVlrProd;
    private EditText edQtdProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        edDescProd = findViewById(R.id.edDescProd);
        edVlrProd = findViewById(R.id.edVlrProd);
        edQtdProd = findViewById(R.id.edQtdProd);
        Button btCadastrar = findViewById(R.id.btCadastrar);
        ImageButton menuButton = findViewById(R.id.menuButton);

        btCadastrar.setOnClickListener(view -> cadastrarProduto());
        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
    }

    private void cadastrarProduto() {
        ProdutoController produtoController = new ProdutoController(this);
        Response response = produtoController.create(
                edDescProd.getText().toString(),
                Double.parseDouble(edVlrProd.getText().toString()),
                Integer.parseInt(edQtdProd.getText().toString())
        );

        if (response.getStatus().equals(Response.SUCCESS)) {
            Activity.run(this, ProdutoListActivity.class);
        } else {
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
            Activity.run(this, CadastroProdutoActivity.class);
        }
    }
}
