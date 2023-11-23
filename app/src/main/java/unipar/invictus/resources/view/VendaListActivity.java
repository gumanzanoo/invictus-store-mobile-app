package unipar.invictus.resources.view;

import unipar.invictus.R;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import unipar.invictus.app.controller.VendaController;
import unipar.invictus.app.entity.Venda;
import unipar.invictus.resources.adapter.VendaListAdapter;

public class VendaListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewVendas);
        VendaController vendaController = new VendaController(this);

        ArrayList<Venda> listaVendas = vendaController.getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        VendaListAdapter vendaListAdapter = new VendaListAdapter(listaVendas, this);
        recyclerView.setAdapter(vendaListAdapter);
    }
}
