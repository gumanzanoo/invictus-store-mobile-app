package unipar.invictus.app.controller;

import android.content.Context;

import unipar.invictus.app.dao.ClienteDao;
import unipar.invictus.app.helpers.Response;
import unipar.invictus.app.entity.Cliente;
public class ClienteController {
    public ClienteDao clienteDao;

    public ClienteController(Context context) {
        clienteDao = new ClienteDao(context);
    }

    public Response create(String nome, String documento, String email) {

        if (clienteExistsByEmail(email)) {
            return Response.response(Response.ERROR,
                    "Já existe um cliente cadastrado com este e-mail");
        }

        if (clienteExistsByDocumento(documento)) {
            return Response.response(Response.ERROR,
                    "Já existe um cliente cadastrado com este Documento");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setDocumento(documento);

        Cliente clienteRegistered = clienteDao.insert(cliente);
        return Response.response(Response.SUCCESS,
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
}
