//Menu driven program for Multiplicative Cipher
import java.util.Scanner;

public class MultiplicativeCipher {
	static int key=0;
	static int kInverse=modInverse(key,26);
	//encryption method
	static String encrypt(int key,String pt) {
		String cipher="";

		for (int i = 0; i < pt.length(); i++) {
			int charPosition =(int) pt.charAt(i) -97;
			//-----------formula
			int keyVal = (charPosition * key ) % 26;
			//--------------------------------------
			keyVal=keyVal+97;

			if((int)pt.charAt(i)!=32) {
				cipher += (char)(keyVal);
			}
			else {

				cipher += pt.charAt(i);//when white space occurs
			}

		}
		
		return cipher.toUpperCase();
	}


	//decryption method
	static String decrypt(int key,String cipher) {
		String pt="";
		cipher=cipher.toLowerCase();
		int kInverse=modInverse(key,26); 
		System.out.println("Key: "+key);
		System.out.println("k inverse: "+ kInverse+"\n");
		for (int i = 0; i < cipher.length(); i++) {
			int charPosition = (int)cipher.charAt(i)-97 ;



			//---decryption formula
			int keyVal = (charPosition* kInverse ) % 26;
			//------------------------------

			keyVal+=97;

			if(keyVal<97) {
				keyVal=26+keyVal;
			}

			if((int)cipher.charAt(i)!=32) {
				pt += (char)keyVal;
			}else {

				pt += cipher.charAt(i);//when white space occurs
			}

		}
		
		return pt;
	}

	//multiplicative inverse function
	static int modInverse(int A, int M)
	{

		for (int X = 1; X < M; X++)
			if (((A % M) * (X % M)) % M == 1)
				return X;
		return 1;
	}

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Choose one of the option");
			System.out.println("1)Encryption ");
			System.out.println("2)Decryption ");
			System.out.println("3)Exit ");
			int input=sc.nextInt();
			switch(input) {
			case 1:{
				System.out.println("Enter Plain Text: ");
				sc.nextLine();
				String plain_text=sc.nextLine();
				System.out.println("Enter Key: ");
				int key=sc.nextInt();
				String cipher;
				cipher=encrypt(key,plain_text);
				System.out.println("Encrypted form: "+ cipher+"\n");
				System.out.println("\n---------------------------------------\n");
				break;
			}
			case 2:
				System.out.println("Enter Cipher Text: ");
				sc.nextLine();
				String cipher_text=sc.nextLine();
				System.out.println("Enter Key: ");
				int key=sc.nextInt();
				String pt;
				pt=decrypt(key,cipher_text);
				System.out.println("Decrypted form: "+pt+"\n");
				System.out.println("\n---------------------------------------\n");
				break;

			case 3:
				System.exit(0);
			default:
				System.out.println("Please choose a valid option");
				System.out.println("\n---------------------------------------\n");
			}




		}
	}
}
