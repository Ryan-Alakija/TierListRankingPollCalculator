import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
public class Calculations {
    private static int[] results;
    private static String[] tierLetter;
    private static int S;
    private static int A;
    private static int B;
    private static int C;
    private static int D;
    private static int F;
    private static double total;
    private static double numerator;
    private static int denominator;
    private static double percentage;
    private static double placement;
    private static String result;

    public static void main(String[] arg) {
        Scanner inp = new Scanner(System.in);
        int in = 0;
        while (in < 1) {
            calculate();
            boolean valid = false;
            System.out.println("Would you like to calculate another one? Yes or No");
            while (!valid) {
                String ans = inp.nextLine();
                if (ans.equals("No") || ans.equals("no")) {
                    in++;
                    valid = true;
                }
                else if (ans.equals("Yes") || ans.equals("yes"))
                    valid = true;
                else
                    System.out.println("Invalid answer, please type Yes or No");
            }
        }
    }

    public static void calculate() {
        placement = 6.00;
        total = 0.00;
        Scanner sc = new Scanner(System.in);
        results = new int[6];
        //results = new int[]{8, 10, 20, 40, 48, 57};
        tierLetter = new String[]{"S", "A", "B", "C", "D", "F"};
        double halfwayMark = 0.0;
        for (int i = 0; i < tierLetter.length; i++) {
            System.out.println("How many " +tierLetter[i]+ " tier votes are there?");
            results[i] = sc.nextInt();
            total += results[i];
        }

        for (int i = 0; i < results.length; i++) {
            if (halfwayMark < total/2) {
                halfwayMark += results[i];
                denominator = results[i];
                placement -= 1.00;
                result = tierLetter[i];
            }
        }
        //System.out.println(result+ " tier");
        //System.out.printf("%.0f votes total", total);
        //System.out.println();
        numerator = halfwayMark - total/2;
//        System.out.println(numerator);
//        System.out.println(denominator);
        percentage = 100 * numerator / denominator;
        //System.out.println(percentage+ "%");
        //System.out.println(numerator+ "/" +denominator);
        if (placement >= 3.00) {
            placement += 0.01;
        }
        if (placement == 2.00)
            placement += (numerator / denominator);
        else
            placement += (numerator / denominator) * 0.99;
        //System.out.println(placement);
        System.out.print(result+ " tier (");
        System.out.printf("%.0f votes total", total);
        System.out.print("; " +numerator+ "/" +denominator+ " ≈ " +percentage+ "%)");
        System.out.println();
        System.out.println(placement);
    }
}
