package br.com.sigcar.repositorios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;


import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.util.HibernateUtil;
@Stateless
public class ContestacaoRepositorio {

	@PersistenceContext
	private static EntityManager entityManager = HibernateUtil.getEntityManager();
	public static List<Contestacao> contestacoes;
	
	@SuppressWarnings("unchecked")
	public  Contestacao getContestacao(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		if(!transaction.isActive())
			transaction.begin();
		List<Contestacao> retorno = entityManager.createQuery("from Contestacao u where u.id='" + id + "'")
				.getResultList();

		for (Contestacao u : retorno) {
			if (u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	
	public void salvar(Contestacao entidade) {
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
	public List<Contestacao> listarContestacoes(){
		List<Contestacao> retorno = entityManager.createQuery("from Contestacao").getResultList();
		contestacoes=retorno;
		return contestacoes;
	}
}
