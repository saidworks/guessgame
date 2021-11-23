package guessgame;

import java.util.*;

public class GuessGameList {
	public static void main(String[] args) {
	int[] laCombinaison = new int[4];
	int[] uneCombinaison = new int[4];
	
	tirerCombinaison(uneCombinaison);
	
	for(int i=0; i < uneCombinaison.length;i++) {
		System.out.println(uneCombinaison[i]);
	}
	
	int coups = 0;
	String result = "";
	
	while (coups <10) {
	demanderCoup(laCombinaison);
	//winner case 
	if(laCombinaison[0] == uneCombinaison[0] && laCombinaison[1] == uneCombinaison[1] && laCombinaison[2] == uneCombinaison[2] && laCombinaison[3] == uneCombinaison[3]) {
		System.out.println("Congratulations you won");
		result = "####";
	}
	//right position and number
	for(int i = 0; i < laCombinaison.length;i++) {
		if (laCombinaison[i] == uneCombinaison[i]) {
			result += "#";
		}
	}
	//right number but wrong position
	if(laCombinaison[0] == uneCombinaison[1] || laCombinaison[0] == uneCombinaison[2] || laCombinaison[0] == uneCombinaison[3]) {
		result += "0";
	}
	if(laCombinaison[1] == uneCombinaison[2] || laCombinaison[1] == uneCombinaison[3] || laCombinaison[1] == uneCombinaison[0]) {
		result += "0";
	}
	if(laCombinaison[2] == uneCombinaison[0] || laCombinaison[2] == uneCombinaison[1] || laCombinaison[2] == uneCombinaison[3]) {
		result += "0";
	}
	if(laCombinaison[3] == uneCombinaison[0] || laCombinaison[3] == uneCombinaison[1] || laCombinaison[3] == uneCombinaison[2]) {
		result += "0";
	}
	//print the result 
	System.out.println(result);
	
	laCombinaison = null;
	laCombinaison = new int[4];
	result = "";
	coups++;
	}

	}
	
	static int hasard(int max) {
		return (1 + (int)(Math.random() * max));
		}
	
	static void tirerCombinaison(int[] uneCombinaison) {
		for(int i=0; i < uneCombinaison.length; i++) {
			uneCombinaison[i] = hasard(6);
			
		}
	}
	
	static void demanderCoup(int[] laCombinaison) {
		for(int j=0; j <laCombinaison.length;j++) {
				Scanner reader = new Scanner(System.in);
				System.out.println("Entrer le nombre en position " + (j+1));
				int userInput = reader.nextInt();
				
				if((userInput>=1 ||userInput<=6) && (userInput != laCombinaison[0] && userInput != laCombinaison[1] && userInput != laCombinaison[2] && userInput != laCombinaison[3])) {
					laCombinaison[j] = userInput;
				}
				else {
					System.out.println("le chiffre doit être compris entre 1 et 6, veuillez resaisir un chiffre valide");
					break;
				}
				
			}
		}
	

}
