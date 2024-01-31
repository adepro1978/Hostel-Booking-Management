package MyFailedTest;

import java.util.Scanner;

public class HostelBookingManagementRunner1 {
    public static void main(String[] args) {

        HostelBookingSystem hostelBookingSystem = new HostelBookingSystem();
        Scanner scanner = new Scanner(System.in);
        int operation;

        do {
            System.out.println("HOSTEL BOOKING SYSTEM");
            Tools.listOperations();
            System.out.println(" enter your prefer option");
            operation = scanner.nextInt();

            switch (operation) {
                case 1 -> {
                    // Add new hostel

                    hostelBookingSystem.addHostel();
                    System.out.println();
                }

                case 2 -> //add room to a hostel
                        hostelBookingSystem.addRoom();

                case 3 -> // Delete Hostel
                        hostelBookingSystem.deleteHostel();

                case 4 -> // Update Hostel
                        hostelBookingSystem.updateHostelData();

                case 5 -> //Book Hostel
                    //HostelBookingSystem.viewAllHostelList();
                        hostelBookingSystem.bookRoom();

                case 6 -> //Cancel Booking
                        hostelBookingSystem.cancelBooking();

                case 7 -> //list of hostel
                        hostelBookingSystem.displayHostelList();

                case 8 -> {//Exit Programme
                    System.out.println("Exiting the programme");
                    System.exit(1);
                }
            }
        }
        while (true);
    }
}