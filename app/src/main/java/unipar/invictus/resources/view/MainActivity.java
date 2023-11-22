package unipar.invictus.resources.view;

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
    }
}