public class Booking {
    private int id;
    private int eventId;
    private int userId;
    private boolean isPaid;

    public Booking(int id, int eventId, int userId, boolean isPaid) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.isPaid = isPaid;
    }

    // Getters and setters
}