package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Billet;
import models.OeuvresExposition;
import models.User;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-06T20:09:21")
@StaticMetamodel(Exposition.class)
public class Exposition_ { 

    public static volatile SingularAttribute<Exposition, Float> prix_vip;
    public static volatile ListAttribute<Exposition, OeuvresExposition> oeuvresExpositionList;
    public static volatile SingularAttribute<Exposition, User> iDuser;
    public static volatile SingularAttribute<Exposition, String> heurDebut;
    public static volatile SingularAttribute<Exposition, String> heurFin;
    public static volatile SingularAttribute<Exposition, Date> datedebut;
    public static volatile SingularAttribute<Exposition, String> description;
    public static volatile SingularAttribute<Exposition, Float> prix_clssique;
    public static volatile SingularAttribute<Exposition, Date> datefin;
    public static volatile SingularAttribute<Exposition, Integer> id;
    public static volatile ListAttribute<Exposition, Billet> billetList;
    public static volatile SingularAttribute<Exposition, String> nom;

}