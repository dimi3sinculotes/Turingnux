package practica2si;


import java.util.Scanner;


public class Practica2SI {

    
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String mode = "";
        String input = "";
        
        char[] map = new char[36];    
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
                System.out.println("\nSelect the key for Vigenere alg");
                String skey = scaner.nextLine();
                System.out.println("Type or Paste the coded text to try to decode");
                input = scaner.nextLine();
                vigenereAlg(skey, input, map);
                break;
                
            case "c":
            case "C":
                System.out.println("\nSelect the key for Transp alg");
                String ckey = scaner.nextLine();
                System.out.println("Type or Paste the coded text to try to decode");
                input = scaner.nextLine();
                transpAlg(ckey, input, map);
                break;
                
            default:
                System.out.println("MODE ERROR");
                break;
        }
    }
    public static char[] initMap(char[] map){
         
        map[0] = 'A';
        map[1] = 'B';
        map[2] = 'C';
        map[3] = 'D';
        map[4] = 'E';
        map[5] = 'F';
        map[6] = 'G';
        map[7] = 'H';
        map[8] = 'I';
        map[9] = 'J';
        map[10] = 'K';
        map[11] = 'L';
        map[12] = 'M';
        map[13] = 'N';
        map[14] = 'O';
        map[15] = 'P';
        map[16] = 'Q';
        map[17] = 'R';
        map[18] = 'S';
        map[19] = 'T';
        map[20] = 'U';
        map[21] = 'V';
        map[22] = 'W';
        map[23] = 'X';
        map[24] = 'Y';
        map[25] = 'Z';
        map[26] = '0';
        map[27] = '1';
        map[28] = '2';
        map[29] = '3';
        map[30] = '4';
        map[31] = '5';
        map[32] = '6';
        map[33] = '7';
        map[34] = '8';
        map[35] = '9';
        return map;
    }
    public static int getvalue(char[] map, char c){
        int toret = -1;
        int i = 0;
        while((toret == -1) && (i<=35)){
            if(map[i] == c){
                toret = i;
            }else{
                i++;
            }
        }
        return toret;
    }
    public static void cesarAlg(int key, String input, char[] map){
        int value;
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            value = getvalue(map, input.charAt(i));
            if(value >= 0){
                output = output + map[value - key];
            }else{
                output = output + input.charAt(i);
            }
        }
    
        System.out.println(output);
    }
    public static char getKeyChar(String key, int i){
        if(i>=key.length()){
            i = i % (key.length());
        }
        return key.charAt(i);
    }
    public static void vigenereAlg(String key, String input, char[] map){
        int value, j;
        String output = "";
        char decodedChar = ' ';
        j = 0;
        for (int i = 0; i < input.length(); i++) {
            value = getvalue(map, input.charAt(i));
            if(value >= 0){
                //coded char is input.charAt(i);
                //keyChar is getKeyChar(key, j);
                //module is map.length();
                if(((getvalue(map, input.charAt(i)) - getvalue(map, getKeyChar(key, j))) % input.length()) >= 0){
                    decodedChar = map[((getvalue(map, input.charAt(i)) - getvalue(map, getKeyChar(key, j))) % map.length)];
                }else{
                    decodedChar = map[((getvalue(map, input.charAt(i)) - getvalue(map, getKeyChar(key, j)) + map.length) % map.length)];
                }
                output = output + decodedChar; 
                j++;
            }else{
                output = output + input.charAt(i);
            }
        }
        System.out.println(output);
    }
    
    public static char[] sortedKey(String keyy, char[] map){
        String[] key = keyy.split("");
        String tmp = "";
        char[] toret = new char[keyy.length()];
        
        for(int i = 0; i < key.length - 1; i++){
            for(int j = 0; j < key.length - 1; j++){
                if((getvalue(map, key[j].charAt(0))) > (getvalue(map, key[j + 1].charAt(0)))){
                    tmp = key[j];
                    key[j] = key[j+1];
                    key[j+1] = tmp;
                }
            }
        }
        for(int i = 0; i < key.length ; i++){
            toret[i] = key[i].charAt(0);
        }
        return toret;
    }
    public static int whereChar(char c, String s){
        int toret = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c){
                toret = i;
            }
        }
        return toret;
    }
    public static void transpAlg(String key, String input, char[] map){
        int j = 0;
        int k = 0;
        int l = 0;
        String output = "";
        int columnLength = (input.length() / key.length());
        
        char[][] columns = new char[key.length()][columnLength];
        
        while(j < key.length()){
            l = 0;
            while(k < columnLength){
                columns[j][l] = input.charAt(k);
                System.out.print(columns[j][l]);
                k++;
                l++;
            }
            System.out.println("");
            j++;
        }
        char[] sortedKey = sortedKey(key, map);
        for (int i = 0; i < sortedKey.length; i++) {
            int pos = whereChar(sortedKey[i], key);
            for (int m = 0; m < columnLength; m++) {
                output = output + columns[pos][m];
            }
        }
        System.out.println(output);
    }
}
