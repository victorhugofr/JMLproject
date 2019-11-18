package tests1;

public class GenderedAnimal{
	
	protected /*@ spec_public @*/ int a; //@in age; 
	//@ protected represents age <- a;

	protected boolean gen; //@ in gender;

	/*@ requires g.equals("female")
	@ 	|| g.equals("male");
	@ assignable gender;
	@ ensures gender.equals(g); @*/
	public GenderedAnimal(final String g) { 
		gen = g.equals("female"); 
		
	}
	
	/*@ protected represents
	@ 	gender <- (gen ? "female" : "male");
	@*/
	public /*@ pure @*/ boolean isFemale() {
		return gen;
	}
	
	public void setAge(int x) {
		if(x >= 0 && x <= 150) {
			this.a = x;
		}
	}
	
	public static void main(String[] args) {
		GenderedAnimal animal = new GenderedAnimal("female");
		System.out.println(animal.isFemale());
		animal.setAge(-1);
		System.out.println(animal.a);
		animal.setAge(151);
		System.out.println(animal.a);
		animal.setAge(24);
		System.out.println(animal.a);
	}
	
	
}
