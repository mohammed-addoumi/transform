package ma.cdgk.transform.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contenu {

    private List<Operation> operations;

    @XmlElement(name="operation")
    public List<Operation> getOperations() {
        return operations;
    }
}
