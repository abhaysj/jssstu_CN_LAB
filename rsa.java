import java.util.*;
import java.math.*;
import java.util.Random;
/*

    Consider two prime numbers p and q.
    Compute n = p*q
    Compute ϕ(n) = (p – 1) * (q – 1)
    Choose e such gcd(e , ϕ(n) ) = 1
    Calculate d such e*d mod ϕ(n) = 1
    Public Key {e,n} Private Key {d,n}
    Cipher text C = Pe mod n where P = plaintext
    For Decryption D = Cd mod n where D will refund the plaintext.


*/
//message in 2 digits and prime numbers in 3 digits 
class rsa {
    public static void main(String args[]){
        int p=0, q=0, n, z, d=0, e, i,count=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the message to be encrypted :");
        int msg = sc.nextInt();
        double c;
        BigInteger msgback;
        //System.out.println("enter the value of p");
        //p = sc.nextInt();
        //System.out.println("enter the value of q");
        //q = sc.nextInt();
        Random random = new Random();
        System.out.println("Two Random Prime Numbers:");
        while (count < 2) {
            int randomNumber = random.nextInt(1000); // You can adjust the range as needed
            if (isPrime(randomNumber)) {
                if(count==0){
                    p=randomNumber;
                    System.out.println("p="+p);
                }
                else{
                    q=randomNumber;
                    System.out.println("q="+q);
                }
                count++;
            } 
        }
        n = p*q;
        z = (p-1)*(q-1);
        System.out.println("the value of z="+z);
        for(e=2;e<z;e++)
        {
            if(gcd(z,e)==1){
            break;
            }
        }
        System.out.println("the value of e="+e);
        
        for(i=1;i<=100000;i++)
        {
            int x = e*i;
        
            if(x%z==1)
            {
                d=i;
                break;
            }
            else
                continue;
        }
        
        System.out.println("the value of d="+d);
        c = (Math.pow(msg,e))%n;
        System.out.println("the encrypted message is:"+c);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        //msgback = (Math.pow(C,d))%n;
        System.out.println("the decrypted message is:"+msgback);
        sc.close();
    }
    
    
    
    static int gcd(int z, int e)
    {
        int rem;
        while(e>0)
        {
            rem=z%e;
            z=e;
            e=rem;
        }
        return z;
    }
    
    public static boolean isPrime(int number) {
        
        
        for (int i = 2; i * i <= number; i += 1) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}