package unipar.invictus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.ClienteController;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.controller.VendaController;
import unipar.invictus.app.dao.ProdutoDao;
import unipar.invictus.app.entity.Cliente;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.entity.Venda;
import unipar.invictus.app.helpers.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;

        VendaController vendaController = new VendaController(this);

        ProdutoController produtoController = new ProdutoController(this);

        Produto produto1 = produtoController.getById(2).getContent(Produto.class);
        produto1.setQuantidadeVenda(1);
        produtoController.update(produto1);

        Produto produto2 = produtoController.getById(2).getContent(Produto.class);
        produto2.setQuantidadeVenda(3);
        produtoController.update(produto2);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        Response<Venda> response = vendaController.create(2, produtos);
        Log.e("Response", response.getMessage());
    }
}