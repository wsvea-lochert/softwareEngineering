package no.hiof.softwareEngineering.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Payment {

    public static String fixDate(String date){
        String replaceString = date.replace("/", "-");
        return "01-" + replaceString;
    }

    public static boolean checkCardNumber(String cardnumber){
        String regex = "^(?:[0-9]{16})$";
        Pattern patter = Pattern.compile(regex);
        Matcher matcher = patter.matcher(cardnumber);

        return cardnumber.length() == 16 && matcher.matches();
    }

    public static boolean checkDatePattern(String date){
        String regex = "^[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$"; // MM/YY
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    public static boolean checkCVC(int cvc){
        return cvc > 99 && cvc < 1000;
    }

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
