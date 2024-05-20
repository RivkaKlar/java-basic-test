package test.rivky.veig;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    private static List<String> convertLineToRow(String line){
        String[] l=line.split(",");
        return new ArrayList<String>(Arrays.asList(l));
   }
   public static List<List<String>> readFileRows(String path){
        List<List<String>> all=new ArrayList<>();
       try(DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))){
            String line =input.readLine();
           while(line != null){
               all.add(convertLineToRow(line));
               line = input.readLine();
           }

       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return all;
   }

}
