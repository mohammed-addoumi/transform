package ma.cdgk.transform.infra.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BatchTransformConfiguration {
	
	public static final String JOB_NAME = "batchTransformJob";
	private final JobBuilderFactory jobBuilderFactory;
	
	@Qualifier("batchTransformStep")
	private final Step step;
	
	@Bean(name = JOB_NAME)
	public Job TransformJob() {
		return jobBuilderFactory
				.get("TRANSFORM BATCH")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	
	

}
