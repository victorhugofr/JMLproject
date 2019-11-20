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
	private static /*@ spec_public @*/ List<Contestacao> contestacoes;
	
	
	/*@ public normal_behavior
	  @ requires contestacao!=null;
	  @ ensures \result == (\exists int i; i<=0 && i<contestacoes.size();contestacoes[i].equals(contestacao)); 
	 */
	public /*@ pure @*/ boolean contains(Contestacao contestacao) {
		EntityTransaction transaction = entityManager.getTransaction();
		if(!transaction.isActive())
			transaction.begin();
		List<Contestacao> retorno = entityManager.createQuery("from Contestacao u where u.id='" + contestacao.getId() + "'")
				.getResultList();
		contestacoes=retorno;
		for (Contestacao u : retorno) {
			if (u.getId()==contestacao.getId()) {
				return true;
			}
		}
		return false;
		
	}
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
