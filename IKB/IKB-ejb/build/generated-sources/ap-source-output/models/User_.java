package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Usergroups;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-18T03:47:54")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Usergroups> usergroupsList;
    public static volatile SingularAttribute<User, String> username;

}