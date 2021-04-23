package ma.cdgk.transform.infra.batch.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.stereotype.Component;


import ma.cdgk.transform.domain.Declaration;
import ma.cdgk.transform.infra.utils.DeclarationAlimMock;

@Component("batchTransformReader")
public class DeclarationItemReader implements ItemReader<Declaration> {
	
	private IteratorItemReader<Declaration> delegateReader;
	
	
	@BeforeStep
	private void beforeStep(StepExecution stepExecution) {	
		List<Declaration> list = new ArrayList<>();
		list.add(DeclarationAlimMock.aliment());
		delegateReader = new IteratorItemReader<>(list);
		
	}

	@Override
	public Declaration read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return delegateReader.read();
	}

}
