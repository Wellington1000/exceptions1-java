//Aula 141, contém exemplos de github
package View;

import Model.entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Room number");
        int number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out data (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        
        if ( !checkOut.after(checkIn) ) {
            System.out.println("Error in reservation: Check=out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            
            System.out.println("");
            System.out.println("Enter date to update the reservation");
            System.out.println("Check-in:");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out: ");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates fot update must beofore");
            }
            else if( ! checkOut.after(checkIn)) {
                 System.out.println("Error in reservation: Reservation dates fot update must beofore");
            }
            
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        sc.close();
    }
}
