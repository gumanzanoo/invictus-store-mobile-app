package unipar.invictus.app.controller;

import android.content.Context;

import java.util.ArrayList;

import unipar.invictus.app.dao.ClienteDao;
import unipar.invictus.app.dao.ItensVendaDao;
import unipar.invictus.app.dao.ProdutoDao;
import unipar.invictus.app.dao.VendaDao;
import unipar.invictus.app.entity.Cliente;
import unipar.invictus.app.entity.ItensVenda;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.entity.Venda;
import unipar.invictus.app.helpers.Response;

public class VendaController {
    public VendaDao vendaDao;
    public ClienteDao clienteDao;
    public ProdutoDao produtoDao;
    public ItensVendaDao itensVendaDao;

    public VendaController(Context context) {
        vendaDao = new VendaDao(context);
        clienteDao = new ClienteDao(context);
        produtoDao = new ProdutoDao(context);
        itensVendaDao = new ItensVendaDao(context);
    }

    public Response create(int idCliente, ArrayList<Produto> produtos) {
        Cliente cliente = clienteDao.getById(idCliente);
        if (cliente == null) {
            return Response.response(Response.ERROR, "Cliente não encontrado");
        }

        double valorTotal = calcularValorTotal(produtos);

        Venda venda = new Venda();
        venda.setClienteId(idCliente);
        venda.setValorTotal(valorTotal);
        vendaDao.insert(venda);

        attachItensVenda(venda, produtos);

        return Response.response(Response.SUCCESS,
                "Venda cadastrada com sucesso", venda);
    }

    public double calcularValorTotal(ArrayList<Produto> produtos) {
        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getValorUnitario();
        }
        return valorTotal;
    }

    public void attachItensVenda(Venda venda, ArrayList<Produto> produtos) {

        ArrayList<ItensVenda> arrItensVenda = new ArrayList<>();
        for (Produto produto : produtos) {
            ItensVenda ItemVenda = new ItensVenda();
            ItemVenda.setIdVenda(venda.getId());
            ItemVenda.setIdProduto(produto.getId());
            ItemVenda.setQuantidade(produto.getQuantidadeVenda());
            itensVendaDao.insert(ItemVenda);
            produto.setQtdEstoque(produto.getQtdEstoque() - produto.getQuantidadeVenda());
            produtoDao.update(produto);
            arrItensVenda.add(ItemVenda);
        }

        venda.setItensVenda(arrItensVenda);
    }
}
