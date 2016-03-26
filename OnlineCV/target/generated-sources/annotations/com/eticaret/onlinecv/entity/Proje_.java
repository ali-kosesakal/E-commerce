package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Kullaniciproje;
import com.eticaret.onlinecv.entity.Projeteknoloji;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Proje.class)
public class Proje_ { 

    public static volatile SingularAttribute<Proje, Integer> projeID;
    public static volatile SingularAttribute<Proje, String> aciklama;
    public static volatile SingularAttribute<Proje, String> projeadi;
    public static volatile ListAttribute<Proje, Kullaniciproje> kullaniciprojeList;
    public static volatile SingularAttribute<Proje, Projeteknoloji> projeteknoloji;

}