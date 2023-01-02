package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Romm number: ");
		int number = sc.nextInt();		
		System.out.print("Checki-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());		
		System.out.print("Checki-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		System.out.println();
		
		// comparando as datas, o checkin tem que ser antes do checkout com o metodo .after()
		
		if(!checkout.after(checkin)) {			
			System.out.println(" Error in reservation: Check-out date must be after check-in date.");
		}
		else {
			System.out.println("==========#####//////////#####==========");
			Reservations reservation = new Reservations(number, checkin, checkout);
			System.out.println("Reservation: " +reservation);			
			System.out.println();
			
			System.out.println(">>> Enter date to update  the reservation <<<");
			System.out.print("Checki-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());			
			System.out.print("Checki-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			System.out.println();
			
			/*Tratando erros forma ruim: Tratando direto no programa principal*/
			
				String error = reservation.updateDates(checkin, checkout);
				
				if(error != null) {
					System.out.println("Error in reservation" +error);
				}
				else {
					System.out.println("==========#####<<<<<>>>>>#####==========");
					System.out.println("Reservation: " + reservation);
					
				}			
			
		}			
		
		sc.close();

	}

}
