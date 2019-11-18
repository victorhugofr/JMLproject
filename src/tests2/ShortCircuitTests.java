package tests2;

public class ShortCircuitTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer x = null;
		if (false && x.toString()=="") {
			
		} else if (!(true || x.toString()=="")){
			
		} else {
			System.out.println("Hello World");
		}

	}

}
