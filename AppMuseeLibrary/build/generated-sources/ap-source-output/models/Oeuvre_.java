package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Artiste;
import models.OeuvresExposition;
import models.User;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-07-08T18:00:22")
@StaticMetamodel(Oeuvre.class)
public class Oeuvre_ { 

    public static volatile SingularAttribute<Oeuvre, Artiste> iDArtiste;
    public static volatile ListAttribute<Oeuvre, OeuvresExposition> oeuvresExpositionList;
    public static volatile SingularAttribute<Oeuvre, User> iDuser;
    public static volatile SingularAttribute<Oeuvre, String> description;
    public static volatile SingularAttribute<Oeuvre, Float> prixestime;
    public static volatile SingularAttribute<Oeuvre, Integer> id;
    public static volatile SingularAttribute<Oeuvre, Integer> annee;
    public static volatile SingularAttribute<Oeuvre, String> nom;

}