package com.example.lazic2.service;

import com.example.lazic2.domain.Fakultet;
import com.example.lazic2.domain.FakultetCommand;
import com.example.lazic2.domain.FakultetDTO;
import com.example.lazic2.domain.StudentCommand;

import java.util.List;
import java.util.Optional;

public interface FakultetService {

    List<FakultetDTO> findAll();

    Optional<FakultetDTO> findFakultetByOIB(String oib);

    void deleteByOIB(String oib);

    Optional<FakultetDTO> save(FakultetCommand command);


}
