package com.backend.yowyob.controllers;


import com.backend.yowyob.dtos.*;
import com.backend.yowyob.services.TiersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prospects")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProspectController {
    private final TiersService tiersService;
    
    @PostMapping
    public ResponseEntity<ProspectDTO> createProspect(@RequestBody ProspectDTO prospectDTO) {
        return ResponseEntity.ok(tiersService.createProspect(prospectDTO));
    }
    
    // Autres endpoints...
}
