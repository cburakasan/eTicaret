package com.itelligence.eticaret.Urun.Service;

import com.itelligence.eticaret.Urun.Model.Urun;
import com.itelligence.eticaret.Urun.Repository.UrunRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UrunServiceTest {
    @Autowired
    UrunRepository urunRepository;

    @Test
    @Rollback(value = false)
    public void testUrunSave(){
        Urun urun = new Urun();
        urun.setModel("casper");
        urun = urunRepository.save(urun);
        assertNotNull(urun);
    }

    @Test
    public void testUrunFindById(){
        String model ="casper";
        Optional<Urun> urun = urunRepository.findById(1l);
        Urun urun1 = urun.get();
        String getModelDb = urun1.getModel();
        assertEquals(getModelDb,model);



    }



}