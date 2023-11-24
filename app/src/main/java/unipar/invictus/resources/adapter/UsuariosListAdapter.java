package unipar.invictus.resources.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.entity.Usuario;

public class UsuariosListAdapter extends
        RecyclerView.Adapter<UsuariosListAdapter.ViewHolder> {

    private final ArrayList<Usuario> listaUsuarios;
    private Context context;

    public UsuariosListAdapter(ArrayList<Usuario> listaUsuarios, Context context) {
        this.listaUsuarios = listaUsuarios;
        this.context = context;
    }

    @NonNull
    @Override
    public UsuariosListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_list_usuario, parent, false);
        return new UsuariosListAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosListAdapter.ViewHolder holder, int position) {
        Usuario usuarioSelecionado = listaUsuarios.get(position);

        holder.textViewUsuarioId.setText(String.valueOf(usuarioSelecionado.getId()));
        holder.textViewUsuarioNome.setText(usuarioSelecionado.getNome());
        holder.textViewUsuarioEmail.setText(usuarioSelecionado.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.listaUsuarios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewUsuarioId;
        public TextView textViewUsuarioNome;
        public TextView textViewUsuarioEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewUsuarioId = itemView.findViewById(R.id.textViewUsuarioId);
            this.textViewUsuarioNome = itemView.findViewById(R.id.textViewUsuarioNome);
            this.textViewUsuarioEmail = itemView.findViewById(R.id.textViewUsuarioEmail);
        }
    }
}
