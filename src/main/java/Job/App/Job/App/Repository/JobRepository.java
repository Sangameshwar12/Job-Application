package Job.App.Job.App.Repository;

import Job.App.Job.App.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
