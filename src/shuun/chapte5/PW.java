package shuun.chapte5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PW {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\softthink\\Desktop\\input.txt");

            if (checkBeforeWritefile(file)) {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

                pw.println("今日の最高気温は");
                pw.println(10);
                pw.println("度です");

                pw.close();
            } else {
                System.out.println("ファイルに書き込めません");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static boolean checkBeforeWritefile(File file) {
        if (file.exists()) {
            if (file.isFile() && file.canWrite()) {
                return true;
            }
        }

        return false;
    }
}
