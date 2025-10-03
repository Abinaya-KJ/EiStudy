# 🚀 Quick Reference Guide

## 📂 Repository Structure
```
designpatterns/
├── README.md                    # Main documentation
├── QUICK_REFERENCE.md          # This file
├── .gitignore                  # Git ignore rules
├── creational/                 # Creational patterns
│   ├── README.md
│   ├── VehicleManufacturingFactory.java
│   └── ComputerConfigBuilder.java
├── structural/                 # Structural patterns
│   ├── README.md
│   ├── CoffeeShopDecorator.java
│   └── MediaPlayerAdapter.java
└── behavioral/                 # Behavioral patterns
    ├── README.md
    ├── YouTubeObserverSystem.java
    └── PaymentSystemStrategy.java
```

## ⚡ Quick Commands

### Run Any Pattern
```bash
# Navigate to pattern folder
cd creational    # or structural, behavioral

# Compile and run
javac PatternFile.java
java PatternFile
```

### Examples
```bash
# Factory Pattern
cd creational
javac VehicleManufacturingFactory.java
java VehicleManufacturingFactory

# Observer Pattern  
cd behavioral
javac YouTubeObserverSystem.java
java YouTubeObserverSystem
```

## 📋 Pattern Cheat Sheet

| Pattern | Type | Problem | Solution |
|---------|------|---------|----------|
| **Factory Method** | Creational | Object creation flexibility | Delegate creation to subclasses |
| **Builder** | Creational | Complex object construction | Step-by-step building process |
| **Decorator** | Structural | Add behavior dynamically | Wrap objects with decorators |
| **Adapter** | Structural | Interface incompatibility | Convert one interface to another |
| **Observer** | Behavioral | Notify multiple objects | Subject-observer relationship |
| **Strategy** | Behavioral | Multiple algorithms | Encapsulate algorithms in classes |

## 🎯 Study Tips

1. **Start with README.md** - Get the big picture
2. **Read folder READMEs** - Understand pattern categories  
3. **Run examples** - See patterns in action
4. **Modify code** - Try adding new features
5. **Compare patterns** - Understand when to use each

## 🔍 Key Concepts to Focus On

- **SOLID Principles** implementation
- **Loose coupling** between objects
- **Open/Closed Principle** - open for extension, closed for modification
- **Composition over inheritance**
- **Interface segregation**

## 📚 Recommended Study Order

1. **Factory Method** (easiest to understand)
2. **Strategy** (common and practical)
3. **Observer** (event-driven programming)
4. **Builder** (complex object creation)
5. **Decorator** (dynamic behavior)
6. **Adapter** (integration patterns)
