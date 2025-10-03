// Java Example: Decorator Pattern (Structural)
// Use Case: Coffee Shop Ordering System

// Base component
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }
    
    public double getCost() {
        return 2.00;
    }
}

// Base decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    
    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    
    public String getDescription() {
        return coffee.getDescription();
    }
    
    public double getCost() {
        return coffee.getCost();
    }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
    
    public double getCost() {
        return coffee.getCost() + 0.50;
    }
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
    
    public double getCost() {
        return coffee.getCost() + 0.25;
    }
}

class WhipDecorator extends CoffeeDecorator {
    WhipDecorator(Coffee coffee) {
        super(coffee);
    }
    
    public String getDescription() {
        return coffee.getDescription() + ", Whip Cream";
    }
    
    public double getCost() {
        return coffee.getCost() + 0.75;
    }
}

class VanillaDecorator extends CoffeeDecorator {
    VanillaDecorator(Coffee coffee) {
        super(coffee);
    }
    
    public String getDescription() {
        return coffee.getDescription() + ", Vanilla Syrup";
    }
    
    public double getCost() {
        return coffee.getCost() + 0.60;
    }
}

public class CoffeeShopDecorator {
    public static void main(String[] args) {
        // Simple coffee
        Coffee coffee1 = new SimpleCoffee();
        System.out.println("Order: " + coffee1.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee1.getCost()));
        System.out.println();
        
        // Coffee with milk and sugar
        Coffee coffee2 = new SimpleCoffee();
        coffee2 = new MilkDecorator(coffee2);
        coffee2 = new SugarDecorator(coffee2);
        System.out.println("Order: " + coffee2.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee2.getCost()));
        System.out.println();
        
        // Fancy coffee with multiple add-ons
        Coffee coffee3 = new SimpleCoffee();
        coffee3 = new MilkDecorator(coffee3);
        coffee3 = new VanillaDecorator(coffee3);
        coffee3 = new WhipDecorator(coffee3);
        System.out.println("Order: " + coffee3.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee3.getCost()));
        System.out.println();
        
        // Super fancy coffee
        Coffee coffee4 = new SimpleCoffee();
        coffee4 = new SugarDecorator(coffee4);
        coffee4 = new MilkDecorator(coffee4);
        coffee4 = new VanillaDecorator(coffee4);
        coffee4 = new WhipDecorator(coffee4);
        System.out.println("Order: " + coffee4.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee4.getCost()));
    }
}
