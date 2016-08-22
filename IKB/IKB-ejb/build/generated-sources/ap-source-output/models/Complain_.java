package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Article;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-22T04:34:15")
@StaticMetamodel(Complain.class)
public class Complain_ { 

    public static volatile SingularAttribute<Complain, Article> articleID;
    public static volatile SingularAttribute<Complain, String> type;
    public static volatile SingularAttribute<Complain, Integer> idComplain;
    public static volatile SingularAttribute<Complain, String> complainAuthor;

}