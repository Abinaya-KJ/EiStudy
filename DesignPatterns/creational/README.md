# Creational Design Patterns

Creational patterns deal with **object creation mechanisms**, trying to create objects in a manner suitable to the situation.

## 🏭 Factory Method Pattern
**File:** `VehicleManufacturingFactory.java`

### Problem Solved
- Need to create objects without specifying their exact classes
- Want to delegate object creation to subclasses
- Need flexibility in object creation process

### Key Components
- **Abstract Product** (`Vehicle`) - Common interface for all products
- **Concrete Products** (`Car`, `Motorcycle`, `Truck`) - Specific implementations
- **Abstract Creator** (`VehicleFactory`) - Declares factory method
- **Concrete Creators** (`CarFactory`, `MotorcycleFactory`, `TruckFactory`) - Implement factory method

### Real-world Use Case
Vehicle manufacturing system where different factories produce different types of vehicles.

### How to Run
```bash
javac VehicleManufacturingFactory.java
java VehicleManufacturingFactory
```

---

## 🏗️ Builder Pattern
**File:** `ComputerConfigBuilder.java`

### Problem Solved
- Need to construct complex objects step by step
- Want to create different representations of the same object
- Avoid telescoping constructor problem

### Key Components
- **Product** (`Computer`) - Complex object being built
- **Builder** (`ComputerBuilder`) - Interface for constructing parts
- **Director** (implicit in main method) - Constructs object using builder

### Real-world Use Case
Computer configuration system where you can build custom computers with different specifications.

### How to Run
```bash
javac ComputerConfigBuilder.java
java ComputerConfigBuilder
```

## 🎯 When to Use Creational Patterns

| Pattern | Use When |
|---------|----------|
| Factory Method | You need to create objects but don't know exact classes until runtime |
| Builder | You need to create complex objects with many optional parameters |

## 💡 Key Benefits
- **Flexibility** - Easy to add new types without changing existing code
- **Encapsulation** - Object creation logic is encapsulated
- **Reusability** - Creation logic can be reused across different contexts
