package unipar.invictus.resources.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import unipar.invictus.R;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.entity.ItensVenda;
import unipar.invictus.app.entity.Produto;

public class ItemsDetalhesVendaAdapter extends
        RecyclerView.Adapter<ItemsDetalhesVendaAdapter.ItemsDetalhesVendaViewHolder> {
    private final List<ItensVenda> itensVenda;
    private final LayoutInflater inflater;

    public ItemsDetalhesVendaAdapter(Context context, List<ItensVenda> itensVenda) {
        this.inflater = LayoutInflater.from(context);
        this.itensVenda = itensVenda;
    }

    @NonNull
    @Override
    public ItemsDetalhesVendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_venda_detalhes, parent, false);
        return new ItemsDetalhesVendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsDetalhesVendaViewHolder holder, int position) {
        ItensVenda item = itensVenda.get(position);
        ProdutoController produtoController = new ProdutoController(inflater.getContext());
        Produto produto = produtoController.getById(item.getIdProduto());

        Log.d("ItemsDetalhesVendaAdapter", "Número de itens na lista: " + itensVenda.size());

        if (produto != null) {
            holder.tvDescricao.setText(produto.getDescricao());
            holder.tvCodigo.setText(produto.getCod());
            holder.tvValorUnitario.setText(String.valueOf(produto.getValorUnitario()));
            holder.tvQuantidade.setText(String.valueOf(item.getQuantidade()));
        }
    }

    @Override
    public int getItemCount() {
        return itensVenda.size();
    }

    static class ItemsDetalhesVendaViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescricao;
        TextView tvCodigo;
        TextView tvValorUnitario;
        TextView tvQuantidade;

        ItemsDetalhesVendaViewHolder(View itemView) {
            super(itemView);
            tvDescricao = itemView.findViewById(R.id.tvProdutoDetalheDescricao);
            tvCodigo = itemView.findViewById(R.id.tvProdutoDetalheCodigo);
            tvValorUnitario = itemView.findViewById(R.id.tvProdutoDetalheValorUnitario);
            tvQuantidade = itemView.findViewById(R.id.tvQuantidade);
        }
    }
}
