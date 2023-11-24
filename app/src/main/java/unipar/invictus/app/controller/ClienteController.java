package unipar.invictus.app.controller;

import android.content.Context;

import java.util.ArrayList;

import unipar.invictus.app.dao.ClienteDao;
import unipar.invictus.app.helpers.Response;
import unipar.invictus.app.entity.Cliente;
public class ClienteController {
    public ClienteDao clienteDao;

    public ClienteController(Context context) {
        clienteDao = new ClienteDao(context);
    }

    public Cliente getById(int id) {
        return clienteDao.getById(id);
    }

    public ArrayList<Cliente> getAll() {
        return clienteDao.getAll();
    }

    public Cliente getByDocumento(String documento) {
        return clienteDao.getByDocumento(documento);
    }

    public Cliente getByEmail(String email) {
        return clienteDao.getByEmail(email);
    }

    public Response create(String nome, String documento, String email) {

        if (clienteExistsByEmail(email)) {
            return new Response(Response.ERROR,
                    "Já existe um cliente cadastrado com este e-mail");
        }

        if (clienteExistsByDocumento(documento)) {
            return new Response(Response.ERROR,
                    "Já existe um cliente cadastrado com este Documento");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setDocumento(documento);

        Cliente clienteRegistered = clienteDao.insert(cliente);
        return new Response(Response.SUCCESS,
                "Cliente cadastrado com sucesso", clienteRegistered);
    }

    private boolean clienteExistsByEmail(String email) {
        Cliente cliente = clienteDao.getByEmail(email);
        return cliente != null;
    }

    private boolean clienteExistsByDocumento(String documento) {
        Cliente cliente = clienteDao.getByDocumento(documento);
        return cliente != null;
    }

    public Response update(int id, String nome, String documento, String email) {
        Cliente cliente = clienteDao.getById(id);
        if (cliente == null) {
            return new Response(Response.ERROR,
                    "Cliente não encontrado");
        }

        if (clienteExistsByEmail(email) && !cliente.getEmail().equals(email)) {
            return new Response(Response.ERROR,
                    "Já existe um cliente cadastrado com este e-mail");
        }

        if (clienteExistsByDocumento(documento) && !cliente.getDocumento().equals(documento)) {
            return new Response(Response.ERROR,
                    "Já existe um cliente cadastrado com este Documento");
        }

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setDocumento(documento);

        Cliente savedCliente = clienteDao.update(cliente);
        return new Response(Response.SUCCESS,
                "Cliente atualizado com sucesso", savedCliente);
    }

    public Response delete(int id) {
        Cliente cliente = clienteDao.getById(id);
        if (cliente == null) {
            return new Response(Response.ERROR,
                    "Cliente não encontrado");
        }

        clienteDao.delete(cliente);
        return new Response(Response.SUCCESS,
                "Cliente deletado com sucesso");
    }
}