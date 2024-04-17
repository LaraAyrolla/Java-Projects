import entity.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the coefficients (a, b, c) for the quadratic equation:");

            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();

            System.out.println("\n");
            QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
            quadraticEquation.verifyQuadraticEquationAndCalculateRealRoots();
            System.out.println("\n");
        } while (true);
    }
}
