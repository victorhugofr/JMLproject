package br.com.sigcar.repositorios;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import br.com.sigcar.dominio.Servico;
import br.com.sigcar.dominio.Usuario;
import br.com.sigcar.util.HibernateUtil;

@Stateless
public class ServicoRepositorio {

	@PersistenceContext
	private static EntityManager entityManager = HibernateUtil.getEntityManager();
	public static List<Servico> servicos;
	
	@SuppressWarnings("unchecked")
	public  Servico getServico(String nomeEntidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		if(!transaction.isActive())
			transaction.begin();
		List<Servico> retorno = entityManager.createQuery("from Servico u where u.nomeEntidade='" + nomeEntidade + "'")
				.getResultList();

		for (Servico u : retorno) {
			if (u.getNomeEntidade().equals(nomeEntidade)) {
				return u;
			}
		}
		return null;
	}
	
	public void salvar(Servico entidade) {
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
	public List<Servico> listarServicos(){
		List<Servico> retorno = entityManager.createQuery("from Servico").getResultList();
		servicos=retorno;
		return servicos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> listarServicosUsuario(){
		Usuario usuarioLogado = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");
		List<Servico> retorno = entityManager.createQuery("from Servico u where u.usuario.id='" + usuarioLogado.getId() + "'").getResultList();
		servicos=retorno;
		return servicos;
	}
	
	public void remover(Servico servicoRemovido) {
		Object id = HibernateUtil.getPrimaryKey(servicoRemovido);
		
		EntityTransaction transaction = entityManager.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		
		entityManager.createNativeQuery("delete from servico where id ="+id).executeUpdate();
		transaction.commit();
	}
}
