package ru.vsu.cs.sviridov_d_v;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ROOT);

        double x = readNumber("Enter number x: ");
        double range = readNumber("Enter n member of sequence: ");
        double epsilon = readNumber("Enter the value epsilon: ");

        double sumMembersOfSequence = getSumMembersOfSequence(x, range);
        double sumMembersOfSequenceGreaterThanEpsilon = getSumMembersOfSequenceGreaterThanEpsilon(x,
                range, epsilon);
        double sumMembersOfSequenceGreaterThanEpsilonDividedBy10 = getSumMembersOfSequenceGreaterThanEpsilon(x,
                range, epsilon / 10);
        double sumMembersOfSequenceWithMath = getSumMembersOfSequenceWithMath(x);

        printAnswer(sumMembersOfSequence, sumMembersOfSequenceGreaterThanEpsilon,
                sumMembersOfSequenceGreaterThanEpsilonDividedBy10, sumMembersOfSequenceWithMath);
    }

    static double readNumber(String text) {
        System.out.print(text);
        Scanner scn = new Scanner(System.in);
        return scn.nextDouble();
    }

    static double pow(double number, double degree) {
        double value = 1;
        for (int i = 1; i <= degree; i++) {
            value *= number;
        }
        return value;
    }

    static double module(double x) {
        if (x >= 0) {
            return x;
        } else {
            return -x;
        }
    }

    static double getFactorial(double N) {
        double value = 1;
        for (int i = 1; i <= N; i++) {
            value = value * i;
        }
        return value;
    }

    static double getNMemberOfSequence(double x, double N) {
        double numerator = pow(x, (2 * N - 2));
        double denominator = getFactorial(2 * N - 2);
        return numerator / denominator;
    }

    static double getSumMembersOfSequence(double x, double range) {
        double sum = 1;
        for (int i = 1; i <= range; i++) {
            sum += getNMemberOfSequence(x, i);
        }
        return sum;
    }

    static double getSumMembersOfSequenceGreaterThanEpsilon(double x, double range, double epsilon) {
        double sum = 1;
        for (int i = 1; i <= range; i++) {
            double NMemberOfSequence = getNMemberOfSequence(x, i);
            if (module(NMemberOfSequence) > epsilon) {
                sum += getNMemberOfSequence(x, i);
            }
        }
        return sum;
    }

    static double getSumMembersOfSequenceWithMath(double x) {
        return Math.cosh(x);
    }

    static void printAnswer(double sumMembersOfSequence, double sumMembersOfSequenceGreaterThanEpsilon,
                              double sumMembersOfSequenceGreaterThanEpsilonDividedBy10,
                              double sumMembersOfSequenceWithMath) {
        System.out.println("1) Sum of N terms of a given form: " + sumMembersOfSequence);
        System.out.println("2) Sum of terms that greater than e: " + sumMembersOfSequenceGreaterThanEpsilon);
        System.out.println("3) Sum of terms that greater than e/10: " + sumMembersOfSequenceGreaterThanEpsilonDividedBy10);
        System.out.println("4) Function value with Math methods: " + sumMembersOfSequenceWithMath);
    }
}













