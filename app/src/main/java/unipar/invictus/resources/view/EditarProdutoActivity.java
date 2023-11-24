package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import unipar.invictus.R;
import unipar.invictus.resources.helpers.Activity;

public class EditarProdutoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btSalvar = findViewById(R.id.btSalvar);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
    }
}
