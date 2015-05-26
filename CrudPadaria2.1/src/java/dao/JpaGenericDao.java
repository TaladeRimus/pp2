/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import javax.persistence.EntityManager;


public abstract class JpaGenericDao<T> {
    
    private Class<T> entityClass;
    
    public JpaGenericDao( Class<T> entityClass ){
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void inserir(T entity){
        getEntityManager().persist(entity);
    }
    
    public void editar(T entity){
        getEntityManager().merge(entity);
    }
    
    public void remover(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    public T buscar(Object id){
        return getEntityManager().find(entityClass, id);
    }
    
    public List<T> listar(){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
