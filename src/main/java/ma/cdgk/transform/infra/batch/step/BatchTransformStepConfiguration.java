package ma.cdgk.transform.infra.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;
import ma.cdgk.transform.domain.Declaration;

@Configuration
@RequiredArgsConstructor
public class BatchTransformStepConfiguration {
	
	public static final String STEP_NAME = "batchTransformStep";
	

	@Qualifier("batchTransformReader")
	private final ItemReader<Declaration> batchTransformItemReader;
	
	@Qualifier("batchTransformWriter")
	private final ItemWriter<Declaration> batchTransformItemWriter;
	
	private final PlatformTransactionManager transactionManager;
	
	private final StepBuilderFactory stepBuilderFactory;
	
	
	@Bean(name = STEP_NAME)
	public Step transformStep() {
		return stepBuilderFactory
				.get("BATCH TRANSFORM STEP")
				.transactionManager(transactionManager)
				.<Declaration,Declaration>chunk(1)
				.reader(batchTransformItemReader)
				.writer(batchTransformItemWriter)
				.build();
				
	}
	
	

}
