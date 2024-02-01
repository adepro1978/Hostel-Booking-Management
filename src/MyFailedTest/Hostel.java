package MyFailedTest;

import java.util.ArrayList;
import java.util.List;

public class Hostel {

    private String hostelName;
    private String hostelAddress;
    private final List<Room> roomList;

    public Hostel(String hostelName, String hostelAddress, List<Room> roomList) {
        this.hostelName = hostelName;
        this.hostelAddress = hostelAddress;
        this.roomList = new ArrayList<>(roomList);
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public void setHostelAddress(String hostelAddress) {
        this.hostelAddress = hostelAddress;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "hostelName='" + hostelName + '\'' +
                ", hostelAddress='" + hostelAddress + '\'' +
                ", roomList=" + roomList +
                '}';
    }
}