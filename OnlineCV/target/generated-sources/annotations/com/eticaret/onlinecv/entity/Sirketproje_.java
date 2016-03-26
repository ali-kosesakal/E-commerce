package com.eticaret.onlinecv.entity;

import com.eticaret.onlinecv.entity.Sirket;
import com.eticaret.onlinecv.entity.Sprojetek;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T12:12:08")
@StaticMetamodel(Sirketproje.class)
public class Sirketproje_ { 

    public static volatile SingularAttribute<Sirketproje, String> aciklama;
    public static volatile SingularAttribute<Sirketproje, String> projeadi;
    public static volatile ListAttribute<Sirketproje, Sprojetek> sprojetekList;
    public static volatile SingularAttribute<Sirketproje, Sirket> sirketID;
    public static volatile SingularAttribute<Sirketproje, Integer> sirketprojeID;

}