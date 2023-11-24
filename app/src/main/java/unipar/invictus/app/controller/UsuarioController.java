package unipar.invictus.app.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import unipar.invictus.app.dao.UsuarioDao;
import unipar.invictus.app.entity.Usuario;
import unipar.invictus.app.helpers.Response;

public class UsuarioController {
    public UsuarioDao usuarioDao;

    public UsuarioController(Context context) {
        usuarioDao = new UsuarioDao(context);
    }

    public Response login(String email, String senha) {
        Usuario usuario = usuarioDao.getByEmail(email);

        if (usuario == null) {
            return new Response(Response.ERROR, "E-mail ou senha inválidos");
        }

        if (usuario.getSenha().equals(senha)) {
            return new Response(Response.SUCCESS, "Login realizado com sucesso");
        }

        return new Response(Response.ERROR, "E-mail ou senha inválidos");
    }

    public Usuario getById(int id) {
        return usuarioDao.getById(id);
    }

    public Usuario getByEmail(String email) {
        return usuarioDao.getByEmail(email);
    }

    public ArrayList<Usuario> getAll() {
        return usuarioDao.getAll();
    }

    public Response cadastrarUsuario(String nome, String email, String senha) {
        if (usuarioExistsByEmail(email)) {
            return new Response(Response.ERROR,
                    "Já existe um usuário cadastrado com este e-mail");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        usuarioDao.insert(usuario);
        return new Response(Response.SUCCESS,
                "Usuário cadastrado com sucesso");
    }

    private boolean usuarioExistsByEmail(String email) {
        Usuario usuario = usuarioDao.getByEmail(email);
        return usuario != null;
    }
}
