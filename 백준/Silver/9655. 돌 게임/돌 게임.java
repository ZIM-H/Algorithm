import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        if(sc.nextInt() % 2 == 0) System.out.println("CY");

        else System.out.println("SK");
    }
}