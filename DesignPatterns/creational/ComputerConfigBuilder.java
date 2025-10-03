// Java Example: Builder Pattern (Creational)
// Use Case: Computer Configuration System

class Computer {
    private String processor;
    private String memory;
    private String storage;
    private String graphicsCard;
    private boolean hasWiFi;
    private boolean hasBluetooth;
    
    private Computer() {} // Private constructor
    
    public static class ComputerBuilder {
        private Computer computer = new Computer();
        
        public ComputerBuilder setProcessor(String processor) {
            computer.processor = processor;
            return this;
        }
        
        public ComputerBuilder setMemory(String memory) {
            computer.memory = memory;
            return this;
        }
        
        public ComputerBuilder setStorage(String storage) {
            computer.storage = storage;
            return this;
        }
        
        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            computer.graphicsCard = graphicsCard;
            return this;
        }
        
        public ComputerBuilder addWiFi() {
            computer.hasWiFi = true;
            return this;
        }
        
        public ComputerBuilder addBluetooth() {
            computer.hasBluetooth = true;
            return this;
        }
        
        public Computer build() {
            // Validate required components
            if (computer.processor == null || computer.memory == null || computer.storage == null) {
                throw new IllegalStateException("Computer must have processor, memory, and storage!");
            }
            return computer;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer Configuration:\n");
        sb.append("- Processor: ").append(processor).append("\n");
        sb.append("- Memory: ").append(memory).append("\n");
        sb.append("- Storage: ").append(storage).append("\n");
        if (graphicsCard != null) {
            sb.append("- Graphics Card: ").append(graphicsCard).append("\n");
        }
        sb.append("- WiFi: ").append(hasWiFi ? "Yes" : "No").append("\n");
        sb.append("- Bluetooth: ").append(hasBluetooth ? "Yes" : "No").append("\n");
        return sb.toString();
    }
}

public class ComputerConfigBuilder {
    public static void main(String[] args) {
        // Gaming Computer
        Computer gamingPC = new Computer.ComputerBuilder()
            .setProcessor("Intel i9-13900K")
            .setMemory("32GB DDR5")
            .setStorage("1TB NVMe SSD")
            .setGraphicsCard("RTX 4080")
            .addWiFi()
            .addBluetooth()
            .build();
            
        System.out.println("=== Gaming PC ===");
        System.out.println(gamingPC);
        
        // Office Computer
        Computer officePC = new Computer.ComputerBuilder()
            .setProcessor("Intel i5-12400")
            .setMemory("16GB DDR4")
            .setStorage("512GB SSD")
            .addWiFi()
            .build();
            
        System.out.println("=== Office PC ===");
        System.out.println(officePC);
        
        // Budget Computer
        Computer budgetPC = new Computer.ComputerBuilder()
            .setProcessor("AMD Ryzen 5 5600G")
            .setMemory("8GB DDR4")
            .setStorage("256GB SSD")
            .build();
            
        System.out.println("=== Budget PC ===");
        System.out.println(budgetPC);
    }
}
