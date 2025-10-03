# Design Patterns in Java

This repository demonstrates various **Design Patterns** implemented in Java with practical examples and use cases.

## 📁 Repository Structure

### 🏗️ Creational Patterns
- **Factory Method Pattern** - `VehicleManufacturingFactory.java`
  - *Use Case*: Vehicle Manufacturing System (Car, Motorcycle, Truck factories)
  - *Key Concepts*: Abstract factory, concrete factories, product hierarchy

- **Builder Pattern** - `ComputerConfigBuilder.java`
  - *Use Case*: Computer Configuration System
  - *Key Concepts*: Step-by-step object construction, fluent interface

### 🔧 Structural Patterns
- **Decorator Pattern** - `CoffeeShopDecorator.java`
  - *Use Case*: Coffee Shop Ordering System
  - *Key Concepts*: Dynamic behavior addition, composition over inheritance

- **Adapter Pattern** - `MediaPlayerAdapter.java`
  - *Use Case*: Media Player System (Legacy to Modern adapter)
  - *Key Concepts*: Interface compatibility, legacy system integration

### 🎭 Behavioral Patterns
- **Observer Pattern** - `YouTubeObserverSystem.java`
  - *Use Case*: YouTube Channel Subscription System
  - *Key Concepts*: Event notification, loose coupling

- **Strategy Pattern** - `PaymentSystemStrategy.java`
  - *Use Case*: Payment Processing System
  - *Key Concepts*: Algorithm encapsulation, runtime behavior switching

## 🚀 How to Run

### Prerequisites
- Java 8 or higher
- Any Java IDE or command line

### Compilation & Execution
```bash
# Compile any pattern example
javac PatternFileName.java

# Run the example
java PatternFileName
```

### Example Commands
```bash
# Factory Pattern
javac VehicleManufacturingFactory.java
java VehicleManufacturingFactory

# Observer Pattern
javac YouTubeObserverSystem.java
java YouTubeObserverSystem

# Strategy Pattern
javac PaymentSystemStrategy.java
java PaymentSystemStrategy
```

## 📋 Pattern Details

| Pattern | Type | Use Case | Key Benefits |
|---------|------|----------|--------------|
| Factory Method | Creational | Vehicle Manufacturing | Object creation flexibility |
| Builder | Creational | Computer Configuration | Complex object construction |
| Decorator | Structural | Coffee Shop Orders | Dynamic feature addition |
| Adapter | Structural | Media Player | Legacy system integration |
| Observer | Behavioral | YouTube Notifications | Event-driven communication |
| Strategy | Behavioral | Payment Processing | Algorithm interchangeability |

## 🎯 Learning Objectives

Each example demonstrates:
- ✅ **SOLID Principles** adherence
- ✅ **Clean Code** practices
- ✅ **Real-world use cases**
- ✅ **Proper OOP implementation**
- ✅ **Design pattern best practices**

## 📖 Study Guide

### For Each Pattern:
1. **Understand the Problem** - What issue does this pattern solve?
2. **Identify Components** - What are the key classes/interfaces?
3. **Trace the Flow** - How do objects interact?
4. **Consider Alternatives** - When would you use this vs other patterns?
5. **Practice Implementation** - Try modifying the examples

### Recommended Study Order:
1. **Factory Method** (Simple creation pattern)
2. **Builder** (Complex object construction)
3. **Strategy** (Behavior switching)
4. **Observer** (Event handling)
5. **Decorator** (Feature enhancement)
6. **Adapter** (Interface compatibility)

## 🔍 Code Quality Features

- **Comprehensive Comments** - Each file includes detailed explanations
- **Real-world Examples** - Practical use cases you might encounter
- **Clean Architecture** - Proper separation of concerns
- **Error Handling** - Robust implementation practices
- **Extensible Design** - Easy to add new features

## 📚 Additional Resources

- [Design Patterns: Elements of Reusable Object-Oriented Software](https://en.wikipedia.org/wiki/Design_Patterns)
- [Java Design Patterns](https://java-design-patterns.com/)
- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)

---

*This repository serves as a comprehensive reference for understanding and implementing design patterns in Java. Each example is self-contained and can be run independently.*
