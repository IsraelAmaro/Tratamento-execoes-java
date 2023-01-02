package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Romm number: ");
			int number = sc.nextInt();		
			System.out.print("Checki-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());		
			System.out.print("Checki-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			System.out.println();
			
			System.out.println("==========#####//////////#####==========");
			Reservations reservation = new Reservations(number, checkin, checkout);
			
			System.out.println("Reservation: " +reservation);			
			System.out.println();
			
			System.out.print(">>> Enter date to update  the reservation <<<");
			System.out.print("Checki-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());			
			System.out.print("Checki-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			System.out.println();
		
			reservation.updateDates(checkin, checkout);
			System.out.println("==========#####<<<<<>>>>>#####==========");
			System.out.println("Reservation: " + reservation);	
			}
		catch(ParseException e){
			
			System.out.println("Invalid date format");			
		}
		catch(DomainException e) {
			System.out.println("Erro in reservation "+ e.getMessage());
		}
		sc.close();

	}

}
