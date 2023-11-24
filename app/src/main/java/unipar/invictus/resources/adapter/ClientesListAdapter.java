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
import unipar.invictus.app.entity.Cliente;

public class ClientesListAdapter extends
        RecyclerView.Adapter<ClientesListAdapter.ViewHolder> {

    private final ArrayList<Cliente> listaClientes;
    private Context context;

    public ClientesListAdapter(ArrayList<Cliente> listaClientes, Context context) {
        this.listaClientes = listaClientes;
        this.context = context;
    }

    @NonNull
    @Override
    public ClientesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_list_cliente, parent, false);
        return new ClientesListAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesListAdapter.ViewHolder holder, int position) {
        Cliente clienteSelecionado = listaClientes.get(position);

        holder.textViewClienteId.setText(String.valueOf(clienteSelecionado.getId()));
        holder.textViewClienteNome.setText(clienteSelecionado.getNome());
        holder.textViewClienteEmail.setText(clienteSelecionado.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.listaClientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewClienteId;
        public TextView textViewClienteNome;
        public TextView textViewClienteEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewClienteId = itemView.findViewById(R.id.textViewClienteId);
            this.textViewClienteNome = itemView.findViewById(R.id.textViewClienteNome);
            this.textViewClienteEmail = itemView.findViewById(R.id.textViewClienteEmail);
        }
    }
}
