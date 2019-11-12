package br.com.sigcar.repositorios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.util.HibernateUtil;

@Stateless
public class DocumentoRepositorio {

	@PersistenceContext
	private static EntityManager entityManager = HibernateUtil.getEntityManager();
	public static List<Documento> documentos;
	
	@SuppressWarnings("unchecked")
	public  Documento getDocumento(String nome) {
		EntityTransaction transaction = entityManager.getTransaction();
		if(!transaction.isActive())
			transaction.begin();
		List<Documento> retorno = entityManager.createQuery("from Documento u where u.nome='" + nome + "'")
				.getResultList();

		for (Documento u : retorno) {
			if (u.getNome().equals(nome)) {
				return u;
			}
		}
		return null;
	}
	
	public void salvar(Documento entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		if(entidade.getId()==0)
			entityManager.persist(entidade);
		else 
			entityManager.merge(entidade);
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Documento> listarDocumentos(){
		List<Documento> retorno = entityManager.createQuery("from Documento").getResultList();
		documentos=retorno;
		return documentos;
	}
	
	public void remover(Documento servicoRemovido) {
		Object id = HibernateUtil.getPrimaryKey(servicoRemovido);
		
		EntityTransaction transaction = entityManager.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		
		entityManager.createNativeQuery("delete from documento where id ="+id).executeUpdate();
		transaction.commit();
	}
}
