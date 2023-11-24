package unipar.invictus.resources.view;

import android.os.Bundle;

import unipar.invictus.R;
import unipar.invictus.app.controller.VendaController;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesVendaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_venda);

        VendaController vendaController = new VendaController(this);

    }
}
