import java.io.*;
import java.util.*;

public class FileOperator {
    File myFile;
    Scanner fileReader;
    public FileOperator (String f) throws IOException {
        setFile(f);
    }
    public void setFile(String f) throws IOException {
        myFile = new File(f);
        fileReader = new Scanner(myFile);
    }

    public String readLines(){
        return fileReader.nextLine();
    }
}

// import java.io.*;
// import java.util.*;

// public class FileOperator {
//     File myFile;
//     Scanner fileReader;
//     public FileOperator (String f) throws IOException {
//         setFile(f);
//     }
//     public void FileOperator(String url, boolean isOnline) throws IOException{
//         if (isOnline){
//             setUrl(url);
//         }
//     }
//     public void setFile(String f) throws IOException {
//         myFile = new File(f);
//         fileReader = new Scanner(myFile);
//     }

//     public String readLines(){
//         return fileReader.nextLine();
//     }
// }