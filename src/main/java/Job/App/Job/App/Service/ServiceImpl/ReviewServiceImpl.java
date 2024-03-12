package Job.App.Job.App.Service.ServiceImpl;

import Job.App.Job.App.Model.Company;
import Job.App.Job.App.Model.Review;
import Job.App.Job.App.Repository.ReviewRepository;
import Job.App.Job.App.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReviewsById(Long id) {
        List<Review> reviews = reviewRepository.findAllByCompanyId(id);
        return reviews;
    }
}
