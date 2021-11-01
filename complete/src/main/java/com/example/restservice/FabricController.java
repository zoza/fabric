package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.api.AllocateCellRequest;
import com.example.restservice.api.AllocateCellResponse;
import com.example.restservice.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class FabricController {

	@Autowired
	private StorageService service;


	@PostMapping(value = "/allocateCell",consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public AllocateCellResponse postFabric(@RequestBody AllocateCellRequest req) {
		// logs
		return service.allocateCell(req);
	}
}
