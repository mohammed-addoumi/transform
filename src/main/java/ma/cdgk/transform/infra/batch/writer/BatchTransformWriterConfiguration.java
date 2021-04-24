package ma.cdgk.transform.infra.batch.writer;

import java.io.File;
import java.time.LocalDateTime;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ma.cdgk.transform.domain.Declaration;

@Configuration
public class BatchTransformWriterConfiguration {
	
	
	public static final String WRITER_NAME = "batchTransformWriter";
	
	@Bean(name = WRITER_NAME)
	@JobScope
	public CustomStaxEventItemWriter<Declaration> TransformWriter() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Declaration.class);
		CustomStaxEventItemWriter<Declaration> customStaxEventItemWriter =
				new CustomStaxEventItemWriter<>();
		customStaxEventItemWriter.setName(WRITER_NAME);
		customStaxEventItemWriter.setVersion("1.0");
		customStaxEventItemWriter.setResource(new FileSystemResource(new File("results/result-"+LocalDateTime.now().withNano(0).toString()+".xml")));
		customStaxEventItemWriter.setMarshaller(marshaller);
		return customStaxEventItemWriter;
	}
	}

