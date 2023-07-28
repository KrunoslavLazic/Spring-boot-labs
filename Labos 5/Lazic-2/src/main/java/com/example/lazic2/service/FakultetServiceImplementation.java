package com.example.lazic2.service;

import com.example.lazic2.domain.Fakultet;
import com.example.lazic2.domain.FakultetCommand;
import com.example.lazic2.domain.FakultetDTO;
import com.example.lazic2.repository.FakultetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FakultetServiceImplementation implements FakultetService{

    private FakultetRepository fakultetRepository;


    @Override
    public List<FakultetDTO> findAll() {
        return fakultetRepository.findAll().stream()
                .map(this::mapFakultetToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FakultetDTO> findFakultetByOIB(String oib) {
        return fakultetRepository.findFakultetByOIB(oib).map(this::mapFakultetToDTO);
    }

    @Override
    public void deleteByOIB(String oib) {
        fakultetRepository.deleteByOIB(oib);
    }

    @Override
    public Optional<FakultetDTO> save(FakultetCommand command) {
        if (fakultetRepository.findFakultetByOIB(command.getOib()).isPresent()){
            return Optional.empty();
        }

        Fakultet fakultet = new Fakultet(
                command.getName(),
                command.getCity(),
                command.getOib(),
                command.getNumberOfStudents(),
                command.getAverageGrade(),
                command.isFree()
        );

        return fakultetRepository.save(fakultet).map(this::mapFakultetToDTO);

    }

    private FakultetDTO mapFakultetToDTO(final Fakultet fakultet){
        return new FakultetDTO(fakultet.getName(),fakultet.getCity(),fakultet.getNumberOfStudents());
    }
}
