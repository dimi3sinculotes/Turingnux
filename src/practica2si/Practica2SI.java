package practica2si;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Practica2SI {

    
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String mode = "";
        String input = "";
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();        
        map = initMap(map);
        
        System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
        System.out.println("VVVV WELLCOME TO TURINGNUX VVVV");
        System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
        System.out.println("\n" + "Select mode:");
        System.out.println("\nA: Cesar");
        System.out.println("B: Vigenere");
        System.out.println("C: Transposition");
        while((!mode.equals("a")) && (!mode.equals("A")) && (!mode.equals("b")) && 
                (!mode.equals("B")) && (!mode.equals("c")) && (!mode.equals("C"))){
            
            System.out.println("\nSelect valid mode:");
            mode = scaner.nextLine();
        }
        System.out.println("\nmode " + mode + " selected");
        switch(mode){
            case "a":
            case "A":
                System.out.println("\nSelect the key for Cesar alg");
                int key = Integer.parseInt(scaner.nextLine());
                System.out.println("Type or Paste the coded text to try to decode");
                input = scaner.nextLine();
                cesarAlg(key, input, map);
                break;
                
            case "b":
            case "B":
                break;
                
            case "c":
            case "C":
                break;
                
            default:
                System.out.println("MODE ERROR");
                break;
        }
    }
    public static Map<Character, Integer> initMap(Map<Character, Integer> map){
         
        
        return map;
    }
    public static void cesarAlg(int key, String input,Map<Character, Integer> map){
        
    }
}
