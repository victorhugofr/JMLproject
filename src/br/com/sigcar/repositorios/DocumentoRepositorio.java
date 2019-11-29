package br.com.sigcar.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.sigcar.dominio.Documento;

public class DocumentoRepositorio {

	private /*@ spec_public @*/  List<Documento> documentos;
	
	
	public DocumentoRepositorio() {
		documentos = new ArrayList<Documento>();
	}
	
	/*@ public normal_behavior
	  @ requires documento!=null;
	  @ ensures \result == (\exists int i; i<=0 && i<documentos.size();documentos[i].equals(documento)); 
	 */
	public /*@ pure @*/ boolean contains(Documento documento) {
		for (Documento u : documentos) {
			if (u.equals(documento)) {
				return true;
			}
		}
		return false;
	}
	
	public  Documento getDocumento(String nome) {
		for (Documento u : documentos) {
			if (u.getNome().equals(nome)) {
				return u;
			}
		}
		return null;
	}
	
	/*@ public normal_behavior
	  @ requires  entidade!=null && !this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures contains(entidade);
	  @ ensures (\forall Documento i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures documentos.size() == \old(documentos.size())+1;
	  */
	public boolean salvar(Documento entidade) {
		if(entidade == null || this.contains(entidade))
			return false;
		documentos.add(entidade);
		return true;
	}
	
	public List<Documento> listarDocumentos(){
		return documentos;
	}
	

	/*@ public normal_behavior
	  @ requires  entidade!=null && this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures !contains(entidade);
	  @ ensures (\forall Documento i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures documentos.size() == \old(documentos.size())-1;
	  */
	public boolean remover(Documento entidade) {
		documentos.remove(entidade);
		return true;
	}
}
