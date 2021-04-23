package ma.cdgk.transform.domain;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(propOrder = {"identifiant","contenu"})
public class Declaration {
    private Identifiant identifiant;
    private Contenu contenu;
}
