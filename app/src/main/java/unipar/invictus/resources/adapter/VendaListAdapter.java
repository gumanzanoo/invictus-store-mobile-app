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
        View listItem = inflater.inflate(R.layout.item_list_venda, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Venda vendaSelecionada = listaVendas.get(position);

        Log.e("VendaListAdapter",
                "textViewVendaId: " + String.valueOf(vendaSelecionada.getId()) +
                " textViewClienteNome: " + vendaSelecionada.getCliente().getNome() +
                " textViewValorTotal: " + String.valueOf(vendaSelecionada.getValorTotal())
        );

        holder.textViewVendaId.setText(String.valueOf(vendaSelecionada.getId()));
        holder.textViewClienteNome.setText(vendaSelecionada.getCliente().getNome());
        holder.textViewValorTotal.setText(String.valueOf(vendaSelecionada.getValorTotal()));
    }

    @Override
    public int getItemCount() {
        return this.listaVendas.size();
    }

//    public void atualizarLista(ArrayList<Venda> novaLista) {
//        this.listaVendas.clear();
//        this.listaVendas.addAll(novaLista);
//        notifyDataSetChanged();
//    }

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
