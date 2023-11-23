package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;
import unipar.invictus.app.helpers.Activity;

public class ProdutoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        ImageButton menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
    }
}
