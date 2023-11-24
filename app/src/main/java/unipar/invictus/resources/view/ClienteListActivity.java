package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.ClienteController;
import unipar.invictus.app.entity.Cliente;
import unipar.invictus.resources.adapter.ClientesListAdapter;
import unipar.invictus.resources.helpers.Activity;

public class ClienteListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_list);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btCadastroCliente = findViewById(R.id.btCadastroCliente);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        btCadastroCliente.setOnClickListener(view -> Activity.run(this, CadastroClienteActivity.class));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewClientes);

        ClienteController clienteController = new ClienteController(this);

        ArrayList<Cliente> listaClientes = clienteController.getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ClientesListAdapter clientesListAdapter = new ClientesListAdapter(listaClientes, this);
        recyclerView.setAdapter(clientesListAdapter);
    }
}
