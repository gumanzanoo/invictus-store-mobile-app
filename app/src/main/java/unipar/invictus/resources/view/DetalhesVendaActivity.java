package unipar.invictus.resources.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.VendaController;
import unipar.invictus.app.entity.ItensVenda;
import unipar.invictus.app.entity.Venda;
import unipar.invictus.resources.adapter.ItemsDetalhesVendaAdapter;

public class DetalhesVendaActivity extends AppCompatActivity {

    private TextView tvIdVenda, tvValorTotalVenda, tvIdCliente, tvNomeCliente, tvEmailCliente, tvDocumentoCliente;
    private RecyclerView recyclerViewItensVenda;
    private ItemsDetalhesVendaAdapter itensAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_venda);

        // Inicializar as views
        tvIdVenda = findViewById(R.id.tvIdVenda);
        tvValorTotalVenda = findViewById(R.id.tvValorTotalVenda);
        tvIdCliente = findViewById(R.id.tvIdCliente);
        tvNomeCliente = findViewById(R.id.tvNomeCliente);
        tvEmailCliente = findViewById(R.id.tvEmailCliente);
        tvDocumentoCliente = findViewById(R.id.tvDocumentoCliente);
        recyclerViewItensVenda = findViewById(R.id.recyclerViewItensVenda);

        // Obter o ID da venda da Intent
        int vendaId = getIntent().getIntExtra("id", 1);

        VendaController vendaController = new VendaController(this);
        Venda venda = vendaController.getById(vendaId);

        ArrayList<ItensVenda> itensVenda = venda.getItensVenda();
        if (venda != null) {
            tvIdVenda.setText("ID da Venda: " + venda.getId());
            tvValorTotalVenda.setText("Valor Total: " + venda.getValorTotal());

            tvIdCliente.setText("ID do Cliente: " + venda.getCliente().getId());
            tvNomeCliente.setText("Nome do Cliente: " + venda.getCliente().getNome());
            tvEmailCliente.setText("Email do Cliente: " + venda.getCliente().getEmail());
            tvDocumentoCliente.setText("Documento do Cliente: " + venda.getCliente().getDocumento());

            if (itensVenda != null) {
                Log.e("DetalhesVendaActivity", "Número de itens na venda: " + itensVenda.size());
                recyclerViewItensVenda.setLayoutManager(new LinearLayoutManager(this));
                itensAdapter = new ItemsDetalhesVendaAdapter(this, itensVenda);
                recyclerViewItensVenda.setAdapter(itensAdapter);
            }
        }
    }
}
