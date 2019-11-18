package tests2;

public class SortedIntAnderson {

	private /*@ spec_public @*/ int[] vector;
	private /*@ spec_public @*/ int size = 0;
	
	/*@ public invariant size >= 0;
	  @ public invariant (\forall int i, j;
	  @                    0 <= i && i < j && j < vector.length;
	  @                    vector[i] <= vector[j]); @*/
	
	
	/*@ requires 0 < n;
	  @ assignable vector;
	  @ ensures vector.length == n; @*/
	public SortedIntAnderson(int n){
		vector = new int[n];
	}
	
	
	/*@ requires true;
	  @ assignable vector[x], vector[y];
	  @ ensures vector[y] == \old(vector[x]) && vector[x] == \old(vector[y]); @*/
	private /*@ helper @*/ void swap (int x, int y)
	{
	    int aux = vector[x];
	    vector[x] = vector[y];
	    vector[y] = aux;
	}

	
	/*@ requires size >= 2;
	  @ assignable vector;
	  @ ensures_redundantly (\forall int i, j;
	  @                    0 <= i && i < j && j < vector.length;
	  @                    vector[i] <= vector[j]);
	  @ ensures_redundantly size == \old(size); 	@*/
	private /*@ helper @*/ void bubbleSort ()
	{
	    int i, j;
	    boolean switched;
	    j = size-1;
	    do
	    {
	        switched = false;
	        for (i=0; i<j; i++) 
	        {
	            if (vector[i+1] < vector[i])
	            {
	                swap(i+1, i);
	                switched = true; 
	            }
	        }
	        j--; 
	    } while (switched);
	}
	
	
	/*@ requires size > 0; @*/
	private /*@ spec_public pure @*/ boolean isHere(int x){
		boolean found = false;
		for (int i = 0; i<size; i++){
			if (vector[i] == x)
				found = true;
		}
		return found;
	}
	
	
	/*@ requires size < vector.length-1;
	  @ assignable vector, size;
	  @ ensures size == \old(size+1);
	  @ ensures isHere(x) == true;
	  @ ensures_redundantly (\forall int i, j;
	  @                    0 <= i && i < j && j < vector.length;
	  @                    vector[i] <= vector[j]); @*/
	public void add(int x){   
		vector[size] = x;
		size++;
		if(size >= 2){
			bubbleSort();
		}
	}

	public void print(){
		for (int i = 0; i < size; i++)
			System.out.println(vector[i]);
	}
	
	
	public static void main(String[] args) {
		SortedIntAnderson sort = new SortedIntAnderson(15);
		sort.add(3);
		System.out.println("start");
		sort.print();
		System.out.println("end\n");
		sort.add(7);
		System.out.println("start");
		sort.print();
		System.out.println("end\n");
		sort.add(10);
		System.out.println("start");
		sort.print();
		System.out.println("end\n");
		sort.add(5);
		System.out.println("start");
		sort.print();
		System.out.println("end\n");
		
	}
}