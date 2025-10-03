// Java Example: Factory Method Pattern (Creational)
// Use Case: Vehicle Manufacturing System

abstract class Vehicle {
    protected String model;
    protected int year;
    
    Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }
    
    abstract void start();
    abstract void displayInfo();
}

class Car extends Vehicle {
    Car(String model, int year) {
        super(model, year);
    }
    
    void start() {
        System.out.println("Car engine started - Vroom!");
    }
    
    void displayInfo() {
        System.out.println("Car: " + model + " (" + year + ")");
    }
}

class Motorcycle extends Vehicle {
    Motorcycle(String model, int year) {
        super(model, year);
    }
    
    void start() {
        System.out.println("Motorcycle engine started - Brrr!");
    }
    
    void displayInfo() {
        System.out.println("Motorcycle: " + model + " (" + year + ")");
    }
}

class Truck extends Vehicle {
    Truck(String model, int year) {
        super(model, year);
    }
    
    void start() {
        System.out.println("Truck engine started - GRRR!");
    }
    
    void displayInfo() {
        System.out.println("Truck: " + model + " (" + year + ")");
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle(String model, int year);
    
    Vehicle manufactureVehicle(String type, String model, int year) {
        Vehicle vehicle = createVehicle(model, year);
        System.out.println("Manufacturing " + type + "...");
        vehicle.displayInfo();
        vehicle.start();
        return vehicle;
    }
}

class CarFactory extends VehicleFactory {
    Vehicle createVehicle(String model, int year) {
        return new Car(model, year);
    }
}

class MotorcycleFactory extends VehicleFactory {
    Vehicle createVehicle(String model, int year) {
        return new Motorcycle(model, year);
    }
}

class TruckFactory extends VehicleFactory {
    Vehicle createVehicle(String model, int year) {
        return new Truck(model, year);
    }
}

public class VehicleManufacturingFactory {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        VehicleFactory truckFactory = new TruckFactory();
        
        // Manufacturing different vehicles
        carFactory.manufactureVehicle("Car", "Honda Civic", 2023);
        System.out.println();
        
        motorcycleFactory.manufactureVehicle("Motorcycle", "Harley Davidson", 2023);
        System.out.println();
        
        truckFactory.manufactureVehicle("Truck", "Ford F-150", 2023);
    }
}
