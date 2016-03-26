package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Ilan;
import com.eticaret.onlinecv.entity.Sirketozbilgi;
import com.eticaret.onlinecv.entity.Sirketproje;
import com.eticaret.onlinecv.entity.Sirketteknoloji;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Sirket.class)
public class Sirket_ { 

    public static volatile SingularAttribute<Sirket, Integer> sirketID;
    public static volatile SingularAttribute<Sirket, String> parola;
    public static volatile ListAttribute<Sirket, Ilan> ilanList;
    public static volatile ListAttribute<Sirket, Sirketproje> sirketprojeList;
    public static volatile SingularAttribute<Sirket, Date> songirtarihi;
    public static volatile SingularAttribute<Sirket, String> email;
    public static volatile ListAttribute<Sirket, Sirketteknoloji> sirketteknolojiList;
    public static volatile ListAttribute<Sirket, Sirketozbilgi> sirketozbilgiList;

}