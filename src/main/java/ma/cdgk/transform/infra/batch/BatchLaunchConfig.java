package ma.cdgk.transform.infra.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class BatchLaunchConfig {


    private final JobLauncher jobLauncher;


    @Qualifier("batchTransformJob")
    private final Job batchTransformJob;

    @Scheduled(cron = "0 */1 * * * ?")
    public void scheduleTransformJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("date-time",LocalDateTime.now().toString())
                .toJobParameters();
        jobLauncher.run(batchTransformJob,jobParameters);
    }
}
