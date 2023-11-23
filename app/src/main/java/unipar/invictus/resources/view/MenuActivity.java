package unipar.invictus.resources.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.VendaController;
import unipar.invictus.app.entity.Venda;
import unipar.invictus.app.helpers.Activity;
import unipar.invictus.resources.adapter.VendaListAdapter;

public class MenuActivity extends AppCompatActivity {

    private Button btHome;
    private Button btCatalogo;
    private Button btExtrato;
    private Button btUsuario;
    private Button btProduto;
    private Button btCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btHome = findViewById(R.id.btHome);
        btCatalogo = findViewById(R.id.btCatalogo);
        btExtrato = findViewById(R.id.btExtrato);
        btUsuario = findViewById(R.id.btUsuario);
        btProduto = findViewById(R.id.btProduto);
        btCliente = findViewById(R.id.btCliente);

        btHome.setOnClickListener(view -> Activity.run(this, HomeActivity.class));
        btCatalogo.setOnClickListener(view -> Activity.run(this, CatalogoActivity.class));
        btExtrato.setOnClickListener(view -> Activity.run(this, ExtratoActivity.class));
        btUsuario.setOnClickListener(view -> Activity.run(this, CadastroUsuarioActivity.class));
        btProduto.setOnClickListener(view -> Activity.run(this, CadastroProduto.class));
        btCliente.setOnClickListener(view -> Activity.run(this, CadastroClienteActivity.class));
    }
}
