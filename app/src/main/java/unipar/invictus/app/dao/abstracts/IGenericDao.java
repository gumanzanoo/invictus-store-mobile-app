package unipar.invictus.app.dao.abstracts;

import java.util.ArrayList;

public interface IGenericDao<Object> {
    Object insert(Object obj);
    Object update(Object obj);
    long delete(Object obj);
    ArrayList<Object> getAll();
    Object getById(int id);
}