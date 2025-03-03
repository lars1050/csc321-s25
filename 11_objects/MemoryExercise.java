public class MemoryExercise {
	public static void main(String[] args) {
	
		String[] alpha = new String[5];
		alpha[0] = "a";
		alpha[2] = "b";
		alpha[1] = "c";
		
		String[] copyA = null;
		String[] copyB = null;
		String[] copyC = null;
		String[] copyD = null;
		
		// 1. WRITE VALUE of alpha, copyA through copyD
		
		String[] copyMain = alpha;
		funcA(alpha);
		// 2. WRITE VALUE of alpha, copyMain, and copyA through copyD
		
		copyB = funcB(alpha);
		// 3. WRITE VALUE of alpha and copyA through copyD
				
		copyC = funcC(alpha);
		// 4. WRITE VALUE of alpha and copyA through copyD
				
		funcD(alpha);
		// 5. WRITE VALUE of alpha and copyA through copyD
		
		funcE(alpha,copyD);
		// 6. WRITE VALUE of alpha and copyA through copyD
	}
	
	public static void funcA(String[] A) {
		String[] copyA = A;
	}
	
	public static String[] funcB(String[] A) {
		String[] copyB = A;
		return copyB;
	}
	
	public static String[] funcC(String[] A) {
		String[] copyC = new String[A.length];
		for (int i=0; i<A.length; i++) {
			copyC[i] = A[i];
		}
		return copyC;
	}
	
	public static void funcD(String[] A) {
		A = new String[A.length];
		A[3] = "z";
	}
	
	public static void funcE(String[] A, String[] copyD) {
		for (int i=0; i<A.length; i++) {
			copyD[i] = A[i];
		}
	}
}