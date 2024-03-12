package Job.App.Job.App.Service;

import Job.App.Job.App.Model.Job;

import java.util.List;


public interface Service {

    List<Job> findAllJobs();

    void createJob(Job job);

    Job findSingleJob(Long id);

    Boolean deleteJob(Long id);

    Boolean updateJob(Long id, Job updatedJob);

}
