package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Bolum;
import com.eticaret.onlinecv.entity.Kullaniciozbilgi;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Universite.class)
public class Universite_ { 

    public static volatile SingularAttribute<Universite, Bolum> bolumID;
    public static volatile SingularAttribute<Universite, Integer> universiteID;
    public static volatile SingularAttribute<Universite, String> okuladi;
    public static volatile ListAttribute<Universite, Kullaniciozbilgi> kullaniciozbilgiList;

}