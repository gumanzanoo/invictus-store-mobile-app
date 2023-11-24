package unipar.invictus.resources.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import unipar.invictus.R;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.helpers.Response;
import unipar.invictus.resources.helpers.Activity;

public class DetalhesProdutoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);

        int produtoId = getIntent().getIntExtra("id", 1);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btEditar = findViewById(R.id.btEditar);
        FloatingActionButton btDeletar = findViewById(R.id.btDeletar);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        btEditar.setOnClickListener(view -> editarProduto(produtoId));
        btDeletar.setOnClickListener(view -> deletarProduto(produtoId));
    }

    private void deletarProduto(int produtoId) {
        ProdutoController produtoController = new ProdutoController(this);
        Response response = produtoController.delete(produtoId);
        Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void editarProduto(int produtoId) {
        ProdutoController produtoController = new ProdutoController(this);
        Produto produto = produtoController.getById(produtoId);

        Intent intent = new Intent(this, EditarProdutoActivity.class);
        intent.putExtra("id", produto.getId());
        this.startActivity(intent);
    }
}
