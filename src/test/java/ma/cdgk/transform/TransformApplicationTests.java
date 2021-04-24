package ma.cdgk.transform;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransformApplicationTests {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void TransformJob_Should_Create_Result_File() throws JobExecutionAlreadyRunningException, 
	JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("date-time",LocalDateTime.now().toString())
                .toJobParameters();
		jobLauncher.run(job,jobParameters);
	}

}
