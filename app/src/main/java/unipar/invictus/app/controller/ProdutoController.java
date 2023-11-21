package unipar.invictus.app.controller;

import android.content.Context;

import java.util.Random;

import unipar.invictus.app.dao.ProdutoDao;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.helpers.Response;

public class ProdutoController {
    public ProdutoDao produtoDao;

    public ProdutoController(Context context) {
        produtoDao = new ProdutoDao(context);
    }

    public Response create(String descricao, int valorUnitario, int qtdEstoque) {
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
}
