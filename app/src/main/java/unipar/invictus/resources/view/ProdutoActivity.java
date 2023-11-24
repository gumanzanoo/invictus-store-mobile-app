package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import unipar.invictus.R;
import unipar.invictus.resources.helpers.Activity;

public class ProdutoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btEditar = findViewById(R.id.btEditar);
        FloatingActionButton btDeletar = findViewById(R.id.btDeletar);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        btEditar.setOnClickListener(view -> Activity.run(this, EditarProdutoActivity.class));
    }
}
