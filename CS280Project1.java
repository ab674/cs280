// Abhinav Bassi
// 31327046
// CS 280 102
// Project 1

import java.util.LinkedList;
import java.util.Scanner;

public class CS280Project1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter start configuration: ");
        String start = scan.next();
        System.out.print("Enter end configuration: ");
        String end = scan.next();
        towerofhanoi(start, end);
    }
    
     public static void towerofhanoi(String start, String end) {
        int n = start.length();
        if (n != 0) {
            if (start.charAt(0) == end.charAt(0)) {
                towerofhanoi(start.substring(1), end.substring(1));
            }
            else {
                String temp = generatetemp(othertower(start.charAt(0), end.charAt(0)), n-1);
                towerofhanoi(start.substring(1), temp);                
                System.out.println("Move disk from " + start.charAt(0) + " to " + end.charAt(0));
                towerofhanoi(temp, end.substring(1));
            }
        }
    }
     
    private static String generatetemp(char original, int numrepeat) {
        String tempstring = "";
        for (int i = 0; i < numrepeat; i++)
            tempstring += original;
        return tempstring;
    }
       
    private static char othertower(char first, char second) {
        LinkedList<Character> towers = new LinkedList<>();
        towers.add(first);
        towers.add(second);
        if (!towers.contains('A')) {
            return 'A';
        }
        else if (!towers.contains('B')) {
            return 'B';
        }
        else {
            return 'C';
        }
    }
}
