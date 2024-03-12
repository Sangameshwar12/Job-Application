package Job.App.Job.App.Controller;

import Job.App.Job.App.Exception.JobNotFoundException;
import Job.App.Job.App.Model.Job;
import Job.App.Job.App.Service.ServiceImpl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class JobController {

    @Autowired
   private JobServiceImpl jobService;


    @GetMapping("/jobs")
    public List<Job> findAllJobs(){

        return jobService.findAllJobs();
    }

    @PostMapping("/add_jobs")
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> findSingleJob(@PathVariable Long id) throws JobNotFoundException {
        Job job = jobService.findSingleJob(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete_a_Job/{id}")
    public ResponseEntity<String> deleteAJob(@PathVariable Long id){

        boolean deleted = jobService.deleteJob(id);
        if(deleted){
            return new ResponseEntity<>("Job deleted successfuly", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateJob/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){

        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("job details updated", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    
}
