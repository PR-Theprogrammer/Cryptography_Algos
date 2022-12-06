//menu driven program for Rail Fence Cryptography
import java.util.Scanner;

public class RailFence {

    //encryption method
    static String encrypt(int key, String pt) {
        String cipher = "";
        char[][] ptc = new char[key][pt.length()];  //matrix

        // filling the rail matrix
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < pt.length(); j++) {
                ptc[i][j] = '\n';
            }
        }

        
        boolean dir = false;// to find the direction
        int row = 0, col = 0;

        for (int i = 0; i < pt.length(); i++) {
        // check the direction of flow, reverse when places filled
            if (row == 0 || row == key - 1) {
                dir = !dir;
            }

            // fill thealphabet at their correct position
            ptc[row][col++] = pt.charAt(i);

            // find the next row using direction flag
            if (dir) {
                row++;

            } else {
                row--;
                        

            }
        }
    //now we can construct the cipher using the rail matrix

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < pt.length(); j++) {
                if (ptc[i][j] != '\n') {
                    cipher += ptc[i][j];
                }
            }
        }

        return cipher.toUpperCase();
    }

    //decryption method
    static String decrypt(int key, String cipher) {
        cipher = cipher.toLowerCase();
        String pt = "";
        char[][] ptc = new char[key][cipher.length()];

        // filling the rail matrix
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipher.length(); j++) {
                ptc[i][j] = '\n';
            }
        }

        // to find the direction
        boolean dir = false;
        int row = 0, col = 0;

        for (int i = 0; i < cipher.length(); i++) {
        // check the direction of flow
            // reverse the direction if we've just
            // filled the top or bottom rail
            if (row == 0 || row == key - 1) {
                dir = !dir;
            }

            // fill the corresponding * at correct place
            ptc[row][col++] = '*';

            // find the next row using direction flag
            if (dir) {
                row++;

            } else {
                row--;

            }
        }
        //now we can construct the cipher using the rail matrix
        int index = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipher.length(); j++) {
                if (ptc[i][j] == '*' && index < cipher.length()) {
                    ptc[i][j] = cipher.charAt(index++);
                }
            }
        }

        row = 0;
        col = 0;
        for (int i = 0; i < cipher.length(); i++) {
            // check the direction of flow
            if (row == 0) {
                dir = true;
            }
            if (row == key - 1) {
                dir = false;
            }

            // place the marker
            if (ptc[row][col] != '*') {
                pt += ptc[row][col++];
            }

            // find the next row using direction flag
            if (dir) {
                row++;

            } else {
                row--;

            }
        }
        return pt;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose one of the option");
            System.out.println("1)Encryption ");
            System.out.println("2)Decryption ");
            System.out.println("3)Exit ");
            int input = sc.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("Enter Plain Text: ");
                    sc.nextLine();
                    String plain_text = sc.nextLine();
                    System.out.println("Enter Key : ");
                    int key = sc.nextInt();

                    String cipher;
                    cipher = encrypt(key, plain_text);
                    System.out.println("Encrypted form: " + cipher + "\n");
                    System.out.println("\n---------------------------------------\n");
                    break;
                }
                case 2:
                    System.out.println("Enter Cipher Text: ");
                    sc.nextLine();
                    String cipher_text = sc.nextLine();
                    System.out.println("Enter Key : ");
                    int key = sc.nextInt();

                    String pt;
                    pt = decrypt(key, cipher_text);
                    System.out.println("Decrypted form: " + pt + "\n");
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
