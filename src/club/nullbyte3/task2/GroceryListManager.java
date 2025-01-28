package club.nullbyte3.task2;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private Map<String, Map<String, ItemInfo>> groceryList = new HashMap<>();

    private static class ItemInfo {
        double cost;
        int quantity;

        ItemInfo(double cost, int quantity) {
            this.cost = cost;
            this.quantity = quantity;
        }
    }

    public void addItem(String item, double cost, String category, int quantity) {
        Map<String, ItemInfo> categoryItems = groceryList.getOrDefault(category, new HashMap<>());
        categoryItems.put(item, new ItemInfo(cost, quantity));
        groceryList.put(category, categoryItems);
    }

    public void removeItem(String item, String category) {
        Map<String, ItemInfo> categoryItems = groceryList.get(category);
        if (categoryItems != null) {
            categoryItems.remove(item);
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (Map.Entry<String, Map<String, ItemInfo>> categoryEntry : groceryList.entrySet()) {
            String category = categoryEntry.getKey();
            Map<String, ItemInfo> categoryItems = categoryEntry.getValue();
            System.out.println("Category: " + category);
            for (Map.Entry<String, ItemInfo> itemEntry : categoryItems.entrySet()) {
                String item = itemEntry.getKey();
                ItemInfo itemInfo = itemEntry.getValue();
                System.out.println(item + ": $" + itemInfo.cost + " (Q: " + itemInfo.quantity + ")");
            }
        }
    }

    public boolean checkItem(String item, String category) {
        Map<String, ItemInfo> categoryItems = groceryList.get(category);
        return categoryItems != null && categoryItems.containsKey(item);
    }

    public void updateQuantity(String item, String category, int newQuantity) {
        Map<String, ItemInfo> categoryItems = groceryList.get(category);
        if (categoryItems != null) {
            ItemInfo itemInfo = categoryItems.get(item);
            if (itemInfo != null) {
                itemInfo.quantity = newQuantity;
            }
        }
    }

    public void displayAvailableItems() {
        for (Map.Entry<String, Map<String, ItemInfo>> categoryEntry : groceryList.entrySet()) {
            String category = categoryEntry.getKey();
            Map<String, ItemInfo> categoryItems = categoryEntry.getValue();
            System.out.println("Items in the " + category + " category:");
            for (Map.Entry<String, ItemInfo> itemEntry : categoryItems.entrySet()) {
                String item = itemEntry.getKey();
                ItemInfo itemInfo = itemEntry.getValue();
                if (itemInfo.quantity > 0) {
                    System.out.println(item + ": $" + itemInfo.cost + " (Q: " + itemInfo.quantity + ")");
                }
            }
        }
    }

    public void displayByCategory(String category) {
        Map<String, ItemInfo> categoryItems = groceryList.get(category);
        if (categoryItems != null) {
            System.out.println("Items in the " + category + " category:");
            for (Map.Entry<String, ItemInfo> itemEntry : categoryItems.entrySet()) {
                String item = itemEntry.getKey();
                ItemInfo itemInfo = itemEntry.getValue();
                System.out.println(item + ": $" + itemInfo.cost + " (Q: " + itemInfo.quantity + ")");
            }
        } else {
            System.out.println("No items found in the " + category + " category.");
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Map<String, ItemInfo> categoryItems : groceryList.values()) {
            for (ItemInfo itemInfo : categoryItems.values()) {
                totalCost += itemInfo.cost * itemInfo.quantity;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // We could make two enums and just use them instead, but as this isn't critical and just a task, we'll do this.
        // we could also split this into multiple classes, make it more cool, blabla whatever, but yeh.
        manager.addItem("Apples", 2.99, "Fruits", 5);
        manager.addItem("Oranges", 1.99, "Fruits", 3);
        manager.addItem("Milk", 2.49, "Dairy", 2);
        manager.addItem("Bread", 3.49, "Bakery", 1);
        manager.updateQuantity("Apples", "Fruits", 8);

        System.out.println("Total Cost: $" + manager.calculateTotalCost());
        System.out.println();

        manager.displayByCategory("Fruits");
        System.out.println();

        manager.displayAvailableItems();
        System.out.println();

        manager.removeItem("Bread", "Bakery");
        manager.displayList();
        System.out.println();

        System.out.println("Is "+"Milk"+" in the Dairy category? " + manager.checkItem("Milk", "Dairy"));
        System.out.println("Is "+"Eggs"+" in the Dairy category? " + manager.checkItem("Eggs", "Dairy"));
    }
}
