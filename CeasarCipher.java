
//program for Ceasar Cipher using Ascii values where plaintext are in lower case and cipher in uppercase
//also, blank spaces are not encrypted

import java.util.*;
//program for Ceasar Cipher where plaintext are in lower case and cipher in uppercase
public class CeasarCipher {
	static String letters="abcdefghijklmnopqrstuvwxyz";
	//encryption function
	static String encrypt(String pt,int key) {

		String cipher="";
		for (int i = 0; i < pt.length(); i++) {
			int charPosition = letters.indexOf(pt.charAt(i));

			int keyVal = (charPosition+key ) % 26;
			if((int)pt.charAt(i)!=32) {
				cipher += letters.charAt(keyVal);
			}
			else {

				cipher += pt.charAt(i);//when white space occurs
			}

		}
		return cipher.toUpperCase();
	}

	//decryption function
	static String  decrypt(String cipher,int key) {
		String pt="";
		cipher=cipher.toLowerCase();
		for (int i = 0; i < cipher.length(); i++) {
			int charPosition = letters.indexOf(cipher.charAt(i));
			int keyVal = (charPosition-key) % 26;

			if(keyVal<0) {
				keyVal=26+keyVal;
			}

			if((int)cipher.charAt(i)!=32) {
				pt += letters.charAt(keyVal);
			}else {

				pt += cipher.charAt(i);//when white space occurs
			}

		}

		return pt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Plain Text: ");
		String plain_text=sc.nextLine();
		System.out.println("Enter Key: ");
		int key=sc.nextInt();
		String cipher;
		cipher=encrypt(plain_text,key);
		System.out.println("Encrypted form: "+ cipher);

		System.out.println("Decrypted form: "+ decrypt(cipher,key));
	}

}

