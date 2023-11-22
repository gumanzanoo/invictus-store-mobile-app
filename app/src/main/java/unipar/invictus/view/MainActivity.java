package unipar.invictus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.VendaController;
import unipar.invictus.app.dao.ProdutoDao;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.helpers.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;

        VendaController vendaController = new VendaController(this);

        ArrayList<Produto> produtos = new ArrayList<>();
        ProdutoDao produtoDao = new ProdutoDao(this);
        produtos.add(produtoDao.getById(1));
        produtos.add(produtoDao.getById(2));
        produtos.add(produtoDao.getById(4));

        Response response = vendaController.create(1, produtos);
        Log.e("Response", response.getMessage());
    }
}