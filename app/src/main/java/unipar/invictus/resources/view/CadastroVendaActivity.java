package unipar.invictus.resources.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import unipar.invictus.R;
import unipar.invictus.app.controller.ClienteController;
import unipar.invictus.app.controller.ProdutoController;
import unipar.invictus.app.controller.VendaController;
import unipar.invictus.app.entity.Cliente;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.resources.adapter.ProdutoSelecionadoAdapter;
import unipar.invictus.resources.helpers.Activity;

public class CadastroVendaActivity extends AppCompatActivity {

    private Cliente cliente;
    private final ArrayList<Produto> produtosSelecionados = new ArrayList<>();
    private RecyclerView rvProdutosSelecionados;
    private ProdutoSelecionadoAdapter produtoAdapter;
    private TextView tvClienteSelecionado;
    public TextView tvValorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_venda);

        Spinner spClientes = findViewById(R.id.spClientes);
        spinnerClientes(spClientes);

        Spinner spProdutos = findViewById(R.id.spProdutos);
        spinnerProdutos(spProdutos);

        rvProdutosSelecionados = findViewById(R.id.rvProdutosSelecionados);
        rvProdutosSelecionados.setLayoutManager(new LinearLayoutManager(this));
        produtoAdapter = new ProdutoSelecionadoAdapter(this, produtosSelecionados, CadastroVendaActivity.this);
        rvProdutosSelecionados.setAdapter(produtoAdapter);

        Button btCadastrarVenda = findViewById(R.id.btCadastrarVenda);
        btCadastrarVenda.setOnClickListener(view -> cadastrarVenda());
    }

    public void spinnerProdutos(Spinner spProdutos) {
        ProdutoController produtoController = new ProdutoController(this);
        ArrayList<Produto> produtos = produtoController.getAll();

        String[] produtosDescricao;

        if (produtos != null && !produtos.isEmpty()) {
            produtosDescricao = new String[produtos.size()];

            for (Produto produto : produtos) {
                produtosDescricao[produtos.indexOf(produto)] = produto.getDescricao();
            }

            Produto placeholder = new Produto();
            placeholder.setDescricao("Selecione um produto");
            produtos.add(0, placeholder);

            ArrayAdapter<Produto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, produtos);
            spProdutos.setAdapter(adapter);

            spProdutos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View view, int position, long l) {
                    if (position > 0) {
                        Produto produtoSelecionado = (Produto) parentView.getItemAtPosition(position);

                        int index = produtosSelecionados.indexOf(produtoSelecionado);
                        if (index != -1) {
                            Produto produtoExistente = produtosSelecionados.get(index);
                            produtoExistente.setQuantidadeVenda(produtoExistente.getQuantidadeVenda() + 1);
                        } else {
                            produtoSelecionado.setQuantidadeVenda(1);
                            produtosSelecionados.add(produtoSelecionado);
                        }

                        produtoAdapter.notifyDataSetChanged();

                        tvValorTotal = findViewById(R.id.tvValorTotal);
                        if (tvValorTotal != null) {
                            tvValorTotal.setText("Valor Total: " + calcularTotal(produtosSelecionados));
                        } else {
                            Log.e("CadastroVendaActivity", "TextView not found");
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    Toast.makeText(getApplicationContext(), "Você precisa selecionar um produto.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            produtosDescricao = new String[]{"Nenhum produto cadastrado"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, produtosDescricao);
            spProdutos.setAdapter(adapter);
        }
    }

    public void spinnerClientes(Spinner spClientes) {
        ClienteController clienteController = new ClienteController(this);
        ArrayList<Cliente> clientes = clienteController.getAll();

        String[] clientesNome;

        if (clientes != null && !clientes.isEmpty()) {
            clientesNome = new String[clientes.size()];

            for (Cliente cliente : clientes) {
                clientesNome[clientes.indexOf(cliente)] = cliente.getNome();
            }

            Cliente placeholder = new Cliente();
            placeholder.setNome("cliente");
            placeholder.setEmail("cliente@email");
            clientes.add(0, placeholder);

            ArrayAdapter<Cliente> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, clientes);
            spClientes.setAdapter(adapter);

            spClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    tvClienteSelecionado = findViewById(R.id.tvClienteSelecionado); // Substitua com o ID correto
                    if (tvClienteSelecionado != null) {
                        if (position > 0) {
                            Cliente clienteSelecionado = (Cliente) parentView.getItemAtPosition(position);
                            if (!produtosSelecionados.contains(clienteSelecionado)) {
                                cliente = clienteSelecionado;
                                tvClienteSelecionado.setText(clienteSelecionado.getNome() + " - " + clienteSelecionado.getEmail());
                                Log.d("CadastroVendaActivity", "Cliente selecionado: " + cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getEmail());
                            }
                        }
                    } else {
                        Log.e("CadastroVendaActivity", "TextView not found");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    Toast.makeText(getApplicationContext(), "Você precisa selecionar um cliente.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            clientesNome = new String[]{"Nenhum cliente cadastrado"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, clientesNome);
            spClientes.setAdapter(adapter);
        }
    }

    public double calcularTotal(ArrayList<Produto> arrProdutosSelecionados) {
        double total = 0;
        for (Produto produto : arrProdutosSelecionados) {
            total += produto.getValorUnitario() * produto.getQuantidadeVenda();
        }
        Log.d("CadastroVendaActivity", "Total: " + total);
        return total;
    }

    public void updateTotalValue() {
        if (tvValorTotal != null) {
            tvValorTotal.setText("Valor Total: " + calcularTotal(produtosSelecionados));
        } else {
            Log.e("CadastroVendaActivity", "TextView not found");
        }
    }

    public void cadastrarVenda() {
        VendaController vendaController = new VendaController(this);
        vendaController.create(cliente.getId(), produtosSelecionados);

        Toast.makeText(this, "Venda cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
        Activity.run(this, VendaListActivity.class);
    }

    public void removerProduto(int position) {
        produtosSelecionados.remove(position);
        produtoAdapter.notifyItemRemoved(position);
    }
}
