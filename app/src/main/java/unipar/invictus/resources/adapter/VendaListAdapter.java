package unipar.invictus.resources.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import unipar.invictus.R;
import unipar.invictus.app.entity.Venda;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VendaListAdapter extends
        RecyclerView.Adapter<VendaListAdapter.ViewHolder> {

    private final ArrayList<Venda> listaVendas;
    private Context context;

    public VendaListAdapter(ArrayList<Venda> listaVendas, Context context) {
        this.listaVendas = listaVendas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.activity_venda_list, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Venda vendaSelecionada = listaVendas.get(position);

        if (holder.textViewVendaId != null) {
            holder.textViewVendaId.setText("ID: " + String.valueOf(vendaSelecionada.getId()));
        }

        if (holder.textViewClienteNome != null) {
            holder.textViewClienteNome.setText("Cliente: " + vendaSelecionada.getCliente().getNome());
        }

        if (holder.textViewValorTotal != null) {
            holder.textViewValorTotal.setText("Valor Total: " + String.valueOf(vendaSelecionada.getValorTotal()));
        }
    }

    @Override
    public int getItemCount() {
        return this.listaVendas.size();
    }

    public void atualizarLista(ArrayList<Venda> novaLista) {
        this.listaVendas.clear();
        this.listaVendas.addAll(novaLista);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewVendaId;
        public TextView textViewClienteNome;
        public TextView textViewValorTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewVendaId = itemView.findViewById(R.id.textViewVendaId);
            this.textViewClienteNome = itemView.findViewById(R.id.textViewClienteNome);
            this.textViewValorTotal = itemView.findViewById(R.id.textViewValorTotal);
        }
    }
}
