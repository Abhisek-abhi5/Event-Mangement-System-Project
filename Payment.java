public class Payment {
    private int id;
    private int bookingId;
    private double amount;
    private String status;

    public Payment(int id, int bookingId, double amount, String status) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and setters
}