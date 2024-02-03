package MyFailedTest;

public class Room {

    private final int roomNumber;
    private final RoomType roomType;
    private boolean availability;

    public Room(int roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                " roomNumber <=> " + roomNumber + "\n" +
                "                       roomType :::> " + roomType + "\n" +
                "                       availability :::> " + availability +
                '}' + "\n" + "                 ";
    }
}
