package Principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//Variables:
		char [] alfabetoMay = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; //Definimos nuestro alfabeto mayusculas
		char [] alfabetoMin = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; //Definimos nuestro alfabeto minusculas
		String textoCifrado="", textoEnClaro="";
		int numPosicion=0;
		boolean  pruebaEncontrado = false;
		//Recogemos el texto cifrado
		System.out.println("Introduzca el mensaje cifrado, para obtener texto en claro:");
		do {
			textoCifrado=in.nextLine();
			if(textoCifrado.equals("")) {
				System.out.println("Error, introduzca el texto de nuevo.");
			}
		}while(textoCifrado.equals(""));
		//Imprimimos el mensaje original:
		System.out.println("Mensaje CIFRADO:\n"+textoCifrado+"\n");
		//Calculamos el mensaje en claro a partir de los parametros recibidos:
		for (int n = 0; n < alfabetoMin.length; n++) {
			for (int i = 0; i < textoCifrado.length(); i++) {
				pruebaEncontrado=false;
				for (int j = 0;  j < alfabetoMay.length && !pruebaEncontrado; j++) {
					if(textoCifrado.charAt(i)==alfabetoMay[j]) {
						pruebaEncontrado=true;
						numPosicion=j-n;
						if(numPosicion<0) {
							numPosicion+=alfabetoMay.length;
						}
						textoEnClaro+=Character.toString((char)alfabetoMay[numPosicion]);
					}else if(textoCifrado.charAt(i)==alfabetoMin[j]) {
						pruebaEncontrado=true;
						numPosicion=j-n;
						if(numPosicion<0) {
							numPosicion+=alfabetoMin.length;
						}
						textoEnClaro+=Character.toString((char)alfabetoMin[numPosicion]);
					}
				}
				if(!pruebaEncontrado) {
					textoEnClaro+=Character.toString((char)textoCifrado.charAt(i));
				}
			}
			//Imprimimos el mensaje en claro:
			System.out.println("Nº de desplazamiento = "+n);
			System.out.println(textoEnClaro+"\n");
			textoEnClaro="";
		}
		in.close();
	}

}
