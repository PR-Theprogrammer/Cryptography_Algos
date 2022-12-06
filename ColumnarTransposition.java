//menu driven java program for Columnar Transposition
import java.util.Scanner;
import java.lang.Math;

public class ColumnarTransposition {
     //encryption method
    static void encrypt(String key, String pt) {
        String cipher = "";
        
         int row,col;
   
      
    /* calculate column of the matrix*/
     col = key.length(); 
      
    /* calculate Maximum row of the matrix*/
     double x=pt.length()/col;
    row =(int) Math.ceil(x); 
      
    if (pt.length() % col != 0)
        row += 1;
  
    char[][] matrix=new char[row][col];//creating matrix
    //filling the matrix rowwise with characters else X
    int count=0;
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(count!=pt.length()){
                 matrix[i][j]=pt.charAt(count);
            count++;
            }
            else{
                matrix[i][j]='X'; //filled with X
            }
           
        }
    }
    //print the matrix
    System.out.println("Matrix: ");
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            System.out.print(matrix[i][j]+ " ");
           
        }
        System.out.print("\n");
    }
 
  
  
    
        
        

        //return cipher.toUpperCase();
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
                    
                    String key = sc.next();

                    String cipher;
                   // cipher = 
                    encrypt(key, plain_text);
                   // System.out.println("Encrypted form: " + cipher + "\n");
                    //System.out.println("\n---------------------------------------\n");
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
