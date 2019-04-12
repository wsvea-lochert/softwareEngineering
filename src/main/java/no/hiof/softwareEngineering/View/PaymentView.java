package no.hiof.softwareEngineering.View;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static no.hiof.softwareEngineering.Controller.Payment.*;

public class PaymentView {
    static Scanner input = new Scanner(System.in);

    public static boolean runPayment(){
        return resciveCardNumber() && resciveDate() && resciveCVC();
    }

    public static boolean resciveCVC(){
        System.out.print("CVC: ");
        int cvc = input.nextInt();

        while(!checkCVC(cvc)){
            System.out.print("CVC er for kort eller for lang, prøv igjen: ");
            cvc = input.nextInt();
        }
        return true;
        //return cvc;
    }

    public static boolean resciveDate(){
        System.out.print("Utløpsdato(mm/åå): ");
        String tempDate = input.nextLine();

        while(!checkDatePattern(tempDate)){
            tempDate = input.nextLine();
        }

        String date = fixDate(tempDate);

        if (!checkDate(date)) {
            System.out.println("Ugyldig dato, prøv igjen.");
            resciveDate();
        }
        return true;
    }

    public static boolean resciveCardNumber(){
        System.out.print("Skirv inn kort nummer(16 siffer): ");
        String cardNumber = input.nextLine();

        while(!checkCardNumber(cardNumber)){
            System.out.print("Feil, Prøv igjen: ");
            cardNumber = input.nextLine();
        }
        return true;
    }
}
