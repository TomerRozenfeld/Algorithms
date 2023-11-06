import java.util.Scanner;

public class NumDecompo{
    public static void main(String [] argumant){
        int base, exponent;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base number : ");
        base = sc.nextInt();
        System.out.print("Enter exponent number : ");
        exponent = sc.nextInt();

        int result = 1;
        for(int i=1;i<=exponent;i++){
            result = result * base;
        }
        System.out.println("The Result is : " + result);
    }
}