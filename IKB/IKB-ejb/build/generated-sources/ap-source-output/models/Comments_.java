package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Article;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-25T12:22:00")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Integer> idComment;
    public static volatile SingularAttribute<Comments, Article> idArticle;
    public static volatile SingularAttribute<Comments, Date> addingDateComment;
    public static volatile SingularAttribute<Comments, String> commentAuthor;
    public static volatile SingularAttribute<Comments, String> commentContent;

}