package ma.cdgk.transform.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlType(propOrder = {"datePosition","devise","avoirBilan","engagementBilan","avoirSpotHorsBilan",
                     "avoirTermeHorsBilan","engagementSpoHorsBilan","engagementTermeHorsBilan",
                     "couverturePositionOptionnelle", "equivalentDelta","totalPosition","contreValeurPosition",
                      "fondPropre" })
public class Operation {

    private String datePosition;
    private String devise;
    private String avoirBilan;
    private String engagementBilan;
    private String avoirSpotHorsBilan;
    private String avoirTermeHorsBilan;
    private String engagementSpoHorsBilan;
    private String engagementTermeHorsBilan;
    private String couverturePositionOptionnelle;
    private String equivalentDelta;
    private String totalPosition;
    private String contreValeurPosition;
    private String fondPropre;

}
