package tests2;

public class Hailstone {

	/*@ public normal_behavior
	@ 	requires 0 < n;
	@ 	requires n % 2 != 0;
	@ 	ensures \result == (3*n+1)/2;
	@ also
	@	public normal_behavior
	@ 	requires 0 < n;
	@ 	requires n % 2 == 0;
	@ 	ensures \result == n/2;
	@ also
	@	public exceptional_behavior
	@ 	requires n <= 0;
	@ 	signals_only HailstoneException;
	@*/
	public static /*@ pure @*/ int h(int n) throws HailstoneException {
		int result = 0;
		if (0 < n && n % 2 != 0) {
			result = (3*n+1)/2;
		} else if (0 < n && n % 2 == 0) {
			result = n/2;
		} else if (n <= 0) {
			throw new HailstoneException();
		}
		return result;
	}
	
	/*@ public normal_behavior
	@ 	requires 0 < n;
	@ 	{|
	@ 		requires n % 2 != 0;
	@ 		ensures \result == (3*n+1)/2;
	@ 		also
	@ 		requires n % 2 == 0;
	@ 		ensures \result == n/2;
	@ 	|}
	@ also
	@ public exceptional_behavior
	@ 	requires n <= 0;
	@ 	signals_only HailstoneException;
	@*/
	public static /*@ pure @*/ int h2(int n) throws HailstoneException {
		int result = 0;
		if (0 < n && n % 2 != 0) {
			result = (3*n+1)/2;
		} else if (0 < n && n % 2 == 0) {
			result = n/2;
		} else if (n <= 0) {
			throw new HailstoneException();
		}
		return result;
	}
	
	public static void main (String[] args) {
		try {
			System.out.println(Hailstone.h2(4));
			System.out.println(Hailstone.h2(3));
			System.out.println(Hailstone.h2(-1));
		} catch (HailstoneException h) {
			h.printStackTrace();
		}
	}
}
