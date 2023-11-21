package unipar.invictus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import unipar.invictus.R;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.helpers.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProdutoController produtoController = new ProdutoController(this);
        Response response = produtoController.create("Produto 10", 10, 10);

        Log.i("Response", response.getMessage());
    }
}