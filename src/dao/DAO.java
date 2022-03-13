
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ChefClickPU"); //Lê o xml e cria a conexão
    EntityManager em = emf.createEntityManager();   //Mapeia banco relacional para objeto
    EntityTransaction etx = em.getTransaction();    //Objeto de transações com o banco
    
    public void salvar(Object o){
        etx.begin(); //Abre conexão
        em.merge(o); //Não salva na hora, mas o persist sim
        etx.commit(); //Faz commit e fecha o banco
    }
    
    public void remover(Object o){
        etx.begin();
        em.remove(o);
        etx.commit();
    }
    
    public List listarUsuario(){
        Query q = em.createQuery("select u.nomecompletofunc, u.nomeusuario from Usuario as u");
        return q.getResultList();
    }
    
        public List listarProdutos(){
        Query q = em.createQuery("select p from Produtos p");
        return q.getResultList();
    }
    
    
 
}
