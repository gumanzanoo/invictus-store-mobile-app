package unipar.invictus.app.dao.abstracts;

import java.util.ArrayList;
import java.util.List;

import unipar.invictus.app.entity.Cliente;

public interface GenericDao<Object> {
    Object insert(Object obj);
    Object update(Object obj);
    long delete(Object obj);
    ArrayList<Object> getAll();
    Object getById(int id);
}