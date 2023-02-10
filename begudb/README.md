# Java database
This is a open-source project for creating databases in java using only txt files, it's free to use without credits!
## Setup
- run `git clone https://github.com/Begulas-projects/begudb` in the terminal
- import `java.io.IOException`
- import `begudb.db` for database, `begudb.system` for system commands
- make main throw IOException: `public static void main(String[] args) throws IOException{`
- and you're done!

### What these functions got
- find system: `db.find(ITEM);`
  - this returns 404_404_404 when the item is not found
- read database:
```java
String[][] database = db.inject();
system.printArrayln(database[INDEX]);
```
  - you can also read the database by finding the item:
  ```java
  String[][] database = db.inject();
  system.printArrayln(array[db.find(ITEM HERE)]);
  ```
- clear console (windows only): `system.clear();`
- `System.out.print` in short: `system.log(MSG);`
- randomizer: `system.choice(ARRAY WITH STRING ITEMS);`
- print arrays:
  - new line after printing array: `system.printArrayln(ARRAY);`
  - stay on line: `system.printArray(ARRAY);`
- write to the database: `db.write(2DIMENSIONAL ARRAY);`
  - this clears the already existing database!
- ADD to the database: `db.add(ARRAY);`
- automatically setup the database: `db.create();`
# IMPORTANT!
## **The database can only have up to 100 items, you can change that in the Config.java file**
More soon!
