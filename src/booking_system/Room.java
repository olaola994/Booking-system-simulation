package booking_system;
import java.util.*;

public abstract class Room {
    protected String roomType;
    protected int nights; // the number of nights that will be spent in this room
    protected String name;
    public Room(String roomType, int nights){
        this.nights = nights;
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNights() {
        return nights;
    }
    public int getPrice(){
        Map<Pair<String, String>, List<Integer>> priceMap = PriceList.getPriceMap();

        List<Integer> prices = priceMap.get(new Pair<>(this.name, this.roomType));

        if(prices == null) return -1;
        else if (prices.size() == 1 ) {
            return prices.get(0) * this.nights;
        } else if (prices.size() > 1) {
            if(this.nights >= prices.get(2)){
                return this.nights * prices.get(1);
            }
            else {
                return this.nights * prices.get(0);
            }
        }
        else return -1;
    }
}

class Single extends Room{
    public Single(String roomType, int nights){
        super(roomType, nights);
        name = "single";
    }
}

class Double extends Room{
    public Double(String roomType, int nights){
        super(roomType, nights);
        name = "double";
    }
}

class Triple extends Room{
    public Triple(String roomType, int nights){
        super(roomType, nights);
        name = "triple";
    }
}

class Family extends Room{
    public Family(String roomType, int nights){
        super(roomType, nights);
        name = "family";
    }
}
