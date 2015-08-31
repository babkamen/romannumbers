/* package whatever; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
public class ArabicToRomanNumberConverter {
    private static int maxValue;
    private static Map<Integer, String> labels = new LinkedHashMap<Integer, String>();

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


    public static String convert(int inputNum) throws Exception {
        int num=inputNum;
        String s="";
        List<Integer> b = Arrays.asList(keyArr);
        if (maxValue == 0) maxValue = Collections.max(b);
        while (num >= 1) {
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
        int i=0;
        for(String s:args) {
            try {
                i = Integer.parseInt(s);
            }catch (NumberFormatException e) {
                System.err.println("Cannot convert string \"" + s + "\" to  a number");
                continue;
            }
            if(i<1){
                System.out.println("Cannot convert number<1.You entered="+i);
            }else if(i>3999){
                System.out.println("Cannot convert number>3999.You entered="+i);
            }else {
                System.out.println(s + "=" + convert(i));
            }
        }
    }
}