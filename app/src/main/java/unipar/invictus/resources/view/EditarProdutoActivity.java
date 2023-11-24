package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import unipar.invictus.R;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.resources.helpers.Activity;
import unipar.invictus.app.helpers.Response;

public class EditarProdutoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        int produtoId = getIntent().getIntExtra("id", 1);
        ProdutoController produtoController = new ProdutoController(this);
        Produto produto = produtoController.getById(produtoId);

        TextView edCodigo = findViewById(R.id.edCodigo);
        edCodigo.setText(produto.getCod());
        TextView edDescricao = findViewById(R.id.edDescricao);
        edDescricao.setText(produto.getDescricao());
        TextView edVlrUnitario = findViewById(R.id.edVlrUnitario);
        edVlrUnitario.setText(String.valueOf(produto.getValorUnitario()));
        TextView edQtdProd = findViewById(R.id.edQtdProd);
        edQtdProd.setText(produto.getQuantidadeVenda());

        ImageButton menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        FloatingActionButton btSalvar = findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(view -> salvarProduto(produtoId));
    }

    private void salvarProduto(int produtoId) {
        ProdutoController produtoController = new ProdutoController(this);
        Produto produto = produtoController.getById(produtoId);

        EditText edCodigo = findViewById(R.id.edCodigo);
        produto.setCod(Integer.parseInt(edCodigo.getText().toString()));
        EditText edDescricao = findViewById(R.id.edDescricao);
        produto.setDescricao(edDescricao.getText().toString());
        EditText edVlrUnitario = findViewById(R.id.edVlrUnitario);
        produto.setValorUnitario(Double.parseDouble(edVlrUnitario.getText().toString()));
        EditText edQtdProd = findViewById(R.id.edQtdProd);
        produto.setQuantidadeVenda(Integer.parseInt(edQtdProd.getText().toString()));

        Response response = produtoController.update(produto);
        if (Objects.equals(response.getStatus(), Response.SUCCESS)) {
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
            Activity.run(this, ProdutoListActivity.class);
        }
        else {
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
            Activity.run(this, EditarProdutoActivity.class);
        }
    }
}
