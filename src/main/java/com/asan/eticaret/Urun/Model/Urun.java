package com.asan.eticaret.Urun.Model;

import com.asan.eticaret.Urun.EnumKategori.EnumKategori;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Data
@ToString(exclude = {"id"})
public class Urun implements Serializable {

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
    private EnumKategori kategori;



}
