package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Basvuru;
import com.eticaret.onlinecv.entity.Ilanteknoloji;
import com.eticaret.onlinecv.entity.Sirket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Ilan.class)
public class Ilan_ { 

    public static volatile SingularAttribute<Ilan, Date> ilanbittarihi;
    public static volatile SingularAttribute<Ilan, Integer> ilanID;
    public static volatile ListAttribute<Ilan, Ilanteknoloji> ilanteknolojiList;
    public static volatile SingularAttribute<Ilan, Sirket> sirketID;
    public static volatile ListAttribute<Ilan, Basvuru> basvuruList;
    public static volatile SingularAttribute<Ilan, String> ilanaciklama;
    public static volatile SingularAttribute<Ilan, Date> ilanbastarihi;
    public static volatile SingularAttribute<Ilan, String> ilanbaslik;

}