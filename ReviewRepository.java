import java.util.List;
public interface ReviewRepository {
    void save(Review review);
    Review findById(String id);
    List<Review> findByDriverId(String driverId);
    List<Review> findByRiderId(String riderId);
    List<Review> findByTripId(String tripId);
    List<Review> findByStatus(ReviewStatus status);
    List<Review> findAll();
    boolean existsByTripIdAndRiderId(String tripId, String riderId);
    void delete(String id);
}
// Note
// Use this in implementation to simulate you having a database
private Map<String, Review> database = new HashMap<>();
@Override public Review findById(String id) { return database.get(id); }
@Override public void save(Review review) { database.put(review.getId(),
        review); }

void main() {
}