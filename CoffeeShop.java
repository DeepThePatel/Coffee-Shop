import java.util.Scanner;

// Interface
interface Drink {
    double cost();
    String description();
}

//Abstract class
abstract class Beverage implements Drink {
    protected String size;
    protected boolean milk;
    protected boolean sugar;
}

//Coffee class
class Coffee extends Beverage {
    private boolean decaf;

    public Coffee(String size, boolean sugar, boolean milk, boolean decaf) {
        this.size = size;
        this.milk = milk;
        this.sugar = sugar;
        this.decaf = decaf;
    }

    @Override
    public double cost() {
        double cost = 3.0;
        if (decaf) cost += 0.5;
        return cost;
    }

    @Override
    public String description() {
        return "A " + size + " coffee with " + (milk ? "milk" : "no milk") + " and " + (sugar ? "sugar" : "no sugar") + " and " + (decaf ? "is decaf." : "is not decaf.");
    }

    public boolean getDecaf() {
        return decaf;
    }

    public void setDecaf(boolean decaf) {
        this.decaf = decaf;
    }
}

//Tea class
class Tea extends Beverage {
    private String type;

    public Tea(String size, boolean milk, boolean sugar, String type) {
        this.size = size;
        this.milk = milk;
        this.sugar = sugar;
        this.type = type;
    }

    @Override
    public String description() {
        return "A " + size + " " + type + " tea with " + (milk ? "milk" : "no milk") + " and " + (sugar ? "sugar." : "no sugar.");
    }

    @Override
    public double cost() {
        double cost = 2.0;
        return cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Order {
    private Beverage beverage;

    public Order(Beverage beverage) {
        this.beverage = beverage;
    }

    public void printOrder() {
        System.out.println("Order: " + beverage.description());
        System.out.println("Cost: $" + beverage.cost());
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        System.out.println("Welcome to the Coffee Shop! To get started, would you like \"Tea\" or \"Coffee\"?");

        Scanner scanner = new Scanner(System.in);
        String drinkType = "";
        
        while (true) {
            String drink = scanner.nextLine().trim();

            if(drink.equalsIgnoreCase("tea") || drink.equalsIgnoreCase("coffee")) {
                drinkType = drink;
                break;
            }
            else 
                System.out.println("Invalid input, please type either \"Coffee\" or \"Tea\".");
        }

        //Coffee
        if(drinkType.trim().equalsIgnoreCase("coffee")) {
            Coffee coffee = new Coffee("", false, false, false);
            System.out.println("What size coffee would you like? Small, Medium, or Large?");

            while(true) {
                String drinkSize = scanner.nextLine().trim();
                if (drinkSize.equalsIgnoreCase("small") || drinkSize.equalsIgnoreCase("medium") || drinkSize.trim().equalsIgnoreCase("large")) {
                   coffee.size = drinkSize; 
                   break;
                }
                    
                else
                    System.out.println("Invalid input, please choose either \"Small\", \"Medium\", or \"Large\".");
            }

            System.out.println("Would you like milk? (Y/N)?");

            while(true) {
                String isMilk = scanner.nextLine().trim();
                if (isMilk.equalsIgnoreCase("y")) {
                    coffee.milk = true;
                    break;
                }
                    
                else if (isMilk.equalsIgnoreCase("n")) {
                    coffee.milk = false;
                    break;
                }
                    
                else
                    System.out.println("Invalid input, please type either \"Y\" or \"N\".");
            }

            System.out.println("Would you like sugar? (Y/N)");

            while (true) {
                String isSugar = scanner.nextLine().trim();
                if (isSugar.equalsIgnoreCase("y")) {
                    coffee.sugar = true;
                    break;
                }
                    
                else if (isSugar.equalsIgnoreCase("n")) {
                    coffee.sugar = false;
                    break;
                }
                else
                    System.out.println("Invalid input, please type either \"Y\" or \"N\".");
            }

            System.out.println("Would you like it to be decaf? (Y/N)");
            
            while(true) {
                String isDecaf = scanner.nextLine().trim();
                if(isDecaf.equalsIgnoreCase("y")) {
                    coffee.setDecaf(true);
                    break;
                }
                    
                else if(isDecaf.equalsIgnoreCase("n")) {
                    coffee.setDecaf(false);
                    break;
                }
                    
                else
                    System.out.println("Invalid input, please type either \"Y\" or \"N\".");
            }

            Order order = new Order(coffee);
            order.printOrder();
        }

        //Tea
        else {
            Tea tea = new Tea("", false, false, "");

            System.out.println("What size tea would you like? Small, Medium, or Large?");

            while (true) {
                String drinkSize = scanner.nextLine().trim();
                if(drinkSize.equalsIgnoreCase("small") || drinkSize.equalsIgnoreCase("medium") || drinkSize.trim().equalsIgnoreCase("large")) {
                    tea.size = drinkSize;
                    break;
                }
                else
                    System.out.println("Invald input, please choose either Small, Medium, or Large.");
            }

            System.out.println("Would you like \"Green\" or \"Herbal\" tea?");

            while(true) {
                String teaType = scanner.nextLine().trim();
                if(teaType.equalsIgnoreCase("Green")) {
                    tea.setType("green");
                    break;
                }
                else if(teaType.equalsIgnoreCase("herbal")) {
                    tea.setType("herbal");
                    break;
                }
                else
                    System.out.println("Invalid input, please choose either \"Green\" or \"Herbal\".");
            }

            System.out.println("Would you like milk? (Y/N)");

            while (true) {
                String isMilk = scanner.nextLine().trim();
                if(isMilk.equalsIgnoreCase("Y")) {
                    tea.milk = true;
                    break;
                }
                else if(isMilk.equalsIgnoreCase("N")) {
                    tea.milk = false;
                    break;
                }
                else
                    System.out.println("Invalid input, please choose either \"Y\" or \"N\".");
            }

            System.out.println("Would you like sugar? (Y/N)");

            while(true) {
                String isSugar = scanner.nextLine().trim();
                if(isSugar.equalsIgnoreCase("Y")) {
                    tea.sugar = true;
                    break;
                }
                else if(isSugar.equalsIgnoreCase("N")) {
                    tea.sugar = false;
                    break;
                }
                else
                    System.out.println("Invalid input, please choose either \"Y\" or \"N\".");
            }

            Order order = new Order(tea);
            order.printOrder();
        }

        scanner.close();
    }
}

