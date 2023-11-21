package unipar.invictus.app.helpers;

import java.util.Random;

import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.repository.ProdutoRepository;

public class GeradorCodigoProduto {
    private static ProdutoRepository produtoRepository;

    public GeradorCodigoProduto(ProdutoRepository produtoRepository) {
        GeradorCodigoProduto.produtoRepository = produtoRepository;
    }

    private static final long LIMITE_MAXIMO = 999_999_999_999L;
    private static final int LIMITE_DE_TENTATIVAS = 10;

    public static int run() {
        Random random = new Random();

        for (int tentativa = 0; tentativa < LIMITE_DE_TENTATIVAS; tentativa++) {
            int codigoGerado = (int) (random.nextLong() % LIMITE_MAXIMO + LIMITE_MAXIMO);
            Produto savedCode = produtoRepository.getByCodigo(codigoGerado);

            if (savedCode == null) {
                return codigoGerado;
            }
        }

        throw new RuntimeException("Erro interno ao gerar código.");
    }
}
