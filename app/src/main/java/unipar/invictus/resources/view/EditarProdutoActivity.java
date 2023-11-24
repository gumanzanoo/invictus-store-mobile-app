package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import unipar.invictus.R;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.resources.helpers.Activity;

public class EditarProdutoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        TextView edCodigo = findViewById()

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btSalvar = findViewById(R.id.btSalvar);

        int produtoId = getIntent().getIntExtra("id", 1);
        ProdutoController produtoController = new ProdutoController(this);
        Produto produto = produtoController.getById(produtoId);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
    }
}
