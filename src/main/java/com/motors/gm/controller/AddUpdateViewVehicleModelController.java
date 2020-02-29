package com.motors.gm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motors.gm.model.VehicleModel;
import com.motors.gm.repository.VehicleModelAddUpdateViewRepository;
import com.motors.gm.service.VehicleModelAddUpdateViewService;

@RestController
@RequestMapping(path = "/addUpdateViewAsset")
public class AddUpdateViewVehicleModelController {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	VehicleModelAddUpdateViewService vehicleModelAddUpdateViewService;

	// @Autowired
	// VehicleAddUpdateViewRepository vehicleAddUpdateViewRepository;

	// Save method will call service save method to add new vehicle into DB
	@PostMapping(path = "/addVehicle", produces = "application/json")
	public String save(@RequestBody VehicleModel vehicleModel) {
		vehicleModelAddUpdateViewService.saveVehicle(vehicleModel);
		return "Save Success";
	}

	// update method will call service update method to update the existing
	// vehicle in DB
	@PutMapping(path = "/updateVehicle/{regNumber}", produces = "application/json")
	public String update(@RequestBody VehicleModel vehicleModel, @PathVariable String regNumber) {
		vehicleModelAddUpdateViewService.updateVehicle(vehicleModel, regNumber);
		return "Update Success";
	}

	// delete method will call service delete method to delete the existing
	// vehicle in DB
	// TO-DO need to create new project for Delete
	@DeleteMapping(path = "/deleteVehicle/{regNumber}", produces = "application/json")
	public String deleteVehicle(@PathVariable String regNumber) {
		return vehicleModelAddUpdateViewService.deleteVehicle(regNumber);
	}

	// findAllVehicle method will call service findAllVehicle method to findAll
	// existing vehicles in DB
	@GetMapping(path = "/findAllVehicle", produces = "application/json")
	public List<VehicleModel> findAllVehicleDetails() {
		System.out.println("Below are the all available cars: \n " + vehicleModelAddUpdateViewService.findAllVehicle());
		return vehicleModelAddUpdateViewService.findAllVehicle();
	}

	// findVehicleByRegNumber method will call service findVehicleByRegNumber
	// method to findVehicleByRegNumber in DB
	@GetMapping(path = "/findVehicleByRegNumber/{regNumber}", produces = "application/json")
	public List<VehicleModel> findByRegNumberVehicleDetails(@PathVariable String regNumber) {
		System.out.println("Below are the all available cars: \n "
				+ vehicleModelAddUpdateViewService.findVehicleByRegNumber(regNumber));
		return vehicleModelAddUpdateViewService.findVehicleByRegNumber(regNumber);
	}

	// findVehicleByFeatures method will call service findVehicleByFeatures
	// method to findVehicleByFeatures provided by user in DB
	@GetMapping(path = "/findVehicleByFeatures", produces = "application/json")
	public List<VehicleModel> findVehicleByFeaturesVehicleDetails(@RequestBody VehicleModel vehicleModel) {
		System.out.println("Below are the all available cars: \n "
				+ vehicleModelAddUpdateViewService.findVehicleByFeaturesVehicleDetails(vehicleModel));
		return vehicleModelAddUpdateViewService.findVehicleByFeaturesVehicleDetails(vehicleModel);
	}
}
