public enum Priority {
    HIGH,
    MEDIUM,
    LOW;

    public static Priority fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Priority cannot be null");
        }
        switch (value.trim().toLowerCase()) {
            case "high":
                return HIGH;
            case "medium":
                return MEDIUM;
            case "low":
                return LOW;
            default:
                throw new IllegalArgumentException("Invalid priority level. Allowed: High, Medium, Low");
        }
    }
}


