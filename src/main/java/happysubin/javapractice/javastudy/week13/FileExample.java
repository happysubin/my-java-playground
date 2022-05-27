package happysubin.javapractice.javastudy.week13;

import java.io.*;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ansubin/Desktop/hello.txt");
        File resultFile = new File("/Users/ansubin/Desktop/result.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));

        String str;
        while ((str = br.readLine()) != null){
           bw.write(str + "\n");
        }

        br.close();
        bw.close();
    }
}
