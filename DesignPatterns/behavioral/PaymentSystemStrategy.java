// Java Example: Strategy Pattern (Behavioural)
// Use Case: Payment Processing System with different payment methods

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    
    CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }
    
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card ending in " + cardNumber.substring(cardNumber.length()-4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    
    PayPalPayment(String email) {
        this.email = email;
    }
    
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}

class BankTransferPayment implements PaymentStrategy {
    private String accountNumber;
    
    BankTransferPayment(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Bank Transfer from account: " + accountNumber);
    }
}

class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    
    void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    void processPayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

public class PaymentSystemStrategy {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        
        // Credit Card Payment
        processor.setPaymentStrategy(new CreditCardPayment("1234567890123456", "John Doe"));
        processor.processPayment(99.99);
        
        // PayPal Payment
        processor.setPaymentStrategy(new PayPalPayment("john@example.com"));
        processor.processPayment(149.50);
        
        // Bank Transfer Payment
        processor.setPaymentStrategy(new BankTransferPayment("ACC-789456123"));
        processor.processPayment(299.00);
    }
}
