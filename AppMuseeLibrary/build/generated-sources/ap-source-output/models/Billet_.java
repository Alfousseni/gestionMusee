package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Exposition;
import models.User;
import models.Visiteur;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-07-08T18:00:22")
@StaticMetamodel(Billet.class)
public class Billet_ { 

    public static volatile SingularAttribute<Billet, Date> dateachat;
    public static volatile SingularAttribute<Billet, User> iDuser;
    public static volatile SingularAttribute<Billet, Visiteur> iDVisiteur;
    public static volatile SingularAttribute<Billet, Exposition> iDExposition;
    public static volatile SingularAttribute<Billet, Integer> id;
    public static volatile SingularAttribute<Billet, String> typebillet;

}