package booking_system;

import java.util.ArrayList;
import java.util.Comparator;
public class Basket {
    protected Client client;
    public Basket(Client client){
        this.client = client;
    }
    public Basket(Basket original){
        this.client = original.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    protected ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public String toString(){
        if(rooms.isEmpty()) {
            return "-- mpty";
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


class BasketPriceComparator implements Comparator<Room>{
    public int compare(Room r1, Room r2){
        return r1.getPrice() - r2.getPrice();
    }
}
