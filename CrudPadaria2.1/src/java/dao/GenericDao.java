/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

public interface GenericDao<T> {
    
    public void inserir(T entity);
    
    public void editar(T entity);
    
    public void remover(T entity);
    
    public T buscar(Object id);
    
    public List<T> listar();
    
}
