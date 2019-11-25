package br.com.sigcar.execucao;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.repositorios.ContestacaoRepositorio;
import br.com.sigcar.services.ZonaService;
import br.com.sigcar.util.HibernateUtil;

public class MainFile {

	private /*@ spec_public @*/ int age;
	private /*@ spec_public @*/ int fate;
	
	//@ public invariant 0 <= age && age <= fate;
	
	//@	requires 0 <= a;
	//@ requires a < f;
	//@ ensures age == a;
	//@ ensures fate == f;
	public MainFile (int a, int f) {
		this.age = a;
		this.fate = f;
	}
	
	/*@ public normal_behavior
	@ 	requires age < fate - 1;
	@ 	assignable age;
	@ 	ensures age == \old(age+1);
	@ also
	@ 	public exceptional_behavior
	@ 	requires age == fate - 1;
	@ 	assignable age;
	@ 	signals_only DeathException;
	@ 	signals (DeathException e)
	@ 				age == fate;
	@*/
	public void older() throws DeathException {
		if (age < fate - 1) {
			age++;
		} else {
			age++;
			throw new DeathException();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZonaService zona = new ZonaService();
		zona.buscarCep("59014560");
		ContestacaoRepositorio contestacaoRep = new ContestacaoRepositorio();
		Contestacao contestacao = new Contestacao();
		contestacao.setTexto("oi");
		contestacaoRep.salvar(contestacao);
		
//		MainFile a = new MainFile(1, 2);
//		System.out.println("A");
//		try {
//			a.older();
//			System.out.println("B");
//			a.older();
//			System.out.println("C");
//		} catch (DeathException d) {
//			d.printStackTrace();
//		}
	}

}