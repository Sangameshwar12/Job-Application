package Job.App.Job.App.Service.ServiceImpl;

import Job.App.Job.App.Model.Job;
import Job.App.Job.App.Repository.JobRepository;
import Job.App.Job.App.Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class JobServiceImpl implements Service {

//    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    private Long updateId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Job> findAllJobs() {

        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

       job.setId(updateId++);

        jobRepository.save(job);
    }


    @Override
    public Job findSingleJob(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJob(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

           if(jobOptional.isPresent() ){
               Job job = jobOptional.get();
               job.setDescription(updatedJob.getDescription());
               job.setLocation(updatedJob.getLocation());
               job.setTitle(updatedJob.getTitle());
               job.setMaxSalary(updatedJob.getMaxSalary());
               job.setMinSalary(updatedJob.getMinSalary());
               jobRepository.save(job);
               return true;
           }

        return false;
    }


}
