package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Teknoloji;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Kullaniciteknoloji.class)
public class Kullaniciteknoloji_ { 

    public static volatile SingularAttribute<Kullaniciteknoloji, Integer> idkullaniciteknoloji;
    public static volatile SingularAttribute<Kullaniciteknoloji, Teknoloji> teknolojiID;
    public static volatile SingularAttribute<Kullaniciteknoloji, Kullanici> kullaniciID;

}