//package br.com.geradorprova.infra;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;
//import javax.persistence.TypedQuery;
//
//import org.springframework.orm.jpa.JpaTransactionManager;
//
//public class DAO <E> {
//	
//	@PersistenceUnit
//	private static EntityManagerFactory emf;
//	@PersistenceContext
//	private EntityManager em;
//	private Class<E> classe;
//	
//	
//	static {
//		try {
//			emf = Persistence.createEntityManagerFactory("");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	public DAO() {
//		this(null);
//	}
//	
//	public DAO(Class<E> classe) {
//		this.classe = classe;
//		em = emf.createEntityManager();
//	}
//	
//	public DAO<E> abrirT(){
//		em.getTransaction().begin();
//		return this;
//	}
//	
//	public DAO<E> fecharT(){
//		em.getTransaction().commit();
//		
//		return this;
//	}
//	
//	public DAO<E> incluirT(E entidade){
//		em.persist(entidade);
//		
//		return this;
//	}
//	
//	public DAO<E> incluirAtomico(E entidade){
//		
//		return this.abrirT().incluirT(entidade).fecharT();
//	}
//	
//	public List<E> obterTodos(int limit, int offset){
//		if(classe == null) {
//			throw new UnsupportedOperationException("Classe nula.");
//		}
//		
//		String jpql = "select e from " + classe.getName() + " e";
//		TypedQuery<E> query = em.createQuery(jpql, classe);
//		query.setMaxResults(limit);
//		query.setFirstResult(offset);
//		return query.getResultList();
//		
//	}
//	
//}
