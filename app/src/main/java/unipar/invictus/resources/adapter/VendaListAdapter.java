package unipar.invictus.resources.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import unipar.invictus.R;
import unipar.invictus.app.entity.Venda;
import unipar.invictus.resources.view.DetalhesVendaActivity;

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
        View listItem = inflater.inflate(R.layout.item_list_venda, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Venda vendaSelecionada = listaVendas.get(position);

        holder.textViewVendaId.setText(String.valueOf(vendaSelecionada.getId()));
        holder.textViewClienteNome.setText(vendaSelecionada.getCliente().getNome());
        holder.textViewValorTotal.setText(String.valueOf(vendaSelecionada.getValorTotal()));

        holder.itemView.setOnClickListener(v -> {
            Venda venda = listaVendas.get(position);
            Intent intent = new Intent(context, DetalhesVendaActivity.class);
            intent.putExtra("id", venda.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.listaVendas.size();
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
