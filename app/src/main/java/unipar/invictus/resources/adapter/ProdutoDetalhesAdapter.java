package unipar.invictus.resources.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import unipar.invictus.R;
import unipar.invictus.app.entity.Produto;

public class ProdutoDetalhesAdapter extends
        RecyclerView.Adapter<ProdutoDetalhesAdapter.ProdutoDetalhesViewHolder> {
    private final LayoutInflater inflater;

    private final List<Produto> produtos;

    public ProdutoDetalhesAdapter(Context context, ArrayList<Produto> produtos) {
        this.inflater = LayoutInflater.from(context);
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoDetalhesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_venda_detalhes, parent, false);
        return new ProdutoDetalhesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoDetalhesViewHolder holder, int position) {
        Produto produto = produtos.get(position);

        if (produto != null) {
            holder.tvDescricao.setText(produto.getDescricao());
            holder.tvCodigo.setText(produto.getCod());
            holder.tvValorUnitario.setText(String.valueOf(produto.getValorUnitario()));
            holder.tvQuantidade.setText(String.valueOf(produto.getQuantidadeVenda()));
        }
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    static class ProdutoDetalhesViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescricao;
        TextView tvCodigo;
        TextView tvValorUnitario;
        TextView tvQuantidade;

        ProdutoDetalhesViewHolder(View itemView) {
            super(itemView);
            tvDescricao = itemView.findViewById(R.id.tvProdutoDetalheDescricao);
            tvCodigo = itemView.findViewById(R.id.tvProdutoDetalheCodigo);
            tvValorUnitario = itemView.findViewById(R.id.tvProdutoDetalheValorUnitario);
            tvQuantidade = itemView.findViewById(R.id.tvQuantidade);
        }
    }
}
