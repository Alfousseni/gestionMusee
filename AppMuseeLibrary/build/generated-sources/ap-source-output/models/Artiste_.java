package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Oeuvre;
import models.User;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-06T20:09:21")
@StaticMetamodel(Artiste.class)
public class Artiste_ { 

    public static volatile SingularAttribute<Artiste, String> nationalite;
    public static volatile SingularAttribute<Artiste, String> biographie;
    public static volatile ListAttribute<Artiste, Oeuvre> oeuvreList;
    public static volatile SingularAttribute<Artiste, User> iDuser;
    public static volatile SingularAttribute<Artiste, Date> datenaissance;
    public static volatile SingularAttribute<Artiste, Integer> id;
    public static volatile SingularAttribute<Artiste, String> nom;
    public static volatile SingularAttribute<Artiste, String> email;

}