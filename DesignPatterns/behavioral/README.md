# Behavioral Design Patterns

Behavioral patterns focus on **communication between objects** and the assignment of responsibilities between objects.

## 👁️ Observer Pattern
**File:** `YouTubeObserverSystem.java`

### Problem Solved
- Need to notify multiple objects about state changes in another object
- Want to maintain loose coupling between objects
- Need to support broadcast communication

### Key Components
- **Subject** (`YouTubeChannel`) - Maintains list of observers and notifies them of changes
- **Observer** (`Observer` interface) - Defines updating interface for objects that should be notified
- **Concrete Observer** (`Subscriber`) - Implements observer interface and maintains reference to subject

### Real-world Use Case
YouTube channel subscription system where subscribers get notified when new videos are uploaded.

### How to Run
```bash
javac YouTubeObserverSystem.java
java YouTubeObserverSystem
```

---

## 🎯 Strategy Pattern
**File:** `PaymentSystemStrategy.java`

### Problem Solved
- Need to define family of algorithms and make them interchangeable
- Want to vary algorithms independently from clients that use them
- Need to eliminate conditional statements for selecting algorithms

### Key Components
- **Strategy** (`PaymentStrategy`) - Common interface for all concrete strategies
- **Concrete Strategies** (`CreditCardPayment`, `PayPalPayment`, `BankTransferPayment`) - Implement different algorithms
- **Context** (`PaymentProcessor`) - Uses strategy interface to call algorithm defined by concrete strategy

### Real-world Use Case
Payment processing system that supports multiple payment methods (Credit Card, PayPal, Bank Transfer).

### How to Run
```bash
javac PaymentSystemStrategy.java
java PaymentSystemStrategy
```

## 🎯 When to Use Behavioral Patterns

| Pattern | Use When |
|---------|----------|
| Observer | You need to notify multiple objects about events without making objects tightly coupled |
| Strategy | You have multiple ways to perform a task and want to choose the algorithm at runtime |

## 💡 Key Benefits
- **Loose Coupling** - Objects interact without knowing much about each other
- **Flexibility** - Easy to add new behaviors without modifying existing code
- **Responsibility Distribution** - Clear assignment of responsibilities between objects
- **Runtime Behavior** - Can change behavior at runtime based on conditions
