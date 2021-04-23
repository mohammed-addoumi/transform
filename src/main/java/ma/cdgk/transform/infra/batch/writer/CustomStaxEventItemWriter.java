package ma.cdgk.transform.infra.batch.writer;

import javanet.staxutils.IndentingXMLEventWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.Writer;

public class CustomStaxEventItemWriter<T> extends StaxEventItemWriter<T> {

    @Override
    protected XMLEventWriter createXmlEventWriter(XMLOutputFactory outputFactory, Writer writer) throws XMLStreamException {
            return new IndentingXMLEventWriter( super.createXmlEventWriter( outputFactory, writer ) );
    }

    @Override
    protected void startDocument(XMLEventWriter writer) throws XMLStreamException {
        XMLEventFactory factory = createXmlEventFactory();
        // write start document
        writer.add(factory.createStartDocument(getEncoding(), getVersion()));
    }

    @Override
    protected void endDocument(XMLEventWriter writer) throws XMLStreamException {
    }
}