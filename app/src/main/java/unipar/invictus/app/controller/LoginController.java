package unipar.invictus.app.controller;

import unipar.invictus.app.config.Response;
import unipar.invictus.app.entity.Usuario;
import unipar.invictus.app.repository.UsuarioRepository;

public class LoginController {
    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Response cadastrarUsuario(String nome, String email, String senha) {
        Usuario savedUser = usuarioRepository.getByEmail(email);

        if (savedUser.getEmail().equals(email)) {
            return Response.response(Response.SUCCESS,
                    "Já existe um usuário cadastrado com este e-mail");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        long userRegistered = usuarioRepository.insert(usuario);

        if (userRegistered > 0) {
            return Response.response(Response.SUCCESS,
                    "Usuário cadastrado com sucesso");
        }

        return Response.response(Response.ERROR,
                "Não foi possível cadastrar o usuário");
    }

    public Response autenticarUsuario(String email, String senha) {
        Usuario usuario = usuarioRepository.getByEmail(email);

        if (usuario == null) {
            return Response.response(Response.ERROR,
                    "Este email não está cadastrado.");
        }

        if (!usuario.getSenha().equals(senha)) {
            return Response.response(Response.ERROR,
                    "Senha incorreta.");
        }

        return Response.response(Response.SUCCESS,
                "Usuário autenticado com sucesso.");
    }
}
