package com.craftcoding.junitpractice;

public class StringUtils {

    public static String reverse(String str){
        if(str == null){
            return null;
        }

        if(str.isEmpty() || str.isBlank()){
            return "";
        }

        int s = 0;
        int e = str.length()-1;
        char[] charArray = str.toCharArray();
        while (s < e) {
            char temp = charArray[s];
            charArray[s] = charArray[e];
            charArray[e] = temp;
            s++;
            e--;
        }
        return new String(charArray);
    }
}
