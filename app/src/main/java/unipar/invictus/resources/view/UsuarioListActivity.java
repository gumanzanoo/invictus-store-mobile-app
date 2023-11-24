package unipar.invictus.resources.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.UsuarioController;
import unipar.invictus.app.entity.Usuario;
import unipar.invictus.resources.adapter.UsuariosListAdapter;
import unipar.invictus.resources.helpers.Activity;

public class UsuarioListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_list);

        ImageButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton btCadastroUsuario = findViewById(R.id.btCadastroUsuario);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
        btCadastroUsuario.setOnClickListener(view -> Activity.run(this, CadastroUsuarioActivity.class));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewUsuarios);

        UsuarioController usuarioController = new UsuarioController(this);

        ArrayList<Usuario> listaUsuarios = usuarioController.getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UsuariosListAdapter usuariosListAdapter = new UsuariosListAdapter(listaUsuarios, this);
        recyclerView.setAdapter(usuariosListAdapter);
    }
}
