package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Billet;
import models.User;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-07-08T18:00:22")
@StaticMetamodel(Visiteur.class)
public class Visiteur_ { 

    public static volatile SingularAttribute<Visiteur, User> iDuser;
    public static volatile SingularAttribute<Visiteur, Date> datenaissance;
    public static volatile SingularAttribute<Visiteur, Integer> id;
    public static volatile ListAttribute<Visiteur, Billet> billetList;
    public static volatile SingularAttribute<Visiteur, String> nom;
    public static volatile SingularAttribute<Visiteur, String> prenom;
    public static volatile SingularAttribute<Visiteur, String> email;

}