package com.hideki.pawnshopSystem.controller;

import com.hideki.pawnshopSystem.model.Pawn;
import com.hideki.pawnshopSystem.service.PawnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pawn")
public class PawnController {
    @Autowired
    private PawnService pawnService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Pawn pawn){
        try {
            pawnService.createPawn(pawn.getPrincipal(), pawn.getStartDate());
            return ResponseEntity.ok("Pawn created successfully");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating the pawn");
        }


    }
}
