package ma.cdgk.transform.infra.utils;

import java.util.ArrayList;

import ma.cdgk.transform.domain.Contenu;
import ma.cdgk.transform.domain.Declaration;
import ma.cdgk.transform.domain.Identifiant;
import ma.cdgk.transform.domain.Operation;

public class DeclarationAlimMock {

    public static Declaration aliment(){
        Declaration declaration = new Declaration();
        Identifiant identifiant = new Identifiant();
        identifiant.setFlux("1");
        identifiant.setCompartiment("01");
        identifiant.setEtablissementDeclaran("RDGCMAMR");
        identifiant.setDateDeclaration("20042021");
        identifiant.setNbreEnregistrements("11");
        identifiant.setTypeCompartiment("01");


        Contenu contenu = new Contenu();
        contenu.setOperations(new ArrayList<>());
        Operation operation = new Operation();
        operation.setDatePosition("20042021");
        operation.setDevise("AED");
        operation.setAvoirBilan("1039.10");
        operation.setEngagementBilan("0.00");
        operation.setAvoirSpotHorsBilan("0.00");
        operation.setAvoirTermeHorsBilan("0.00");
        operation.setEngagementSpoHorsBilan("0.00");
        operation.setEngagementTermeHorsBilan("0.00");
        operation.setCouverturePositionOptionnelle("0");
        operation.setEquivalentDelta("0");
        operation.setTotalPosition("1039.10");
        operation.setContreValeurPosition("2521.58");
        operation.setFondPropre("921342117.00");


        contenu.getOperations().add(operation);
        contenu.getOperations().add(operation);
        contenu.getOperations().add(operation);

        declaration.setIdentifiant(identifiant);
        declaration.setContenu(contenu);
        return declaration;
    }
}
