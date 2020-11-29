package com.asan.eticaret.Urun.Model;

import com.asan.eticaret.User.Model.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Favori implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_urun", foreignKey = @ForeignKey(name = "FK_Favori_User"))
    private Urun urun;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_User_Favori"))
    private User user;
}

