package unipar.invictus.resources.view;

import unipar.invictus.R;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import unipar.invictus.app.controller.VendaController;
import unipar.invictus.app.entity.Venda;
import unipar.invictus.resources.adapter.VendaListAdapter;
import unipar.invictus.resources.helpers.Activity;

public class VendaListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda_list);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btCadastroVenda = findViewById(R.id.btCadastroVenda);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        btCadastroVenda.setOnClickListener(view -> Activity.run(this, CadastroVendaActivity.class));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewVendas);
        VendaController vendaController = new VendaController(this);

        ArrayList<Venda> listaVendas = vendaController.getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        VendaListAdapter vendaListAdapter = new VendaListAdapter(listaVendas, this);
        recyclerView.setAdapter(vendaListAdapter);
    }
}
