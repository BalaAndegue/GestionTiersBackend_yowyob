package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.*;
import com.backend.yowyob.services.TiersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commerciaux")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CommercialController {
    private final TiersService tiersService;
    
    @PostMapping
    public ResponseEntity<CommercialDTO> createCommercial(@RequestBody CommercialDTO commercialDTO) {
        return ResponseEntity.ok(tiersService.createCommercial(commercialDTO));
    }
    
    // Autres endpoints...
}
