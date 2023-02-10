package begudb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class mail {
    public static String[] inject() throws IOException{
        String[] arr = new String[Config.databaseItemAmount()];
        FileReader myReader = new FileReader("mails.txt");
        BufferedReader myBuffer = new BufferedReader(myReader);
        try {
            String line = myBuffer.readLine();
            String[] elements = line.replace("{", "").replace("}", "").split(",");
            for (int i = 0; i < elements.length; i++) {
                if(i < arr.length){
                    arr[i] = elements[i].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        myBuffer.close();
        return arr;
    }
    public static int find(String item) throws IOException {
        String newItem = "\"" + item + "\"";
        String[] array = inject();
        int ret = 0;
        boolean returned = false;
        for(int x = 0;x < array.length;x ++){
            if(array[x] == null){
                continue;
            }else if(array[x].equals(newItem)){
                ret = x;
                returned = true;
                break;
            }
        }
        if(returned){
            return ret;
        } else {
            return 404_404_404;
        }
    }
    public static String write(String[] arr) {
        try {
            FileWriter myWriter = new FileWriter("mails.txt", false);
            BufferedWriter myBuffer = new BufferedWriter(myWriter);
            myBuffer.write("{ \""); // beginning, --> {...
            for(int item = 0;item < arr.length;item++){
                if(arr[item] != null){
                    myBuffer.write(arr[item].replaceAll("\"",""));
                    if(item != arr.length - 1){
                        myBuffer.write("\", \"");
                    }
                }
            }
            myBuffer.write("\" }");
            myBuffer.close();
            FileReader myReader = new FileReader("mails.txt");
            BufferedReader breader = new BufferedReader(myReader);
            String newDb = breader.readLine();
            breader.close();
            return newDb;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed";
        }
    }
    public static void add(String[] arr) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader myReader = new FileReader("mails.txt");
        BufferedReader breader = new BufferedReader(myReader);
        String line;
        while ((line = breader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        breader.close();
        myReader.close();
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(", { ");
        for(int item = 0;item < arr.length;item++){
            if(item != arr.length - 1){
                sb.append("\"" + arr[item] + "\"" + ", ");
            } else {
                sb.append("\"" + arr[item] + "\"" + "} }");
            }
        }

        FileWriter myWriter = new FileWriter("mails.txt", false);
        BufferedWriter myBuffer = new BufferedWriter(myWriter);
        myBuffer.write(sb.toString());
        myBuffer.close();
    }
    public static void create() throws IOException {
        File file = new File("mails.txt");
        file.createNewFile();
        String[] array = { "ITEM", "ITEM", "ITEM", "ITEM" };
        write(array);
    }
    public static void remove(String value) throws IOException {
        String[] arr = inject(); // reads the database by creating a 2 dimensional array with 100 columns and lines and filling the right values with the indexes
        int index = find(value); // finds the index of the value by looping trough every item
        int len = 0;
        for (int k = 0; k < arr.length; k++) {
            if(k != index && k != index + 1){
                if(arr[k] != null){
                    len++;
                }
            }
        }
        String[] newArr = new String[len];
        int j = 0;
        for (int k = 0; k < arr.length; k++) {
            if(k != index && k != index + 1){
                if(arr[k] != null){
                    newArr[j] = arr[k];
                    j++;
                }
            }
        }
        write(newArr);
    }
    public static void debug_remove(String value) throws IOException {
        String[] arr = inject(); // reads the database by creating a 2 dimensional array with 100 columns and lines and filling the right values with the indexes
        int index = find(value); // finds the index of the value by looping trough every item
        System.out.println("\033[32mValue found with index " + index + ": " + arr[index] + "\033[0m");
        int len = 0;
        int skipped = 0, app = 0;
        for (int k = 0; k < arr.length; k++) {
            if(k != index && k != index + 1){
                if(arr[k] != null){
                    len++;
                    System.out.println("\033[32mValue approved: " + arr[k]);
                    app++;
                }
            } else {
                System.out.println("\033[31mValue skipped with index " + k + ": " + arr[k] + "\033[0m");
                skipped++;
            }
        }
        int $skipped = 0, $used = 0;
        String[] $usethis = new String[len];
        for (int k = 0; k < len; k++) {
            if(!(arr[k].equals("\"" + value + "\"")) && arr[k] != arr[index + 1]){
                if(arr[k] != null){
                    $usethis[k] = arr[k];
                    System.out.println("\033[34mValue " + arr[k] + " in $usethis_" + k + " used: " + arr[k] + " is not equal to " + "\"" + value + "\"" + " or " + arr[index + 1] +"\033[0m");
                    $used++;
                } else {
                    System.out.println("\033[31mValue " + arr[k] + " denied in $usethis_" + k + "\033[0m");
                }
            } else {
                System.out.println("\033[31mValue skipped using method 2 with index " + k + ": " + arr[k] + "\033[0m");
                $skipped++;
            }
        }
        write($usethis); // writes to the database by getting the values and formatting everything as a 2 dimensional array
        FileReader myReader = new FileReader("mails.txt");
        BufferedReader breader = new BufferedReader(myReader);
        String newDb = breader.readLine();
        breader.close();
        System.out.println("\n\nResults:\n\033[31mValues skipped:\033[0m " + skipped + "\n\033[31mValues skipped using method 2: \033[0m" + $skipped + "\n\033[34mValues in $usethis used: \033[0m" + $used + "\n\033[32mValues approved: \033[0m" + app + "\n\nDatabase:\n" + newDb);
    }
}