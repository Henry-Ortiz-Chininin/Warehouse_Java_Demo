package com.alphacoders.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.MovementDTO;
import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.exception.ResourceNotFoundException;
import com.alphacoders.backend.model.InMovement;
import com.alphacoders.backend.model.Movement;
import com.alphacoders.backend.model.OutMovement;
import com.alphacoders.backend.repository.MovementRepository;


@RestController
@RequestMapping("/api/v1/")
public class MovementController {
	
	@Autowired
	private MovementRepository movementRepository;
	
	@GetMapping("/movements")
	public List<Movement> getAllMovements(){
		return (List<Movement>) movementRepository.findAll();
	}
	
	//create movement rest api
	@PostMapping("/newMovement")
	public ResultDTO addUser(@RequestBody MovementDTO movement) {
		ResultDTO result = new ResultDTO();
		result.Data = movement;
		
		try {
			if(movement.type.equals("IN")) {
				InMovement in = new InMovement();
				in.setDate(movement.date);
				movementRepository.save(in);
				result.Status="OK";
			}
			if(movement.type.equals("OUT")) {
				OutMovement out = new OutMovement();
				out.setDate(movement.date);
				movementRepository.save(out);
				result.Status="OK";
			}
		} catch (Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}
		return result;
	}
	
	@GetMapping("/movements/{id}")
	public ResponseEntity<ResultDTO> getWarehouseById(@PathVariable Long id){
		ResultDTO result = new ResultDTO();
		
		Optional<Movement> mov = movementRepository.findById(id);
		
		try {
			if(mov != null) {
				result.Data = mov;
				result.Status = "OK";
			}
		} catch (Exception e) {
			result.Status = "EX";
			result.Data = mov;
		}
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/movements/{id}")
	public ResponseEntity<ResultDTO> updateMovementById(@PathVariable Long id, @RequestBody MovementDTO movementDetail){
		ResultDTO result = new ResultDTO();
		
		//Search movement based on the id.
		Movement movement = movementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no movement found with id: " + id));
		
		//assign values to our DTO
		result.Data = movement;
		
		//try update
		try {
			if(movement != null) {
				//update movement
				result.Status = "OK";
				movement.setDate(movementDetail.date);
				movementRepository.save(movement);
				result.Data = movement;
			}
		} catch (Exception ex) {
			result.Status = "EX";
			result.Error = ex;
		}
		
		return ResponseEntity.ok(result);
	}

}
