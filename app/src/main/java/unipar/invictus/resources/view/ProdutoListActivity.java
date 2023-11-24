package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.resources.adapter.ProdutosListAdapter;
import unipar.invictus.resources.helpers.Activity;

public class ProdutoListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_list);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btCadastroProduto = findViewById(R.id.btCadastroProduto);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        btCadastroProduto.setOnClickListener(view -> Activity.run(this, CadastroProduto.class));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewProdutos);

        ProdutoController produtoController = new ProdutoController(this);

        ArrayList<Produto> listaProdutos = produtoController.getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProdutosListAdapter produtosListAdapter = new ProdutosListAdapter(listaProdutos, this);
        recyclerView.setAdapter(produtosListAdapter);
    }
}
