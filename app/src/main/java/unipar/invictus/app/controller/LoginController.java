package unipar.invictus.app.controller;

import android.content.Context;
import unipar.invictus.app.dao.UsuarioDao;
import unipar.invictus.app.entity.Usuario;
import unipar.invictus.app.helpers.Response;

public class LoginController {
    public UsuarioDao usuarioDao;

    public LoginController(Context context) {
        usuarioDao = new UsuarioDao(context);
    }

    public Response login(String email, String senha) {
        Usuario usuario = usuarioDao.getByEmail(email);

        if (usuario == null) {
            return Response.response(Response.ERROR, "E-mail ou senha inválidos");
        }

        if (usuario.getSenha().equals(senha)) {
            return Response.response(Response.SUCCESS, "Login realizado com sucesso");
        }

        return Response.response(Response.ERROR, "E-mail ou senha inválidos");
    }

    public Response cadastro(String nome, String email, String senha) {
        if (usuarioExistsByEmail(email)) {
            return Response.response(Response.ERROR,
                    "Já existe um usuário cadastrado com este e-mail");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        usuarioDao.insert(usuario);
        return Response.response(Response.SUCCESS,
                "Usuário cadastrado com sucesso");
    }

    private boolean usuarioExistsByEmail(String email) {
        Usuario usuario = usuarioDao.getByEmail(email);
        return usuario != null;
    }
}
