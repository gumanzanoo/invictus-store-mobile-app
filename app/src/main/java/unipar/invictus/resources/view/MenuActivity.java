package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;
import unipar.invictus.app.helpers.Activity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btHome = findViewById(R.id.btHome);
        Button btCatalogo = findViewById(R.id.btCatalogo);
        Button btExtrato = findViewById(R.id.btExtrato);
        Button btUsuario = findViewById(R.id.btUsuario);
        Button btProduto = findViewById(R.id.btProduto);
        Button btCliente = findViewById(R.id.btCliente);
        Button btListaVendas = findViewById(R.id.btListaVendas);

        btHome.setOnClickListener(view -> Activity.run(this, HomeActivity.class));
        btCatalogo.setOnClickListener(view -> Activity.run(this, CatalogoActivity.class));
        btExtrato.setOnClickListener(view -> Activity.run(this, ExtratoActivity.class));
        btUsuario.setOnClickListener(view -> Activity.run(this, CadastroUsuarioActivity.class));
        btProduto.setOnClickListener(view -> Activity.run(this, CadastroProduto.class));
        btCliente.setOnClickListener(view -> Activity.run(this, CadastroClienteActivity.class));
        btListaVendas.setOnClickListener(view -> Activity.run(this, VendaListActivity.class));
    }
}
