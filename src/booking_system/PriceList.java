package booking_system;
import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;

public final class PriceList {
    private static PriceList instance;

    private static Map<Pair<String, String>, List<Integer>> priceMap = new HashMap<>();
    private PriceList(){}

    public static PriceList getInstance(){
        if (instance == null){
            instance = new PriceList();
        }
        return instance;
    }
    public void add(String name, String type, int price, int discPrice, int nights){
        priceMap.put(new Pair<>(name, type), Arrays.asList(price, discPrice, nights));
    }
    public void add(String name, String type, int price){
        priceMap.put(new Pair<>(name, type), Arrays.asList(price));
    }

    public static Map<Pair<String, String>, List<Integer>> getPriceMap() {
        return priceMap;
    }
    public String toString(){
        return getPriceMap().entrySet().stream()
                .map(entry -> entry.getKey().getKey() + " + " + entry.getKey().getValue() + " -> " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}

