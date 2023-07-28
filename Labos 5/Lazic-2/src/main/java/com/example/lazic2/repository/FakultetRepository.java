package com.example.lazic2.repository;

import com.example.lazic2.domain.Fakultet;
import com.example.lazic2.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FakultetRepository {

    List<Fakultet> findAll();

    Optional<Fakultet> findFakultetByOIB(String oib);

    void deleteByOIB(String oib);

    Optional<Fakultet> save(Fakultet fakultet);

}
