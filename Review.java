import java.time.Instant;
import java.util.UUID;

enum ReviewStatus {
    PENDING,
    APPROVED,
    REJECTED
}

class Review {
    private final String id;
    private final String tripId;
    private final String riderId;
    private final String driverId;
    private final int rating;
    private final String comment;
    private boolean flagged;
    private final Instant createdAt;
    private Instant updatedAt;
    private ReviewStatus status;
    public Review(String tripId, String riderId, String driverId, int rating, String comment) {
        this.id = UUID.randomUUID().toString();
        this.tripId = tripId;
        this.riderId = riderId;
        this.driverId = driverId;
        this.rating = rating;
        this.comment = comment;
        this.status = ReviewStatus.PENDING;
        this.flagged = false;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();

        System.out.println("Trip ID: " + this.tripId);
        System.out.println("Rating: " + this.rating);
    }
    public String getId() {
        return id;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getTripId() {
        return tripId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }


    public ReviewStatus getStatus() {
        return status;
    }

    void approve() {
        if (this.status == ReviewStatus.PENDING) {
            this.status = ReviewStatus.APPROVED;
            this.updatedAt = Instant.now();
            System.out.println("Status has been approved.");
        } else {
            System.out.println("Review cannot be approved (current status: " + this.status + ")");
        }
    }

    void reject() {

        if (this.status != ReviewStatus.REJECTED) {
            this.status = ReviewStatus.REJECTED;
            this.updatedAt = Instant.now();
            System.out.println("Review has been rejected.");
        }
    }

    void flag() {
        this.flagged = true;
        this.updatedAt = Instant.now();
        System.out.println("Review has been flagged.");
    }
}