// OLD
// import java.io.*;
// import java.util.*;

// public class FileOperator {
//     File myFile;
//     Scanner fileReader;
//     public FileOperator (String f) throws IOException {
//         setFile(f);
//     }
//     public void setFile(String f) throws IOException {
//         myFile = new File(f);
//         fileReader = new Scanner(myFile);
//     }

//     public String readLines(){
//         return fileReader.nextLine();
//     }
// }

//USE THIS ONE
import java.io.*;
import java.net.URL;
import java.util.*;

public class FileOperator {
    File myFile;
    Scanner fileReader;
    public FileOperator (String f) throws Exception {
        setFile(f);
    }

    public FileOperator(String url, boolean isOnline) throws Exception{
        if (isOnline){
            setUrl(url);
        }
        else {
            setFile(url);
        }
    }

    public void setUrl(String fileName) throws IOException{
        URL url = new URL(fileName);
        fileReader = new Scanner(url.openStream());
    }

    public void setFile(String f) throws Exception {
        myFile = new File(f);
        fileReader = new Scanner(myFile);
    }

    public String readLines(){
        if (fileReader.hasNextLine()){
            return fileReader.nextLine();
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception{
        FileOperator online = new FileOperator("https://people.sc.fsu.edu/~jburkardt/data/csv/airtravel.csv", true);
        String line = online.readLines();
        while (line != null){
            System.out.println(line);
            line = online.readLines();
        }
    }
}