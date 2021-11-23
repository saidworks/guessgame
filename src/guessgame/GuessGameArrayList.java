package guessgame;

import java.util.*;

public class GuessGameArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> laCombinaison = new ArrayList<Integer>();
		ArrayList<Integer> uneCombinaison = new ArrayList<Integer>();
		Scanner reader = new Scanner(System.in);
		tirerCombinaison(uneCombinaison);
		
		for(int i=0; i < 4;i++) {
			System.out.println(uneCombinaison.get(i));
		}
		
		int coups = 0;
		String result = "";
		
		while (coups <10) {
		demanderCoup(laCombinaison,reader);
		//winner case 
		if(laCombinaison.get(0) == uneCombinaison.get(0) && laCombinaison.get(1) == uneCombinaison.get(1) && laCombinaison.get(2) == uneCombinaison.get(2) && laCombinaison.get(3) == uneCombinaison.get(3)) {
			System.out.println("Congratulations you won");
			result = "####";
		}
		//right position and number
		for(int i = 0; i < 4;i++) {
			if (laCombinaison.get(i) == uneCombinaison.get(i)) {
				result += "#";
			}
		}
		//right number but wrong position
		if(laCombinaison.get(0) == uneCombinaison.get(1) || laCombinaison.get(0) == uneCombinaison.get(2) || laCombinaison.get(0) == uneCombinaison.get(3)) {
			result += "0";
		}
		if(laCombinaison.get(1) == uneCombinaison.get(2) || laCombinaison.get(1) == uneCombinaison.get(3) || laCombinaison.get(1) == uneCombinaison.get(0)) {
			result += "0";
		}
		if(laCombinaison.get(2) == uneCombinaison.get(0) || laCombinaison.get(2) == uneCombinaison.get(1) || laCombinaison.get(2) == uneCombinaison.get(3)) {
			result += "0";
		}
		if(laCombinaison.get(3) == uneCombinaison.get(0) || laCombinaison.get(3) == uneCombinaison.get(1) || laCombinaison.get(3) == uneCombinaison.get(2)) {
			result += "0";
		}
		//print the result 
		System.out.println(result);
		
		laCombinaison.clear();
		result = "";
		coups++;
		}
		reader.close();
		//loser case 
		System.out.println("You lost try again");
		}
		
		static int hasard(int max) {
			return (1 + (int)(Math.random() * max));
			}
		
		static void tirerCombinaison(ArrayList<Integer> uneCombinaison) {
			for(int i=0; i < 4; i++) {
				uneCombinaison.add(hasard(6));
				
			}
		}
		
		static void demanderCoup(ArrayList<Integer> laCombinaison,Scanner reader) {
			for(int j=0; j <4;j++) {
					
					System.out.println("Entrer le nombre en position " + (j+1));
					int userInput = reader.nextInt();
					
					if((userInput>=1 ||userInput<=6) && (laCombinaison.contains(userInput))) {
						laCombinaison.add(userInput);
					}
					else {
						System.out.println("le chiffre doit être compris entre 1 et 6, veuillez resaisir un chiffre valide");
						break;
					}
				}

			}
		

}
