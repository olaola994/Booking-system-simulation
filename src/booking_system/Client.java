package booking_system;
import java.util.*;

public class Client {
    protected int id = 1;
    protected String name;
    protected int budget;

    protected WishList wishList;
    protected Basket basket;

    public Client(String name, int budget){
        id += 1;
        this.name = name;
        this.budget = budget;
        this.wishList = new WishList();
        this.basket = new Basket(this);
    }


    public void add(Room room){
        wishList.rooms.add(room);
    }
    public WishList getWishList(){
        return wishList;
    }

    public int getBudget() {
        return budget;
    }

    public void repack(Basket basket){
        Map<Pair<String, String>, List<Integer>> priceMap = PriceList.getPriceMap();

        priceMap.forEach((key, value) -> {
            String roomName = key.getKey();
            String roomType = key.getValue();

            wishList.rooms.forEach(room -> {
                if(room.getName().equals(roomName) && room.getRoomType().equals(roomType)){
                    basket.rooms.add(room);
                }
            });
            wishList.rooms.removeIf(room -> room.getName().equals(roomName) && room.getRoomType().equals(roomType));
            Collections.sort(basket.getRooms(), new BasketPriceComparator());
            this.basket = basket;
            this.basket.setClient(this);
        });
    }

    public void pay(boolean commision){
        if(budget > 5)
            if(commision) budget -= 5;

        if (!basket.getRooms().isEmpty()) {
            int lastIndex = basket.getRooms().size() - 1;
            while (lastIndex >= 0 && this.budget > basket.getRooms().get(lastIndex).getPrice()) {
                Room currentRoom = basket.getRooms().get(lastIndex);
                this.budget -= currentRoom.getPrice();
                basket.getRooms().remove(lastIndex);
                lastIndex--;
            }
        }
    }
}
