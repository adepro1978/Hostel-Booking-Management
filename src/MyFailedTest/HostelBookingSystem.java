package MyFailedTest;

import java.util.*;

import static MyFailedTest.RoomType.*;
import static java.lang.System.out;

public class HostelBookingSystem {


    String errorMessage = " Hostel not Available";
    private final List<Hostel> hostelsList;

    public HostelBookingSystem() {
        hostelsList = new LinkedList<>();
    }

    public void addHostel() {
        Scanner scanner = new Scanner(System.in);

        out.println("Type hostelName ENTER | hostelAddress ENTER : ");
        String hostelName = scanner.nextLine();
        String hostelAddress = scanner.nextLine();

        List<Room> roomsList = new ArrayList<>();

        //creating a new hostel
        Hostel hostel = new Hostel(hostelName, hostelAddress, roomsList);
        hostelsList.add(hostel);
        out.println(" hostel added successfully");
    }

    public void deleteHostel() {

        if (!hostelsList.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            out.println("enter name of hostel to delete : ");
            String hostelNameToDelete = scanner.nextLine();

            //checking for hostel with stream and lambda inside if statement.
            if (hostelsList.stream().anyMatch(hostel -> hostel.getHostelName().equals(hostelNameToDelete))) {
                hostelsList.removeIf(hostel -> hostel.getHostelName().equals(hostelNameToDelete));
                out.println("hostel deleted successfully");
            }

            else { out.println(errorMessage); }
        }

        else { out.println("Hostel list is Empty, Add hostel to the list and try again"); }
    }

    public void updateHostelData() {
        Scanner scanner = new Scanner(System.in);

        out.println("enter hostel name to update : ");
        String hostelNameToUpdate = scanner.nextLine();

        //checking for hostel with optional with stream and lambda.

        Optional<Hostel> hostelToUpdate = hostelsList.stream().filter(hostel -> hostel.getHostelName()
                .equals(hostelNameToUpdate)).findFirst();
        if (hostelToUpdate.isPresent()) {
            out.println("enter new hostel name or leave blank to keep the current name : ");
            String hostelNewName = scanner.nextLine();

            if (!(hostelNewName.equals(""))) {
                hostelToUpdate.get().setHostelName(hostelNewName);
            }
            out.println("enter new hostel address or leave blank to keep the current address : ");
            String hostelNewAddress = scanner.nextLine();

            if (!(hostelNewAddress.equals(""))) {
                hostelToUpdate.get().setHostelAddress(hostelNewAddress);
            }
            out.println("hostel updated successfully");
        } else {
            out.println(errorMessage);
        }
    }

    public void bookRoom() {
        Scanner scanner = new Scanner(System.in);

        out.println("enter hostel name to book room : ");
        String hostelNameToBookRoom = scanner.nextLine();

        //checking for hostel with optional with stream and lambda.
        Optional<Hostel> hostelToBook = hostelsList.stream().filter(hostel -> hostel.getHostelName()
                .equals(hostelNameToBookRoom)).findFirst();
        if (hostelToBook.isPresent()) {
            out.println("Enter room number to book : ");
            int roomNumberToBook = scanner.nextInt();
            Optional<Room> roomToBook = hostelToBook.get().getRoomList().stream().filter(room -> room.getRoomNumber()
                    == roomNumberToBook && room.isAvailability()).findFirst();

            if (roomToBook.isPresent()) {
                roomToBook.get().setAvailability(false);
                out.println("Room booked successfully");
            } else {
                out.println("Room is not available for booking");
            }
        } else {
            out.println(errorMessage);
        }
    }

    public void cancelBooking() {

        Scanner scanner = new Scanner(System.in);
        out.println("enter hostel name to cancel booking : ");
        String hostelNameToCancelBooking = scanner.nextLine();

        out.println("enter room number to cancel : ");
        int roomNumberToCancel = scanner.nextInt();

        // checking room with for-each loop
        for (Hostel hostel : hostelsList) {
            if (hostel.getHostelName().equals(hostelNameToCancelBooking)) {
                List<Room> roomsList = hostel.getRoomList();
                for (Room room : roomsList) {
                    if (room.getRoomNumber() == roomNumberToCancel) {
                        room.setAvailability(true);
                        out.println(" Room booked Successfully");
                    }
                }
            } else {
                out.println(errorMessage);
            }
            out.println(" ");
        }
    }

    public void displayHostelList() {

        //iterating through hostel with for-each loop.
        if (!hostelsList.isEmpty()) {
            for (Hostel hostel : hostelsList) {
                out.println(hostel);
            }
        } else {
            out.println(errorMessage);
        }
        out.println(" ");
    }

    public void addRoom() {
        Scanner scanner = new Scanner(System.in);
        out.println(" Name of hostel to add room to : ");
        String hostelName = scanner.nextLine();

        // checking hostel existence by name with stream and lambda.
        Hostel hostel = hostelsList.stream().filter(hostel1 -> hostel1
                .getHostelName().equals(hostelName)).findFirst().orElse(null);

        if (hostel != null) {
            out.println(" enter room number : ");
            int roomNumber = Integer.parseInt(scanner.nextLine());

            //check room number duplicate
            boolean isDuplicate = hostel.getRoomList().stream().anyMatch(room -> room.getRoomNumber() == roomNumber);
            if (isDuplicate) {
                out.println(" Room number already exist");
                return;
            }

            out.printf("Enter room type %n"
                    + "1. SINGLE" + " 2. DOUBLE" + "3. STANDARD" + "4. SUITE %n");
            int roomType = scanner.nextInt();
            RoomType hRoomType = null;

            if (roomType == 1) {
                hRoomType = SINGLE;

            } else if (roomType == 2) {
                hRoomType = DOUBLE;

            } else if (roomType == 3) {
                hRoomType = STANDARD;

            } else if (roomType == 4) {
                hRoomType = SUITE;

            } else {
                out.println(" invalid input ");
            }

            Room room = new Room(roomNumber, hRoomType);
            hostel.getRoomList().add(room);

            out.println(" Room added successfully....");

        } else {
            out.println(errorMessage);
        }
    }

    @Override
    public String toString() {
        return "HostelBookingSystem{" +
                "hostelsList=" + hostelsList +
                '}';
    }
}
