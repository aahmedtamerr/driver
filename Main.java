import java.time.Instant;
import java.util.UUID;

enum reviewstatus
{
    PENDING,
    APPROVED,
    REJECTED

}
class review {
    private final String id;
    private final String tripid;
    private final String riderid;
    private final String driverid;
    private final int rating;
    private final String comment;
    private boolean flagged;
    private final Instant createdat;
    private Instant updatedat;
    private reviewstatus status;

    public review(String tripId, String riderId, String driverId, int rating, String comment) {
        this.id = UUID.randomUUID().toString();
        this.tripid = tripId;
        this.rating = rating;
        this.riderid = riderId;
        this.driverid = driverId;
        this.comment = comment;
        this.status = reviewstatus.PENDING;
        this.flagged = false;
        this.createdat = Instant.now();
        this.updatedat = Instant.now();
        System.out.println("the trip id is " + this.tripid);
        System.out.println("the rider id is " + this.riderid);
        System.out.println("the driver id " + this.driverid);
        System.out.println("the rating of the driver " + this.rating);
        System.out.println("the comment " + this.comment);
    }

    public reviewstatus getstatus() {
        return status;
    }

    void approve()
    {
        if(this.status==reviewstatus.PENDING) {
            this.status = reviewstatus.APPROVED;
            this.updatedat = Instant.now();
            System.out.println("the status has been approved ");
        }
        else
            System.out.println("the orderr has not approved ");

    }

    void reject() {
        if(this.status == reviewstatus.PENDING || this.status == reviewstatus.APPROVED)
        {
            this.status=reviewstatus.REJECTED;
            this.updatedat = Instant.now();
            System.out.println("the order is rejected ");
        }
    }

    void flag() {
        this.flagged=true;
        this.updatedat=Instant.now();
    }
}

public static void main(String[] args)
{}
