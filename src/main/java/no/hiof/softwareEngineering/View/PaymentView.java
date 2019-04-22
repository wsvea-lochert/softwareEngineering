package no.hiof.softwareEngineering.View;

import java.util.Scanner;

import static no.hiof.softwareEngineering.Controller.Payment.*;

public class PaymentView {
    static Scanner input = new Scanner(System.in);

    /*
    * Main payment function in view to run all the correct validation on the users creditcard
    */
    public static boolean runPayment(){
        return resciveCardNumber() && resciveDate() && resciveCVC();
    }

    /*
    * takes in the customers CVC code
    */
    public static boolean resciveCVC(){
        System.out.print("CVC: ");
        int cvc = input.nextInt();

        while(!checkCVC(cvc)){
            System.out.print("CVC er for kort eller for lang, prøv igjen: ");
            cvc = input.nextInt();
        }
        return true;
    }

    /*
    * Takes in the expiration for the customers credit card
    */
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

    /*
    * takes in the customers creditcard number
    */
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
