# Structural Design Patterns

Structural patterns deal with **object composition**, creating relationships between objects to form larger structures.

## 🎨 Decorator Pattern
**File:** `CoffeeShopDecorator.java`

### Problem Solved
- Need to add behavior to objects dynamically without altering their structure
- Want to add responsibilities to objects without subclassing
- Need flexible alternative to inheritance for extending functionality

### Key Components
- **Component** (`Coffee`) - Common interface for objects that can have responsibilities added
- **Concrete Component** (`SimpleCoffee`) - Basic implementation
- **Decorator** (`CoffeeDecorator`) - Maintains reference to component and defines interface
- **Concrete Decorators** (`MilkDecorator`, `SugarDecorator`, `WhipDecorator`, `VanillaDecorator`) - Add specific responsibilities

### Real-world Use Case
Coffee shop ordering system where customers can add various toppings to their coffee.

### How to Run
```bash
javac CoffeeShopDecorator.java
java CoffeeShopDecorator
```

---

## 🔌 Adapter Pattern
**File:** `MediaPlayerAdapter.java`

### Problem Solved
- Need to make incompatible interfaces work together
- Want to use existing class with incompatible interface
- Need to integrate legacy systems with new systems

### Key Components
- **Target** (`MediaPlayer`) - Interface that client expects
- **Adaptee** (`LegacyPlayer`) - Existing interface that needs adapting
- **Adapter** (`MediaAdapter`) - Converts interface of adaptee to target interface
- **Client** (`MediaClient`) - Uses the target interface

### Real-world Use Case
Media player system that needs to integrate legacy audio players with modern media interfaces.

### How to Run
```bash
javac MediaPlayerAdapter.java
java MediaPlayerAdapter
```

## 🎯 When to Use Structural Patterns

| Pattern | Use When |
|---------|----------|
| Decorator | You want to add responsibilities to objects dynamically and transparently |
| Adapter | You need to use an existing class with an incompatible interface |

## 💡 Key Benefits
- **Flexibility** - Compose objects in different ways to achieve different behaviors
- **Reusability** - Existing code can be reused in new contexts
- **Separation of Concerns** - Different aspects of functionality are separated into different classes
