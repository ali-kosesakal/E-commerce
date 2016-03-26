package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Universite;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Kullaniciozbilgi.class)
public class Kullaniciozbilgi_ { 

    public static volatile SingularAttribute<Kullaniciozbilgi, String> ad;
    public static volatile SingularAttribute<Kullaniciozbilgi, Date> lisebastarihi;
    public static volatile SingularAttribute<Kullaniciozbilgi, Date> dtarihi;
    public static volatile SingularAttribute<Kullaniciozbilgi, String> soyad;
    public static volatile SingularAttribute<Kullaniciozbilgi, Double> agno;
    public static volatile SingularAttribute<Kullaniciozbilgi, Date> unibastarihi;
    public static volatile SingularAttribute<Kullaniciozbilgi, Universite> universiteID;
    public static volatile SingularAttribute<Kullaniciozbilgi, String> aciklama;
    public static volatile SingularAttribute<Kullaniciozbilgi, Date> unibittarihi;
    public static volatile SingularAttribute<Kullaniciozbilgi, Integer> ozbilgiID;
    public static volatile SingularAttribute<Kullaniciozbilgi, String> tel;
    public static volatile SingularAttribute<Kullaniciozbilgi, String> adres;
    public static volatile SingularAttribute<Kullaniciozbilgi, Date> lisebittarihi;
    public static volatile SingularAttribute<Kullaniciozbilgi, String> lise;
    public static volatile SingularAttribute<Kullaniciozbilgi, String> profilresim;
    public static volatile SingularAttribute<Kullaniciozbilgi, Kullanici> kullaniciID;

}