package tests1;

public abstract class Staff extends Person {
	/*@ requires p instanceof Nurse; @*/
	public boolean isHead(final Staff p) {
		if (p instanceof Doctor) {
			Doctor doc = (Doctor) p;
			return doc.getTitle().startsWith("Head");
		} else {
			Nurse nrs = (Nurse) p;
			return nrs.isChief();
		}
	}
	
	public Staff(String gender) {
		super(gender);
	}
	
	public static void main(String[] args) {
		Doctor d = new Doctor("male");
		
		System.out.println(d.isHead(d));
	}
	
}
