import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    
		// Remember this ...
		
		ArrayList<Integer> backwards = new ArrayList<>();
		for (int i=9; i>=0; i--) {
			backwards.add(i);
		}
		for (Integer n : backwards) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		int[] forwards = new int[10];
		for (int i=0; i<10; i++) {
			forwards[i] = i;
		}
		for (int i=0; i<10; i++) {
			System.out.print(forwards[i] + " ");
		}
		System.out.println();
		
	} // end main()
} // end class Main
