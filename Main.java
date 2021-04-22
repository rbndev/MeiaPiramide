import java.util.ArrayList;

public class Main {
		
	public static void main(String[] args) {
		String str = "82 70 30 50 60 80 55 100 150 20 55 14 300 221 10";
		int countSpace = 0, size = 0, somamenor = 0, qtNum = 0;
		int[] space = new int[100];

		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> menores = new ArrayList<Integer>();
			
		lista.add(Integer.parseInt(str.substring(0, str.indexOf(" ")))); // Add first number
		
		// Loop for space number's
		for(int i=0; i < str.length(); i++ ){
		  if( str.charAt(i) == ' ' ) {
			  space[countSpace] = i;
			  countSpace++;
		  }
		}
	
		//Loop for number's
		for(int i = 0; i < space.length; i++) {
			if(space[i] != 0) {
				int index = space[i] + 1;
				if(i == countSpace - 1) {
					int num = Integer.parseInt(str.substring(index, str.length()));
					lista.add(num); // Last Number
				}else {
					int num = Integer.parseInt(str.substring(index, space[i+1]));
					lista.add(num); // All number's
				}
			}
			
		}
		System.out.println("Quantidade: " + (countSpace + 1));
		System.out.println("String: " + str);
		System.out.println("Lista: " + lista + "\n");
		System.out.println("-----------------");
		System.out.println("-- PIRAMIDE");
		
		// Loop for pyramid
		while(size < lista.size()) {
			int menor = 0;
			
			System.out.print("[");
			
			for(int i = 0; i <= qtNum; i++) {
				if(size < lista.size()) { // Validation continue pyramid
					if(i == qtNum) { // Validation for last number
						if(size == 0) { // First number
							menor = lista.get(size);
							System.out.print(lista.get(size)); 
						}else {// Last number
							System.out.print(lista.get(size));
							if(lista.get(size) < menor) menor = lista.get(size);
						}
					}else {
						if(i == 0) {
							menor = lista.get(size);
						}else {
							if(lista.get(size) < menor) menor = lista.get(size);
						}
						System.out.print(lista.get(size)+ ", ");
					}					
					size++;
				}
			}
			System.out.println("]");
			menores.add(menor);
			somamenor += menor;
			qtNum++;
		}
		
		System.out.println("-----------------");
		System.out.println("Os menores valores são: " + menores);
		System.out.print("A soma dos menores valores é " + somamenor);
	}
}