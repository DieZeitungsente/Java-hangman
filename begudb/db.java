package begudb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class db {
    public static String[][] inject() throws IOException{
        String[][] arr = new String[Config.databaseItemAmount()][Config.databaseItemAmount()];
        FileReader myReader = new FileReader("database.txt");
        BufferedReader myBuffer = new BufferedReader(myReader);
        try {
            String line = myBuffer.readLine();
            String[] elements = line.replace("{", "").replace("}", "").split(",");
            for (int i = 0; i < elements.length; i++) {
                if(i < arr.length){
                    arr[i] = elements[i].trim().split("thisisaplaceholderdonotremovemeremovingthiswillresultoabugandremovesomelettersinthedatabase");
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
        String[][] array = inject();
        int ret = 0;
        boolean returned = false;
        for(int x = 0;x < array.length;x ++){
            if(array[x][0] == null){
                continue;
            }else if(array[x][0].equals(newItem)){
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
    public static void write(String[][] arr) {
        try {
            FileWriter myWriter = new FileWriter("database.txt", false);
            BufferedWriter myBuffer = new BufferedWriter(myWriter);
            myBuffer.write("{ "); // beginning, --> {...
            for (int i = 0; i < arr.length; i++) {
                myBuffer.write("{ \"");
                for (int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] != null && !arr[i][j].isEmpty()){
                        myBuffer.write(arr[i][j]);
                    } else {
                        myBuffer.write(" ");
                    }
                    if(j != arr[i].length -1)
                        myBuffer.write("\", \"");
                }
                if(i != arr[i].length - 1){
                    myBuffer.write("\" }, ");
                }
            }
            myBuffer.write("\" } }");
            myBuffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void add(String[] arr) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader myReader = new FileReader("database.txt");
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

        FileWriter myWriter = new FileWriter("database.txt", false);
        BufferedWriter myBuffer = new BufferedWriter(myWriter);
        myBuffer.write(sb.toString());
        myBuffer.close();
    }
    public static void create() throws IOException {
        File file = new File("database.txt");
        file.createNewFile();
        String[][] array = { { "ITEM", "ITEM"}, { "ITEM", "ITEM"} };
        write(array);
    }
}
