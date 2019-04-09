package no.hiof.softwareEngineering.Controller;

import java.time.LocalDate;

public class Payment {

    public static boolean paymentDriver(String cardNumber, int cvc, LocalDate cardDate){
        LocalDate today = LocalDate.now();
        if (cardNumber.length() == 16 && cvc > 99 && cvc <= 999){
            if(cardDate.getYear() > today.getYear()){
                System.out.println("succsses");
                return true;
            }
            else if(cardDate.getYear() < today.getYear()){
                System.out.println("Error");
                return false;
            }
            else if (cardDate.getYear() == today.getYear()){
                if (cardDate.getMonthValue() >= today.getMonthValue()){
                    System.out.println("succsses");
                    return true;
                }
                else{
                    System.out.println("error");
                    return false;
                }
            }
        }
        return false;
    }

}
