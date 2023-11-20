package unipar.invictus.app.controller;

import unipar.invictus.app.entity.Usuario;
import unipar.invictus.app.repository.UsuarioRepository;

public class LoginController {
    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public long cadastrarUsuario(String nome, String email, String senha) {
        Usuario savedUser = usuarioRepository.getByEmail(email);

        if (savedUser.getEmail().equals(email)) {
            return -1;
        }

        // Implementar lógica de verificação de existência de usuário, se necessário

        // Criar uma instância do usuário
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        // Inserir o usuário no banco de dados
        return usuarioRepository.insert(usuario);
    }

    public boolean autenticarUsuario(String email, String senha) {
        // Buscar o usuário no banco de dados com base no e-mail
        Usuario usuario = usuarioRepository.getByEmail(email);

        // Verificar se o usuário foi encontrado e se a senha corresponde
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
