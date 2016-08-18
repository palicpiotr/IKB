package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Article;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-18T07:06:50")
@StaticMetamodel(Articletype.class)
public class Articletype_ { 

    public static volatile SingularAttribute<Articletype, Integer> idType;
    public static volatile ListAttribute<Articletype, Article> articleList;
    public static volatile SingularAttribute<Articletype, String> name;

}