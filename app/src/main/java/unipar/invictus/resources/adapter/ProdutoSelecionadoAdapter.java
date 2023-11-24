package unipar.invictus.resources.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import unipar.invictus.R;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.resources.view.CadastroVendaActivity;

public class ProdutoSelecionadoAdapter extends RecyclerView.Adapter<ProdutoSelecionadoAdapter.ProdutoViewHolder> {
    private final List<Produto> produtosSelecionados;
    private final LayoutInflater inflater;
    private final CadastroVendaActivity activity;

    public ProdutoSelecionadoAdapter(Context context, List<Produto> produtosSelecionados, CadastroVendaActivity activity) {
        this.inflater = LayoutInflater.from(context);
        this.produtosSelecionados = produtosSelecionados;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_selecionado_item, parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = produtosSelecionados.get(position);

        holder.tvDescricao.setText(produto.getDescricao());
        holder.tvValorUnitario.setText(String.valueOf(produto.getValorUnitario()));

        holder.btnRemover.setOnClickListener(v -> {
            if (activity != null) {
                activity.removerProduto(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return produtosSelecionados.size();
    }

    static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescricao;
        TextView tvValorUnitario;
        Button btnRemover;

        ProdutoViewHolder(View itemView) {
            super(itemView);
            tvDescricao = itemView.findViewById(R.id.tvProdutoSelecionadoDescricao);
            tvValorUnitario = itemView.findViewById(R.id.tvProdutoSelecionadoValorUnitario);
            btnRemover = itemView.findViewById(R.id.btnRemoverProduto);
        }
    }
}
