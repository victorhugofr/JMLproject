package tests1;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.repositorios.ContestacaoRepositorio;
import br.com.sigcar.services.ZonaService;

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
	@*/
	public void older() {
		if (age < fate - 1) {
			age++;
		} else {
			age++;
			throw new RuntimeException();
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
		Contestacao contestacao2 = new Contestacao();
		contestacaoRep.salvar(contestacao);
		contestacaoRep.salvar(contestacao);
		contestacaoRep.remover(contestacao2);
	}

}