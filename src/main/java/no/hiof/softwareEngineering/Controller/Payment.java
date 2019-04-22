package no.hiof.softwareEngineering.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Payment {

    /*
    * fixes date format for localdate.
    */
    public static String fixDate(String date){
        String replaceString = date.replace("/", "-");
        return "01-" + replaceString;
    }

    /*
    * checks if the cardnumber is 16 characters long and only contains numbers
    */
    public static boolean checkCardNumber(String cardnumber){
        String regex = "^(?:[0-9]{16})$";
        Pattern patter = Pattern.compile(regex);
        Matcher matcher = patter.matcher(cardnumber);

        return cardnumber.length() == 16 && matcher.matches();
    }

    /*
    * checks of the date format is correctly inputted as MM/YY
    */
    public static boolean checkDatePattern(String date){
        String regex = "^[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    /*
    * checks if the cvc is 3 numbers long
    */
    public static boolean checkCVC(int cvc){
        return cvc > 99 && cvc < 1000;
    }

    /*
    * Checks if the customers credit card has not expired.
    * */
    public static boolean checkDate(String Date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate today = LocalDate.now();
        LocalDate cardDate = LocalDate.parse(Date, formatter);


        if(cardDate.getYear() > today.getYear()){
            return true;
        }
        else if(cardDate.getYear() < today.getYear()){
            return false;
        }
        else if (cardDate.getYear() == today.getYear()){
            if (cardDate.getMonthValue() >= today.getMonthValue()){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
