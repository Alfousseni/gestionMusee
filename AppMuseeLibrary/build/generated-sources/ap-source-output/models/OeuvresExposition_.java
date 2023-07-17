package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Exposition;
import models.Oeuvre;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-07-08T18:00:22")
@StaticMetamodel(OeuvresExposition.class)
public class OeuvresExposition_ { 

    public static volatile SingularAttribute<OeuvresExposition, Exposition> iDExposition;
    public static volatile SingularAttribute<OeuvresExposition, Integer> id;
    public static volatile SingularAttribute<OeuvresExposition, Oeuvre> iDOeuvre;

}