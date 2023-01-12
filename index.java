import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

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
        String[] invalid = new String[10];
        for (int x = 0;x < rdm.length();x++){
            progress[x] = "_";
        }
        Scanner sc = new Scanner(System.in);
        log("Press enter to start");
        sc.nextLine();
        String[] word = new String[progress.length];
        while (Arrays.asList(progress).contains("_")) {
            clear();
            for(int item = 0;item < progress.length;item++){
                log(progress[item]);
            }
            log("\n" + rdm);
            log("\n");
            String inp = sc.nextLine();
            for(int y = 0;y < progress.length;y++){
                word[y] = rdm.substring(y, y+1);
            }
            if(inp.toUpperCase().equals(rdm)){
                for(int z = 0;z < progress.length;z++){
                    progress[z] = word[z];
                }
            }else{
                if(Arrays.asList(word).contains(inp.substring(0,1))){
                    for(int x = 0;x < word.length;x++){
                        if(word[x].equals(inp.toUpperCase())){
                            progress[x] = word[x];
                        }
                    }
                }
            }
            if(progress == word){
                log("\nDONE!\n");
            }
        }

        sc.close();
    }
}
