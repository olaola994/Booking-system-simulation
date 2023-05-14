package booking_system;

public class BookingTest {
    static int price(Basket b, String type) {
        int sum = 0;
        for (Room room : b.getRooms()) {
            if (room.getRoomType().equals(type)) {
                sum += room.getPrice();
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        PriceList priceList = PriceList.getInstance();

        priceList.add("single", "standard", 100, 80, 4);
        priceList.add("double", "budget", 140);
        priceList.add("triple", "standard", 300);
        priceList.add("family", "premium", 500);

        System.out.println();
        System.out.println("\ncennik");
        System.out.println(priceList + "\n");

        Client ocean = new Client("ocean", 2200);

        ocean.add(new Single("standard", 4));
        ocean.add(new Triple("standard", 5));
        ocean.add(new Double("premium", 3));
        ocean.add(new Double("budget", 2));

        WishList listaOceanu = ocean.getWishList();
        System.out.println("Lista życzeń klienta " + listaOceanu);

        Basket basketOceanu = new Basket(ocean);
        ocean.repack(basketOceanu);
        System.out.println("Po przepakowaniu, lista życzeń klienta " + listaOceanu);

        System.out.println("Po przepakowaniu, koszyk klienta " + basketOceanu);

        System.out.println("Pokoje standardowe w koszyku klienta ocean kosztowały:  "
                + price(basketOceanu, "standard"));

        ocean.pay(false);
        System.out.println("Po zapłaceniu, klientowi ocean zostało: " + ocean.getBudget() + " zł");

        System.out.println("\n!!!!!!!!!!!!!");
        System.out.println("NOWY KLIENT\n");

        Client morze = new Client("morze", 780);
        morze.add(new Single("standard", 3));
        morze.add(new Double("budget", 4));

        System.out.println("Lista życzeń klienta " + morze.getWishList());
        Basket basketMorza = new Basket(morze);
        morze.repack(basketMorza);
        System.out.println("Po przepakowaniu, lista życzeń klienta " + morze.getWishList());

        System.out.println("Po przepakowaniu, koszyk klienta " + basketMorza);

        morze.pay(true);
        System.out.println("Po zapłaceniu, klientowi morze zostało: " + morze.getBudget() + " zł");

        System.out.println("Po zapłaceniu, koszyk klienta " + basketMorza);
    }
}
