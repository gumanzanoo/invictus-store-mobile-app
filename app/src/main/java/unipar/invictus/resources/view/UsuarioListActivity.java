package unipar.invictus.resources.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.UsuarioController;
import unipar.invictus.app.entity.Usuario;
import unipar.invictus.resources.adapter.UsuariosListAdapter;

public class UsuarioListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewVendas);

        UsuarioController usuarioController = new UsuarioController(this);

        ArrayList<Usuario> listaUsuarios = usuarioController.getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UsuariosListAdapter usuariosListAdapter = new UsuariosListAdapter(listaUsuarios, this);
        recyclerView.setAdapter(usuariosListAdapter);
    }
}
