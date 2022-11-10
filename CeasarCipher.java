
//program for Ceasar Cipher using Ascii values where plaintext are in lower case and cipher in uppercase
//also, blank spaces are not encrypted

import java.util.*;
public class CeasarCipher {

	//encryption function
	static String encrypt(String pt,int key) {
		String cipher="";
		//convert it into uppercase
		char[] pt_arr=pt.toUpperCase().toCharArray();
		char indi;
		for(int i=0;i<pt_arr.length;i++) {
			if((int)pt_arr[i]==32) {
				indi=pt_arr[i];
			}
			else
				indi= (char) ((int)pt_arr[i]+key);//for all cases

			cipher+=indi;
		}
		return cipher;
	}

	//decryption function
	static String  decrypt(String cipher,int key) {
		String pt="";
		char[] cipher_arr=cipher.toLowerCase().toCharArray();
		char indi;
		for(int i=0;i<cipher_arr.length;i++) {
			if((int)cipher_arr[i]==32) {
				indi=cipher_arr[i];
			}
			else
				indi= (char) ((int)cipher_arr[i]-key);
			pt+=indi;
		}

		return pt;
	}
	public static void main(String[] args) {
		
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
