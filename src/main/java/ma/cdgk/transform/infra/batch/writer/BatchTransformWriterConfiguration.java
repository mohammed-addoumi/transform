package ma.cdgk.transform.infra.batch.writer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ma.cdgk.transform.domain.Declaration;

@Configuration
public class BatchTransformWriterConfiguration {
	
	public static final String WRITER_NAME = "batchTransformWriter";
	
	@Bean(name = WRITER_NAME)
	public ItemWriter<Declaration> TransformWriter() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Declaration.class);
		CustomStaxEventItemWriter<Declaration> customStaxEventItemWriter =
				new CustomStaxEventItemWriter<>();
		customStaxEventItemWriter.setName(WRITER_NAME);
		customStaxEventItemWriter.setVersion("1.0");
		customStaxEventItemWriter.setResource(new FileSystemResource(new File("result.xml")));
		customStaxEventItemWriter.setMarshaller(marshaller);
		return customStaxEventItemWriter;
	}
	}

