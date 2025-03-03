class ArrayDemo {

	public static void main(String[] args) {
	
		String[] petNamesArray = new String[5];
		PetNamesList petNamesList = new PetNamesList();
		PetList pets = new PetList();
		
		// 1. Add "jojo" the snake to each of the 3 structures above.
		
		// Print all 3 structures. 
		for (String s: petNamesArray) { System.out.print(s+" "); }
		System.out.println();
		System.out.println(petNamesList);
		System.out.println(pets);
		
		// 2. Create a new PetNamesList object. 
		//    Create a structure to pass to the constructor.
		//    In the structure put jojo, fluffy, and lemon.
		
		// 3. Create another new PetNamesList object using the same #2 argument.
		
		// IMPLEMENT: Print the new PetNamesList objects and the argument.
		
		// 4. Create a new PetList object.
		//    Create a structure to pass to the constructor.
		//    In the structure put jojo (snake), fluffy (turtle), lemon (fish).
		
		// IMPLEMENT: Print the new PetList and the argument.
		
		// 5. Add 4th pet bubbles (bird) to the instances from 2 and 4 
		//     using the SETTERS.
		
		// IMPLEMENT: Print the 2 PetNamesLists and the PetList. 
		// Also print the arguments passed to these constructors.
		
		// 6. Add pet spot (dog) to structures passed as argument in #2 above.
		
		// IMPLEMENT: Print the 2 PetNamesLists and the argument.
		
		// 7. Fix the code so that the structure passed into PetNamesList is distinct from the object being referenced with the member variable _pets_.
	}
	
	// ___________________________ PetNamesList __________
	public static class PetNamesList {
		int count = 0;
		private String[] pets = new String[5];
		
		public PetNamesList() {
		}
		
		public PetNamesList(String[] p) {
			pets = p;
		}
		
		public String toString() {
			String returnString = "";
			for (String p : pets) { returnString += p + " "; }
			return returnString;
		}
		
		public void set(int index, String p) {
			pets[index] = p;
		}
		public String get(int index) {
			return pets[index];
		}
	}
	
	// ___________________________ Pet __________
	public static class Pet {
		private String name;
		private String animal;
		
		public Pet(String n, String a) {
			name = n;
			animal = a;
		}
		public String toString() {return "("+name+" "+animal+")";}
		
		public void name(String n) { name = n; }
		public void animal(String a) { animal = a; }
	}
	
	// ___________________________ PetList __________
	public static class PetList {
	
		private Pet[] pets = new Pet[5];
		
		public PetList() {}
		
		public PetList(Pet[] pets) {
			this.pets = pets;
		}
		
		public String toString() {
			String returnString = "";
			for (Pet p: pets) { returnString += p + " "; }
			return returnString;
		}
		
		public void set(int idx, Pet p) {
			pets[idx] = p;
		}
		public Pet get(int idx) {
			return pets[idx];
		}
	}
}