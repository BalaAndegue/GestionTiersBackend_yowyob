package com.backend.yowyob.controllers;



import com.backend.yowyob.dtos.*;
import com.backend.yowyob.services.TiersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TiersController {
    
    private final TiersService tiersService;
    
    // Endpoints communs
    @GetMapping
    public ResponseEntity<List<TiersBaseDTO>> getAllTiers() {
        return ResponseEntity.ok(tiersService.findAllTiers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TiersBaseDTO> getTiersById(@PathVariable Long id) {
        return ResponseEntity.ok(tiersService.findTiersById(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTiers(@PathVariable Long id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }
}


// Controllers similaires pour Fournisseur, Commercial, Prospect...



