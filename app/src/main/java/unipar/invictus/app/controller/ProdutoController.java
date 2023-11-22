package unipar.invictus.app.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

import unipar.invictus.app.dao.ProdutoDao;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.helpers.Response;

public class ProdutoController {
    public ProdutoDao produtoDao;

    public ProdutoController(Context context) {
        produtoDao = new ProdutoDao(context);
    }

    public Response<Produto> getById(int id) {
        Produto produto = produtoDao.getById(id);
        if (produto == null) {
            return Response.response(Response.ERROR, "Produto não encontrado");
        }

        return Response.response(Response.SUCCESS,
                "Produto encontrado", produto);
    }

    public Response<Produto> getByCod(int cod) {
        Produto produto = produtoDao.getByCod(cod);
        if (produto == null) {
            return Response.response(Response.ERROR, "Produto não encontrado");
        }

        return Response.response(Response.SUCCESS,
                "Produto encontrado", produto);
    }

    public Response<ArrayList<Produto>> getAll() {
        return Response.response(Response.SUCCESS,
                "Produtos encontrados", produtoDao.getAll());
    }

    public Response<Produto> create(String descricao, double valorUnitario, int qtdEstoque) {
        Produto produto = new Produto();
        produto.setCod(gerarCodigo());
        produto.setDescricao(descricao);
        produto.setValorUnitario(valorUnitario);
        produto.setQtdEstoque(qtdEstoque);

        Produto produtoRegistered = produtoDao.insert(produto);
        return Response.response(Response.SUCCESS,
                "Produto cadastrado com sucesso", produtoRegistered);
    }

    private int gerarCodigo() {
        Random random = new Random();
        int LIMITE_MAXIMO = 999_999_999;
        int LIMITE_DE_TENTATIVAS = 10;
        for (int tentativa = 0; tentativa < LIMITE_DE_TENTATIVAS; tentativa++) {
            int codigoGerado = (int) (random.nextLong() % LIMITE_MAXIMO + LIMITE_MAXIMO);
            Produto savedCode = produtoDao.getByCod(codigoGerado);

            if (savedCode == null) {
                return codigoGerado;
            }
        }

        throw new RuntimeException("Erro interno ao gerar código.");
    }

    public Response<?> update(Produto produto) {
        Produto updatedProduto = produtoDao.update(produto);
        if (updatedProduto != null) {
            return Response.response(Response.SUCCESS,
                    "Produto atualizado com sucesso", updatedProduto);
        }

        return Response.response(Response.ERROR,
                "Erro ao atualizar produto");
    }

    public Response<?> delete(int id) {
        Produto produto = produtoDao.getById(id);

        if (produto == null) {
            return Response.response(Response.ERROR,
                    "Produto não encontrado");
        }

        produtoDao.delete(produto);
        return Response.response(Response.SUCCESS,
                "Produto excluído com sucesso");

    }
}
