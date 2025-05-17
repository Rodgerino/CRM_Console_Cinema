package main.com.util;

public class InputValidator {

    public static boolean isValidRow(int row){
        return row >= 1 && row <= 5;
    }

    public static boolean isValidSeatNum(int seatNum){
        return seatNum >= 1 && seatNum <= 10;
    }

    public static boolean isValidName(String name){
        return name != null && name.trim().isEmpty();
    }

}
