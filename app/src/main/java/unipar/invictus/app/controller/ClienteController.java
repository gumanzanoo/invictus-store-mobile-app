package unipar.invictus.app.controller;

import unipar.invictus.app.helpers.Response;
import unipar.invictus.app.entity.Cliente;
import unipar.invictus.app.repository.ClienteRepository;

public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Response getById(int id) {
        return Response.response(Response.SUCCESS, clienteRepository.getById(id).toString());
    }

    public Response getAll() {
        return Response.response(Response.SUCCESS, clienteRepository.getAll().toString());
    }

    public Response create(String nome, String documento, String email) {
        Cliente savedCliente = clienteRepository.getByEmail(email);

        if (savedCliente.getDocumento().equals(documento)) {
            return Response.response(Response.ERROR,
                    "Já existe um cliente cadastrado com este Documento");
        }

        if (savedCliente.getEmail().equals(email)) {
            return Response.response(Response.ERROR,
                    "Já existe um cliente cadastrado com este e-mail");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setDocumento(documento);
        cliente.setEmail(email);

        long clienteRegistered = clienteRepository.insert(cliente);

        if (clienteRegistered > 0) {
            return Response.response(Response.SUCCESS,
                    "Cliente cadastrado com sucesso");
        }

        return Response.response(Response.ERROR,
                "Não foi possível cadastrar o cliente");
    }

    public Response update(int id, String nome, String documento, String email) {
        Cliente cliente = clienteRepository.getById(id);

        if (cliente == null) {
            return Response.response(Response.ERROR,
                    "Este cliente não está cadastrado.");
        }

        cliente.setNome(nome);
        cliente.setDocumento(documento);
        cliente.setEmail(email);

        int clienteUpdated = clienteRepository.update(cliente);

        if (clienteUpdated > 0) {
            return Response.response(Response.SUCCESS,
                    "Cliente atualizado com sucesso");
        }

        return Response.response(Response.ERROR,
                "Não foi possível atualizar o cliente");
    }

    public Response delete(int id) {
        Cliente cliente = clienteRepository.getById(id);

        if (cliente == null) {
            return Response.response(Response.ERROR,
                    "Este cliente não está cadastrado.");
        }

        int clienteDeleted = clienteRepository.delete(cliente);

        if (clienteDeleted > 0) {
            return Response.response(Response.SUCCESS,
                    "Cliente deletado com sucesso");
        }

        return Response.response(Response.ERROR,
                "Não foi possível deletar o cliente");
    }
}
