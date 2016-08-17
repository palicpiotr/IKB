package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Articletype;
import models.Comments;
import models.Complain;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T22:39:21")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile ListAttribute<Article, Comments> commentsList;
    public static volatile SingularAttribute<Article, Integer> idArticle;
    public static volatile SingularAttribute<Article, String> articleName;
    public static volatile SingularAttribute<Article, Articletype> idType;
    public static volatile ListAttribute<Article, Complain> complainList;
    public static volatile SingularAttribute<Article, Date> addingDate;
    public static volatile SingularAttribute<Article, String> content;

}