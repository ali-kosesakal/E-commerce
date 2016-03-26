package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Proje;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Kullaniciproje.class)
public class Kullaniciproje_ { 

    public static volatile SingularAttribute<Kullaniciproje, Integer> idkullaniciproje;
    public static volatile SingularAttribute<Kullaniciproje, Proje> projeID;
    public static volatile SingularAttribute<Kullaniciproje, Kullanici> kullaniciID;

}