package Job.App.Job.App.Service;

import Job.App.Job.App.Model.Company;
import Job.App.Job.App.Model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviewsById(Long id);
}
