package MyFailedTest;

public class Tools {
    public static void listOperations() {

        System.out.printf(
                "  1. Add new hostel %n" +
                        "  2. Add Room to hostel %n" +
                        "  3. Delete hostel %n" +
                        "  4. Update hostel data %n" +
                        "  5. Book Room(s) %n" +
                        "  6. Unbooked Room()s %n" +
                        "  7. Display all hostel list %n" +
                        "  8. Exit the program %n");

        System.out.println(" ");
    }
   /* public static List<Room> roomLister() {
        List<Room> roomsList = new ArrayList<>();
        roomsList.add(new Room(1, "single"));
        roomsList.add(new Room(2, "double"));
        roomsList.add(new Room(3, "a room self"));
        roomsList.add(new Room(4, "suit"));
        roomsList.add(new Room(5, "single"));
        roomsList.add(new Room(6, "single"));
        roomsList.add(new Room(7, "double"));
        roomsList.add(new Room(8, "double"));
        roomsList.add(new Room(9, "single"));
        roomsList.add(new Room(10, "single"));
        return roomsList;
    }**/
}
