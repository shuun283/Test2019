package zhoutianfeng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arithmetic {

    public static void main(String[] args) {

        BufferedReader reader = null;
        InputStreamReader inputStreamReader = null;
        try {
            System.out.println("演算式を入力ください");
            inputStreamReader = new InputStreamReader(System.in);
            reader = new BufferedReader(inputStreamReader);
            String str = reader.readLine();
            {
                System.out.println("結果：" + opt(str) + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static double opt(String s) throws Exception {
        if (s == null || "".equals(s.trim())) {
        }
        int a1 = s.indexOf("+");
        int a2 = s.indexOf("-");
        int a3 = s.indexOf("*");
        int a4 = s.indexOf("/");

        if (a1 != -1) {
            return opt(s.substring(0, a1)) + opt(s.substring(a1 + 1, s.length()));
        }
        if (a2 != -1) {
            return opt(s.substring(0, a2)) - opt(s.substring(a2 + 1, s.length()));
        }
        if (a3 != -1) {
            return opt(s.substring(0, a3)) * opt(s.substring(a3 + 1, s.length()));
        }
        if (a4 != -1) {
            double divisor = opt(s.substring(a4 + 1, s.length()));
            if (divisor == 0) {
                throw new Exception("除数を0にするこはできません");
            }
            return opt(s.substring(0, a4)) / divisor;
        }
        return Integer.parseInt(s.trim());
    }
}