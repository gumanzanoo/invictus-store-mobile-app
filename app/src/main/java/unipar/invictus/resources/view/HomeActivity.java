package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import unipar.invictus.R;
import unipar.invictus.resources.helpers.Activity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btCadastroVenda = findViewById(R.id.btCadastroVenda);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        btCadastroVenda.setOnClickListener(view -> Activity.run(this, CadastroVendaActivity.class));
    }
}
