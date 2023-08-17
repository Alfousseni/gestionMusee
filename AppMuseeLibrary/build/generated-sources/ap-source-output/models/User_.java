package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Artiste;
import models.Billet;
import models.Exposition;
import models.Oeuvre;
import models.Visiteur;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-06T20:09:21")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> role;
    public static volatile ListAttribute<User, Oeuvre> oeuvreList;
    public static volatile ListAttribute<User, Exposition> expositionList;
    public static volatile ListAttribute<User, Artiste> artisteList;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile ListAttribute<User, Billet> billetList;
    public static volatile ListAttribute<User, Visiteur> visiteurList;
    public static volatile SingularAttribute<User, String> etat;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}