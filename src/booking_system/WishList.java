package booking_system;

import java.util.ArrayList;

public class WishList {
    protected ArrayList<Room> rooms = new ArrayList<>();


    public String toString(){
        if(rooms.isEmpty()) {
            return "-- empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (Room r : rooms){
            sb.append("name: " + r.getName()  + "| type: " + r.getRoomType() +
                    "| nights: " + r.getNights() +  "| price: " + r.getPrice() + "\n");
        }
        return sb.toString();
    }
}
