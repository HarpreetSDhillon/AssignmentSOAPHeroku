package com.mycompany.assignmentsoapservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-06T15:15:25")
@StaticMetamodel(Library.class)
public class Library_ { 

    public static volatile SingularAttribute<Library, String> cast;
    public static volatile SingularAttribute<Library, byte[]> thumbnail;
    public static volatile SingularAttribute<Library, String> director;
    public static volatile SingularAttribute<Library, BigInteger> rating;
    public static volatile SingularAttribute<Library, String> description;
    public static volatile SingularAttribute<Library, BigDecimal> id;
    public static volatile SingularAttribute<Library, String> title;
    public static volatile SingularAttribute<Library, String> type;
    public static volatile SingularAttribute<Library, String> category;
    public static volatile SingularAttribute<Library, Date> releasedon;

}