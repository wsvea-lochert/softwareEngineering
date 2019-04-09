package no.hiof.softwareEngineering.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentView {

    public static void runPayment(){
        Scanner input = new Scanner(System.in);
        System.out.print("Cardnumber: ");
        String cardNumebr = input.nextLine();

        String regex = "^(?:[0-9]{2})?[0-9]{2}/[0-3]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("date: ");
        String date = input.nextLine();
        Matcher matcher = pattern.matcher(date);

        while(!matcher.matches()){
            System.out.print("Ugyldig input: ");
            date = input.nextLine();
            matcher = pattern.matcher(date);
        }
    }


}
