package unipar.invictus.resources.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.resources.view.DetalhesProdutoActivity;

public class ProdutosListAdapter extends
        RecyclerView.Adapter<ProdutosListAdapter.ViewHolder> {

    private final ArrayList<Produto> listaProdutos;
    private Context context;

    public ProdutosListAdapter(ArrayList<Produto> listaProdutos, Context context) {
        this.listaProdutos = listaProdutos;
        this.context = context;
    }

    @NonNull
    @Override
    public ProdutosListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_list_produto, parent, false);
        return new ProdutosListAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosListAdapter.ViewHolder holder, int position) {
        Produto produtoSelecionado = listaProdutos.get(position);

        holder.textViewProdutoId.setText(String.valueOf(produtoSelecionado.getId()));
        holder.textViewProdutoDescricao.setText(produtoSelecionado.getDescricao());
        holder.textViewProdutoValorUnitario.setText(String.valueOf(produtoSelecionado.getValorUnitario()));

        holder.itemView.setOnClickListener(v -> {
            Produto produto = listaProdutos.get(position);
            Intent intent = new Intent(context, DetalhesProdutoActivity.class);
            intent.putExtra("id", produto.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.listaProdutos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewProdutoId;
        public TextView textViewProdutoDescricao;
        public TextView textViewProdutoValorUnitario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewProdutoId = itemView.findViewById(R.id.textViewProdutoId);
            this.textViewProdutoDescricao = itemView.findViewById(R.id.textViewProdutoDescricao);
            this.textViewProdutoValorUnitario = itemView.findViewById(R.id.textViewProdutoValorUnitario);
        }
    }
}
