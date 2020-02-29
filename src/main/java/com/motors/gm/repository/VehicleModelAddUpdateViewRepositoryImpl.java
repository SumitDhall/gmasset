package com.motors.gm.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.motors.gm.model.VehicleModel;

@Repository
@EnableMongoRepositories
public class VehicleModelAddUpdateViewRepositoryImpl implements VehicleModelAddUpdateViewRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String saveVehicle(VehicleModel vehicleModel) {
		System.out.println("saveVehicleApacheKafka method call");
		return saveVehicleApacheKafka(vehicleModel);
		// mongoTemplate.insert(vehicleModel);
		// return "Vehicle Saved Successfully";
	}

	public String saveVehicleApacheKafka(VehicleModel vehicleModel) {
		mongoTemplate.insert(vehicleModel);
		System.out.println("Vehicle Record is saved in DB");
		return "Vehicle Saved Successfully";
	}

	public VehicleModel updateVehicle(VehicleModel vehicleModel, String regNumber) {
		// Query updateQuery = new Query();
		// updateQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		// Update update = new Update();
		// update.set("make" ,vehicleModel.getMake());
		// update.set("model" ,vehicleModel.getModel());
		return updateVehicleApacheKafka(vehicleModel, regNumber);
		// mongoTemplate.findAndModify(updateQuery, update, VehicleModel.class);

	}

	public VehicleModel updateVehicleApacheKafka(VehicleModel vehicleModel, String regNumber) {
		Query updateQuery = new Query();
		updateQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		Update update = new Update();
		update.set("make", vehicleModel.getMake());
		update.set("model", vehicleModel.getModel());
		/*
		 * TO DO - Add logic to update all the car details
		 */
		return mongoTemplate.findAndModify(updateQuery, update, VehicleModel.class);

	}

	@Override
	public List<VehicleModel> findAllVehicle() {

		System.out.println("Retrieving all vehicles available");
		return findAllVehicleApacheKafka();
	}

	public List<VehicleModel> findAllVehicleApacheKafka() {

		System.out.println("Retrieving all vehicles available");
		return mongoTemplate.findAll(VehicleModel.class);
	}

	@Override
	public List<VehicleModel> findVehicleByRegNumber(String regNumber) {

		System.out.println("Retrieving RegNumber vehicles available");
		return findVehicleByRegNumberApacheKafka(regNumber);
	}

	public List<VehicleModel> findVehicleByRegNumberApacheKafka(String regNumber) {

		System.out.println("Retrieving all vehicles available");
		Query query = new Query();
		query.addCriteria(Criteria.where("regNumber").is(regNumber));
		return mongoTemplate.find(query, VehicleModel.class);
	}

	// @Override
	// public List<VehicleModel>
	// findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel) {
	// // TODO Auto-generated method stub
	// // TODO - Implement this method
	// return null;
	// }

	// TODO - Implement this method

	@Override
	public List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel) {

		System.out.println("Retrieving vehicles with features available");
		return findVehicleByFeaturesVehicleDetailsApacheKafka(vehicleModel);
	}

	public List<VehicleModel> findVehicleByFeaturesVehicleDetailsApacheKafka(VehicleModel vehicleModel) {

		System.out.println("Retrieving all vehicles available");
		Query query = new Query();
		List<VehicleModel> resultset = null;
		Criteria criteria = new Criteria();
		if (vehicleModel.getRegNumber() != null) {
			criteria.and("regNumber").is(vehicleModel.getRegNumber());
		}
		if (vehicleModel.getMake() != null) {
			criteria.and("make").is(vehicleModel.getMake());
		}
		if (vehicleModel.getFuelType() != null) {
			criteria.and("fuelType").is(vehicleModel.getFuelType());
		}
		if (criteria != null) {
			query.addCriteria(criteria);
			resultset = mongoTemplate.find(query, VehicleModel.class);
		}
		return resultset;

	}

	public String deleteVehicle(String regNumber) {
		// Query deleteQuery = new Query();
		// deleteQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		// mongoTemplate.remove(deleteQuery, VehicleModel.class);
		return deleteVehicleApacheKafka(regNumber);
		// return "Vehicle Deleted successfully from DB";

	}

	public String deleteVehicleApacheKafka(String regNumber) {
		Query deleteQuery = new Query();
		deleteQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		mongoTemplate.remove(deleteQuery, VehicleModel.class);
		return "Vehicle Deleted successfully from DB";

	}
}
