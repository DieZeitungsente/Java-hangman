import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import begudb.cls;
import begudb.system;

class index {
    public static <T> T choice(T[] arr) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(arr.length);
        return arr[randomIndex];
    }
    static void clear() throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    static void log(String msg){
        System.out.print(msg);
    }
    public static void main(String[] args) throws InterruptedException, IOException{
        String[] words = {    "ALGORITHM",    "BINARY",    "CACHE",    "CODE",    "COMPILER",    "CONDITIONAL",    "DEBUGGING",    "DECLARATION",    "ENCRYPTION",    "EXCEPTION",    "FUNCTION",    "HASH",    "INTEGER",    "INTERPRETER",    "ITERATION",    "KEYWORD",    "LOOP",    "METHOD",    "OBJECT",    "OPERATOR",    "PARAMETER",    "POINTER",    "RECURSION",    "REFERENCE",    "REGEX",    "SCRIPT",    "SORTING",    "STRING",    "SYNTAX",    "THREAD",    "TYPE",    "VARIABLE",    "VIRTUAL",    "ABSTRACT",    "BOOLEAN",    "BREAK",    "CLASS",    "CONSTANT",    "DATA",    "DYNAMIC",    "ENCAPSULATION",    "EVENT",    "FINALLY",    "GARBAGE",    "HANDLER",    "INHERITANCE",    "INTERFACE",    "LAMBDA",    "LIBRARY",    "MESSAGE",    "NAMESPACE",    "NULL",    "OVERRIDE",    "PRIVATE",    "PROTECTED",    "PUBLIC",    "QUEUE",    "RECORD",    "REENTRANT",    "RESOURCE",    "RETURN",    "STACK",    "STATIC",    "STRUCTURE",    "SWITCH",    "TEMPLATE",    "TRY",    "TUPLE",    "TYPE",    "UNION",    "VALUE",    "VECTOR",    "VOID",    "VOLATILE",    "WHILE",    "YIELD",    "ARRAY",    "BLOCK",    "BYTE",    "CHAR",    "CONTEXT",    "DELEGATE",    "DOUBLE",    "ENUM",    "FLOAT",    "GOTO",    "INLINE",    "LONG",    "POOL",    "SHORT",    "SINGLE",    "STREAM",    "SYNC",    "TASK",    "TRACE",    "TYPE",    "UNICODE",    "USHORT",    "UTF8",    "VOID"};
        String rdm = choice(words);
        String[] progress = new String[rdm.length()];
        String[] invalid = { "", "", "", "", "", "", "", "", "", ""};
        for (int x = 0;x < rdm.length();x++){
            progress[x] = "_";
        }
        Scanner sc = new Scanner(System.in);
        log("Press enter to start");
        sc.nextLine();
        String[] word = new String[progress.length];
        boolean lost = false;
        int hints = word.length / 3;
        hints = Math.round(hints);
        int most = hints;
        int failed = 0;
        while (Arrays.asList(progress).contains("_") && !(lost)) {
            clear();
            failed = 0;
            for(int x = 0;x < invalid.length;x++){
                if(!(invalid[x] == "")){
                    log(cls.red + invalid[x] + cls.reset);
                    failed++;
                }
            }
            if(failed == 9){
                system.ln(cls.red + " - " + (10 - failed) + " try left" + "\n" + cls.green + hints + " / " + most + " hints left" + cls.reset);
            } else{
                system.ln(cls.red + " - " + (10 - failed) + " tries left" + "\n" + cls.green + hints + " / " + most + " hints left" + cls.reset);
            }
            log("\n - \n");
            system.printArray(progress);
            system.ln(" - " + progress.length + " Characters");
            String inp = sc.nextLine();
            for(int y = 0;y < progress.length;y++){
                word[y] = rdm.substring(y, y+1);
            }
            if(inp.toUpperCase().equals(rdm)){
                for(int z = 0;z < progress.length;z++){
                    progress[z] = word[z];
                }
            }else{
                if(inp.toLowerCase().equals("hint")){  // hints
                    if(hints >= 1){
                        int HintIndex = 0;
                        hints--;
                        while(progress[HintIndex] != "_"){
                            HintIndex++;
                        }
                        for(int item = 0;item < word.length;item++){
                            if(word[item].equals(word[HintIndex])){
                                progress[item] = word[HintIndex];
                            }
                        }
                    }
                }else if(Arrays.asList(word).contains(inp.substring(0,1).toUpperCase())){  // Checking if the first letter is RIGHT
                    for(int x = 0;x < word.length;x++){
                        if(word[x].equals(inp.toUpperCase())){
                            progress[x] = word[x];
                        }
                    }
                }else if(!(Arrays.asList(invalid).contains(inp.substring(0,1).toUpperCase()))){  // Checking if the first letter is WRONG
                    String[] old = invalid;
                    for(int x = 0;x < invalid.length;x++){
                        if(invalid[x].equals("")){
                            invalid[x] = inp.substring(0,1).toUpperCase();
                            break;
                        }
                    }
                    if(old == invalid && !(Arrays.asList(invalid).contains(""))){
                        lost = true;
                    }
                }
            }
        }
        
        if(lost){
            clear();
            system.log(cls.red);
            system.printArray(invalid);
            system.ln(cls.red + " - " + "0 tries left" + "\n" + cls.green + hints + " / " + most + " hints left" + cls.reset);
            system.printArray(progress);
            log("\n\n\nYou lost! the word was " + rdm.toLowerCase() + "\n");
        }else{
            clear();
            log(cls.red);
            system.printArray(invalid);
            log(cls.reset);
            if(failed == 9){
                system.ln(cls.red + " - " + (10 - failed) + " try left" + "\n" + cls.green + hints + " / " + most + " hints left" + cls.reset);
            } else{
                system.ln(cls.red + " - " + (10 - failed) + " tries left" + "\n" + cls.green + hints + " / " + most + " hints left" + cls.reset);
            }
            log("\n - \n" + rdm + "\n");
            log("\n\n\nYou win!\n");
        }
        sc.close();
    }
}
