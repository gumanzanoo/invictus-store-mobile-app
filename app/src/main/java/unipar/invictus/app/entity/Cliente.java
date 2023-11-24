package unipar.invictus.app.entity;

import androidx.annotation.NonNull;

public class Cliente {
    private int id;

    private String nome;

    private String email;

    private String documento;

    public Cliente() {
    }

    public Cliente(int id, String nome, String email, String documento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @NonNull
    @Override
    public String toString() {
        return email + " - " + nome;
    }
}

