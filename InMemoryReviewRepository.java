import java.util.*;

public class InMemoryReviewRepository implements ReviewRepository {
    private Map<String, Review> database = new HashMap<>();

    @Override
    public void save(Review review) {
        database.put(review.getId(), review);
    }

    @Override
    public Review findById(String id) {
        return database.get(id);
    }

    @Override
    public List<Review> findByDriverId(String driverId) {
        List<Review> results = new ArrayList<>();
        for (Review r : database.values()) {
            if (r.getDriverId().equals(driverId)) {
                results.add(r);
            }
        }
        return results;
    }

    @Override
    public List<Review> findByRiderId(String riderId) {
        List<Review> results = new ArrayList<>();
        for (Review r : database.values()) {
            if (r.getRiderId().equals(riderId)) {
                results.add(r);
            }
        }
        return results;
    }

    @Override
    public List<Review> findByTripId(String tripId) {
        List<Review> results = new ArrayList<>();
        for (Review r : database.values()) {
            if (r.getTripId().equals(tripId)) {
                results.add(r);
            }
        }
        return results;
    }

    @Override
    public List<Review> findByStatus(ReviewStatus status) {
        List<Review> results = new ArrayList<>();
        for (Review r : database.values()) {
            if (r.getStatus() == status) {
                results.add(r);
            }
        }
        return results;
    }

    @Override
    public List<Review> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public boolean existsByTripIdAndRiderId(String tripId, String riderId) {
        for (Review r : database.values()) {
            if (r.getTripId().equals(tripId) && r.getRiderId().equals(riderId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(String id) {
        database.remove(id);
    }
}
