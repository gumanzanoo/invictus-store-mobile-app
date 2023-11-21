//package unipar.invictus.app.controller;
//
//import unipar.invictus.app.helpers.Response;
//import unipar.invictus.app.entity.Produto;
//import unipar.invictus.app.repository.ProdutoRepository;
//
//public class ProdutoController {
//    private final ProdutoRepository produtoRepository;
//
//    public ProdutoController(ProdutoRepository produtoRepository) {
//        this.produtoRepository = produtoRepository;
////    }
//
//    public Response cadastrarProduto(String descricao, double valorUnitario) {
//        Produto savedProduct = produtoRepository.getByDescricao(descricao);
//
//        if (savedProduct.getDescricao().equals(descricao)) {
//            return Response.response(Response.SUCCESS,
//                    "Já existe um produto cadastrado com este nome");
//        }
//
//        Produto produto = new Produto();
//        produto.setDescricao(descricao);
//        produto.setCod(GeradorCodigoProduto.run());
//        produto.setValorUnitario(valorUnitario);
//
//        long productRegistered = produtoRepository.insert(produto);
//
//        if (productRegistered > 0) {
//            return Response.response(Response.SUCCESS,
//                    "Produto cadastrado com sucesso");
//        }
//
//        return Response.response(Response.ERROR,
//                "Não foi possível cadastrar o produto");
//    }
//
//    public Response alterarProduto(int id, String descricao, double valorUnitario) {
//        Produto savedProduct = produtoRepository.getById(id);
//
//        if (savedProduct == null) {
//            return Response.response(Response.ERROR,
//                    "Não existe um produto cadastrado com este id");
//        }
//
//        Produto produto = new Produto();
//        produto.setId(id);
//        produto.setDescricao(descricao);
//        produto.setValorUnitario(valorUnitario);
//
//        int productUpdated = produtoRepository.update(produto);
//
//        if (productUpdated > 0) {
//            return Response.response(Response.SUCCESS,
//                    "Produto alterado com sucesso");
//        }
//
//        return Response.response(Response.ERROR,
//                "Não foi possível alterar o produto");
//    }
//
//    public Response excluirProduto(int id) {
//        Produto savedProduct = produtoRepository.getById(id);
//
//        if (savedProduct == null) {
//            return Response.response(Response.ERROR,
//                    "Não existe um produto cadastrado com este id");
//        }
//
//        Produto produto = new Produto();
//        produto.setId(id);
//
//        int productDeleted = produtoRepository.delete(produto);
//
//        if (productDeleted > 0) {
//            return Response.response(Response.SUCCESS,
//                    "Produto excluído com sucesso");
//        }
//
//        return Response.response(Response.ERROR,
//                "Não foi possível excluir o produto");
//    }
//}
