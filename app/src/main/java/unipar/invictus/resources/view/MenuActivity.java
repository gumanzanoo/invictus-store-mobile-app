package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;
import unipar.invictus.resources.helpers.Activity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btHome = findViewById(R.id.btHome);
        Button btExtrato = findViewById(R.id.btExtrato);
        Button btListaVendas = findViewById(R.id.btListaVendas);
        Button btUsuario = findViewById(R.id.btUsuario);
        Button btProduto = findViewById(R.id.btProduto);
        Button btCliente = findViewById(R.id.btCliente);

        btHome.setOnClickListener(view -> Activity.run(this, HomeActivity.class));
        btExtrato.setOnClickListener(view -> Activity.run(this, ExtratoActivity.class));
        btListaVendas.setOnClickListener(view -> Activity.run(this, VendaListActivity.class));
        btUsuario.setOnClickListener(view -> Activity.run(this, UsuarioListActivity.class));
        //btProduto.setOnClickListener(view -> Activity.run(this, ProdutoListActivity.class));
        //btCliente.setOnClickListener(view -> Activity.run(this, ClienteListActivity.class));
    }
}
