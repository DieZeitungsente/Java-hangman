package begudb;
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class system {
    public static <T> T choice(T[] arr) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(arr.length);
        return arr[randomIndex];
    }
    public static void clear() throws InterruptedException, IOException{
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } finally {
        }
    }
    public static void log(String msg){
        System.out.print(msg);
    }
    public static void printArray(String[] array){
        for(int x = 0;x < array.length;x++){
            log(array[x]);
        }
    }
    public static void printArrayln(String[] array){
        for(int x = 0;x < array.length; x++){
            log(array[x]);
        }
        log("\n");
    }
    public static void ln(String msg){
        log(msg + "\n");
    }
    public static String input(){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        sc.close();
        return inp;
    }
}
