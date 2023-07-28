package com.example.lazic2.controller;

import com.example.lazic2.domain.FakultetCommand;
import com.example.lazic2.domain.FakultetDTO;
import com.example.lazic2.service.FakultetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fakultet")
@AllArgsConstructor
public class FakultetRestController {

    private FakultetService fakultetService;

    @GetMapping("/all")
    public List<FakultetDTO> getAllFakulteti(){
        return fakultetService.findAll();
    }

    @GetMapping("oib")
    public ResponseEntity<FakultetDTO> getFakultetByOIB(String oib){
        return fakultetService.findFakultetByOIB(oib)
                .map(
                        fakultetDTO -> ResponseEntity
                                .status(HttpStatus.ACCEPTED)
                                .body(fakultetDTO)
                )
                .orElseGet(
                        ()->ResponseEntity
                                .status(HttpStatus.NO_CONTENT)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<FakultetDTO> save(@Valid @RequestBody final FakultetCommand command){
        return fakultetService.save(command)
                .map(
                        fakultetDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(fakultetDTO)
                )
                .orElseGet(
                        ()->ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{oib}")
    public void delete(@PathVariable String oib){
        fakultetService.deleteByOIB(oib);
    }

}
