package org.taba.java.jdbc.repository;

import java.util.List;

public interface Repositorio <T> {
    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void modificar(T t);
    void eliminar(Long id);
}
