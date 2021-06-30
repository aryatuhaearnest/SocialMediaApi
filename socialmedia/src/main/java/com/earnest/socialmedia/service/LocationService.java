package com.earnest.socialmedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earnest.socialmedia.model.Location;
import com.earnest.socialmedia.repository.LocationRepository;

@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;
	

	

	public Location createLocation(Location location) {
		return locationRepository.save(location);
	}
	
	public Location getById(int id) {
	Optional <Location> locationOp =locationRepository.findById(id);
		
			if(locationOp.isPresent()) {
				return locationOp.get();
			}
		
		return null;
	}
	
	
	public List<Location> getLocations() {
		Iterable<Location> locationI =locationRepository.findAll();
		List<Location> locations = new ArrayList<Location>();
		locationI.forEach((location) -> locations.add(location));
		return locations;
		
	}
	
	public void deleteLocation(Location location) {
	
		if(location != null)
			locationRepository.delete(location);
	}
	
	public void deleteLocationById(int id) {
		locationRepository.deleteById(id);
	}
	
	public Location updateLocationById(int id ,  Location location) {
		Location locationToUpdate = locationRepository.findById(id).get();
	
		if(locationToUpdate != null) {
			locationToUpdate.setName(location.getName());
			locationToUpdate=locationRepository.save(locationToUpdate);
		}
		return locationToUpdate;
	}
	
	public Location updateLocation(Location location) {
		Location locationToUpdate = locationRepository.findById(location.getId()).get();		
		
		if(locationToUpdate != null) {
			locationToUpdate.setName(location.getName());
			
			locationToUpdate=locationRepository.save(locationToUpdate);
		}
		return locationToUpdate;
	}

}
