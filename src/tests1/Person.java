package tests1;

public class Person extends GenderedAnimal {
	protected /*@ spec_public @*/ boolean ageDiscount = false; //@ in age;
	
	/*@ also
	@   requires (0 <= a && a <= 150) || a < 0;
	@   assignable age, ageDiscount;
	@   ensures 65 <= age ==> ageDiscount;   @*/
	public void setAge(final int a) {
		super.setAge(a);
		if (65 <= a) { ageDiscount = true; }
	}

	//@ requires g.equals("female") || g.equals("male");
	//@ assignable gender;
	//@ ensures gender.equals(g);
	public Person(final String g) { 
		super(g); 
	}
}