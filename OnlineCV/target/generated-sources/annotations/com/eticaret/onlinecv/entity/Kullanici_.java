package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Basvuru;
import com.eticaret.onlinecv.entity.Kullanicidil;
import com.eticaret.onlinecv.entity.Kullaniciozbilgi;
import com.eticaret.onlinecv.entity.Kullaniciproje;
import com.eticaret.onlinecv.entity.Kullaniciteknoloji;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Kullanici.class)
public class Kullanici_ { 

    public static volatile ListAttribute<Kullanici, Kullanicidil> kullanicidilList;
    public static volatile ListAttribute<Kullanici, Kullaniciteknoloji> kullaniciteknolojiList;
    public static volatile ListAttribute<Kullanici, Kullaniciproje> kullaniciprojeList;
    public static volatile SingularAttribute<Kullanici, String> parola;
    public static volatile ListAttribute<Kullanici, Basvuru> basvuruList;
    public static volatile SingularAttribute<Kullanici, Date> songirtarihi;
    public static volatile SingularAttribute<Kullanici, String> email;
    public static volatile ListAttribute<Kullanici, Kullaniciozbilgi> kullaniciozbilgiList;
    public static volatile SingularAttribute<Kullanici, Integer> kullaniciID;

}