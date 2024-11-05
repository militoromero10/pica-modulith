package com.sw.modulith.biker;

import com.sw.modulith.biker.dto.BikerDto;
import com.sw.modulith.biker.dto.BikerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/biker")
public class BikerController {

    private final BikerService bikerService;

    @PostMapping
    public ResponseEntity<BikerResponseDto> createBiker(@RequestBody BikerDto bikerDto){
        return new ResponseEntity<>(bikerService.createBiker(bikerDto), HttpStatus.CREATED);
    }
}
