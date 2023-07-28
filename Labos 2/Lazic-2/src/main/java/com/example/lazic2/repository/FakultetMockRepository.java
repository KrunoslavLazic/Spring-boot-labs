package com.example.lazic2.repository;

import com.example.lazic2.domain.Fakultet;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class FakultetMockRepository implements FakultetRepository{

    private List<Fakultet> fakulteti;

    public FakultetMockRepository(){
        fakulteti = new ArrayList<>();
        fakulteti.add(new Fakultet("TVZ","Zagreb","123456789",1450,BigDecimal.valueOf(4.1),true));
        fakulteti.add(new Fakultet("FER","Zagreb","123123123",2500,BigDecimal.valueOf(3.91),true));
        fakulteti.add(new Fakultet("Algebra","Zagreb","321321321",1100,BigDecimal.valueOf(2.5),false));
        fakulteti.add(new Fakultet("FERIT","Osijek","123321123",700,BigDecimal.valueOf(3.011),true));
        fakulteti.add(new Fakultet("FOI","Varaždin","091091091",500, BigDecimal.valueOf(3.1),true));
    }

    @Override
    public List<Fakultet> findAll() {
        return fakulteti;
    }

    @Override
    public Optional<Fakultet> findFakultetByOIB(String oib) {
        return fakulteti.stream()
                .filter(f -> f.getOib().equals(oib))
                .findAny();
    }

    @Override
    public void deleteByOIB(String oib) {
        fakulteti.removeIf( f -> f.getOib().equals(oib));
    }

    @Override
    public Optional<Fakultet> save(Fakultet fakultet) {
        fakulteti.add(fakultet);
        return Optional.ofNullable(fakultet);
    }
}
