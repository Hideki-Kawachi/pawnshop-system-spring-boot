package com.hideki.pawnshopSystem.controller;

import com.hideki.pawnshopSystem.dto.PawnDTO;
import com.hideki.pawnshopSystem.model.Pawn;
import com.hideki.pawnshopSystem.service.PawnService;
import com.hideki.pawnshopSystem.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pawn")
public class PawnController {
    @Autowired
    private PawnService pawnService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<?>> add(@RequestBody PawnDTO pawnRequest){
        try {

            PawnDTO newPawnDTO = pawnService.createPawn(pawnRequest.principal(), pawnRequest.startDate());
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<PawnDTO>("Successfully created pawn",newPawnDTO));
        }
        catch (Exception e){
            ApiResponse<?> response = new ApiResponse<>("Error while creating the pawn: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<?>> getAllPawn(){
        try {
            ApiResponse<List<Pawn>> response = new ApiResponse<>("Successfully retrieved all pawn",pawnService.getAllPawn());
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<?> response = new ApiResponse<>("Error while fetching all pawn", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<?>> getPawnByID(@PathVariable Integer id){
        try {
            Optional<Pawn> fetchedPawn = pawnService.getPawnByID(id);
            if(fetchedPawn.isEmpty()){
                ApiResponse<Optional<Pawn>> response= new ApiResponse<>("Error in retrieving pawn");
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
            }
            ApiResponse<Pawn> response = new ApiResponse<>("Successfully retrieved pawn", fetchedPawn.get());
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<?> response = new ApiResponse<>("Error in retrieving pawn" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
