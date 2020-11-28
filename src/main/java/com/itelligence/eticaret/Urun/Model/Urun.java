package com.itelligence.eticaret.Urun.Model;

import com.itelligence.eticaret.Urun.EnumModel.EnumModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@ToString(exclude = {"id"})
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
    @Column
    private Double fiyat;
    @Column
    private String marka;
    @Column
    private  String model;
    @Column
    private Date eklenmeTarihi;
    @Enumerated(EnumType.STRING)
    private EnumModel kategori;



}
