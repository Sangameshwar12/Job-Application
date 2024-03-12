package Job.App.Job.App.Controller;

import Job.App.Job.App.Model.Review;
import Job.App.Job.App.Service.ServiceImpl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyid}")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyid){
        return new ResponseEntity<>(reviewService.getAllReviewsById(companyid), HttpStatus.OK );
    }


}
