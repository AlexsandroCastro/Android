package com.example.java.dao;

import android.content.Context;

import com.example.java.bean.Usuario;

import mobi.stos.podataka_lib.repository.AbstractRepository;

public class UsuarioDao extends AbstractRepository<Usuario> {

    public UsuarioDao(Context context) {
        super(context, Usuario.class);
    }
}
