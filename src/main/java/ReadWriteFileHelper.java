import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFileHelper {

    public static void writeAnsersToOutFile(ArrayList<String> answers, String fullFileOutPutFilePath) {

        try {
            //using this to simply overwrite the file each time.
            BufferedWriter writer = new BufferedWriter(new FileWriter(fullFileOutPutFilePath));
            for(int counter = 0; counter < answers.size(); counter++){
                writer.write( "\n" + answers.get(counter));
            }
            writer.close();
        } catch (IOException e) {
            //since this is lightweight going to keep with default
            throw new RuntimeException(e);
        }

    }

    public static List<String> createListFromInputFile (String stringFullFilepath){

        List<String> listFromInput = new ArrayList<String>();
        //set file path
        Path fullFilepath = Paths.get(stringFullFilepath);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fullFilepath.toString()));
            // reading each line
            String eachLine = reader.readLine();

            while((eachLine = reader.readLine()) != null){
                listFromInput.add(eachLine);
            }
            reader.close();
        }catch  (IOException e){
            e.printStackTrace();
        }

        return listFromInput;

    }

    public static List<String> readFile (String filepath) throws IOException{

        try {
            // list that holds strings of a file
            List<String> listOfStrings = new ArrayList<String>();

            // load data
            BufferedReader buffer = new BufferedReader(
                    new FileReader(filepath));

            // reading each line
            String line = buffer.readLine();

            // normal loop for checking for end of file
            while (line != null) {
                listOfStrings.add(line);
                line = buffer.readLine();
            }

            // remember to close :)
            buffer.close();
            return listOfStrings;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
