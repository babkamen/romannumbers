/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main {
    private static int maxValue;
    private static Map<Integer, String> labels = new LinkedHashMap<Integer, String>();
    private static Map<Integer, String> exceptionsTable = new LinkedHashMap<Integer, String>();

    private static Integer[] keyArr;

    static {

        labels.put(1000, "M");
        labels.put(900, "CM");
        labels.put(500, "D");
        labels.put(400, "CD");
        labels.put(100, "C");
        labels.put(90, "XC");
        labels.put(50, "L");
        labels.put(40, "XL");
        labels.put(10, "X");
        labels.put(9, "IX");
        labels.put(5, "V");
        labels.put(4, "IV");
        labels.put(1, "I");
        Set<Integer> keySet = labels.keySet();
        keyArr = keySet.toArray(new Integer[0]);


    }

    public static int findKey(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getValue().equals(value)) {
                return e.getKey();
            }
        }
        return 0;
    }

    private static int convertFromRomanToArabNumeric(String str) throws Exception {
        int res = 0;
        String s2 = "", s = str;
        boolean foundInExceptionsTable;
        for (int i = 0; i < s.length(); i++) {
            foundInExceptionsTable = false;

            if (i + 2 <= s.length()) {
                s2 = s.substring(i, i + 2);
                int b = findKey(exceptionsTable, s2);
//                System.out.println("Found string=" + s2 + " in exceptionsTable.Key=" + b);
                foundInExceptionsTable = b > 0;
                if (b > 0) {
                    res += b;
                    i++;
                }
            }
            if (!foundInExceptionsTable) {
                s2 = s.substring(i, i + 1);
                int b = findKey(labels, s2);
                if (b == 0) {
                    throw new Exception("Not found key by value=" + s2 + "\t in map" + labels);
                }
                res += b;
            }
//            System.out.println("Res=" + res);

//            System.out.println("S2-2=" + s2);
        }
        return res;
    }

    private static String convert(int num) throws Exception {
        return convert(num, "");
    }

    private static String convert(int inputNum, String s) throws Exception {
        int num=inputNum;
        List<Integer> b = Arrays.asList(keyArr);
        if (maxValue == 0) maxValue = Collections.max(b);
        while (num >= 1) {
            System.out.println("S=" + s);
            for (int m : labels.keySet()) {
                if (num >= m) {
                    s += labels.get(m);
                    num -= m;
                    break;
                }
            }
        }
        return s;


    }

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(labels.entrySet());
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//        int s = Integer.parseInt(r.readLine());


        int s = 94;
//        String s2 = "XC";
//        System.out.println(convertFromRomanToArabNumeric("LXXXX"));
        System.out.println("Converted=" + convert(s));
    }
}