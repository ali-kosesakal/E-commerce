package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Ilanteknoloji;
import com.eticaret.onlinecv.entity.Kullaniciteknoloji;
import com.eticaret.onlinecv.entity.Projeteknoloji;
import com.eticaret.onlinecv.entity.Sirketteknoloji;
import com.eticaret.onlinecv.entity.Sprojetek;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Teknoloji.class)
public class Teknoloji_ { 

    public static volatile SingularAttribute<Teknoloji, String> aciklama;
    public static volatile ListAttribute<Teknoloji, Kullaniciteknoloji> kullaniciteknolojiList;
    public static volatile ListAttribute<Teknoloji, Ilanteknoloji> ilanteknolojiList;
    public static volatile ListAttribute<Teknoloji, Sprojetek> sprojetekList;
    public static volatile SingularAttribute<Teknoloji, Integer> teknolojiID;
    public static volatile SingularAttribute<Teknoloji, String> teknolojiadi;
    public static volatile ListAttribute<Teknoloji, Sirketteknoloji> sirketteknolojiList;
    public static volatile SingularAttribute<Teknoloji, Projeteknoloji> projeteknoloji;

}