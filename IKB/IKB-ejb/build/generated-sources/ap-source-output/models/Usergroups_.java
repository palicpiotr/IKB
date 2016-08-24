package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-24T03:03:57")
@StaticMetamodel(Usergroups.class)
public class Usergroups_ { 

    public static volatile SingularAttribute<Usergroups, Integer> idUserGroup;
    public static volatile SingularAttribute<Usergroups, String> role;
    public static volatile SingularAttribute<Usergroups, User> username;

}