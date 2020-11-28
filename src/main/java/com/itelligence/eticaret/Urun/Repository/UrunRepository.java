package com.itelligence.eticaret.Urun.Repository;

import com.itelligence.eticaret.Urun.Model.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends JpaRepository <Urun,Long> {

}
