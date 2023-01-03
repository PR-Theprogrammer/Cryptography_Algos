
import java.util.Scanner;


public class ExtendedEuclids {
    static int[] euclid_gcd(int a,int b){
        int[] op=new int[3];
        int s=0,s1=1,s2=0;
        int r1=a;
        int r2=b;
        int q=0;//quotient q=0
        int r=0;//remainder r
        int t=0,t1=0,t2=1;
        int gcd=0;
        
        //method
        while(r2!=0){
            // table calculation
            q=r1/r2;
            r=r1%r2;
            s=s1- (q*s2);
            t=t1-(q*t2);
            //after calculating interchanging values
            r1=r2;
            r2=r;
            s1=s2;
            s2=s;
            t1=t2;
            t2=t;
        }
        
        //setting the values of gcd,s and t
        gcd=r1;
        s=s1;
        t=t1;
        //returning calculated values
                op[0]=gcd;
                op[1]=s;
                op[2]=t;
                return op;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("*******EXTENDED EUCLIDEAN ALGORITHM*******");
        System.out.println("Enter a: ");
        int a=sc.nextInt();
        System.out.println("Enter b: ");
        int b=sc.nextInt();
        //method call
        int[] gcdop=euclid_gcd(a,b);
        System.out.println("\n----------------------------------------------\n");
        System.out.println("The gcd("+a+","+b+"):  "+ gcdop[0]);
        System.out.println("s: "+ gcdop[1]);
        System.out.println("t: "+ gcdop[2]);
        
    }
}
