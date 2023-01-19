import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * File Utilities for reading and writing
 *
 * @author Sahil Gupta
 * @since August 25, 2022
 */
 public class FileUtils{
  /**
   *  Opens a file to read using the Scanner class.
   *  @ param fileName    name of file to open
   *  @return             the Scanner object to the file
   */
   public static Scanner openToRead(String fileName){
           Scanner input = null;
           try{
                   input = new Scanner(new File(fileName));

           }
           catch(java.io.FileNotFoundException e){
                   System.err.println("Error: Cannot open "+fileName+" for reading. ");
                   System.exit(-1);
           }
           return input;
   }

   /**
    * * opens a file to write using the PrintWriter class.
    * @param fileName      name of the file to open
    * @return               the PrintWriter object to the File
    */
    public static PrintWriter openToWrite(String fileName) {
                PrintWriter output = null;
                try{
                        output = new PrintWriter(new File(fileName));
                }
                catch (java.io.FileNotFoundException e)
                {
                        System.err.println("Error: Cannot open "+fileName+" for writing.");
                        System.exit(-1);
        }
    return output;
 }
}
