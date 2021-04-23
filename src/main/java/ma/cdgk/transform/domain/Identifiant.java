package ma.cdgk.transform.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlType;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlType(propOrder = {"flux","compartiment","typeCompartiment","etablissementDeclaran",
                      "dateDeclaration","nbreEnregistrements"})
public class Identifiant {
    private String flux;
    private String compartiment;
    private String typeCompartiment;
    private String etablissementDeclaran;
    private String dateDeclaration;
    private String nbreEnregistrements;
}
