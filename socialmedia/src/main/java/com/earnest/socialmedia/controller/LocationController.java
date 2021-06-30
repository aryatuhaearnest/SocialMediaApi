package com.earnest.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.earnest.socialmedia.model.Location;
import com.earnest.socialmedia.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@PostMapping("/locations")
	public Location createLocation(@RequestBody Location location) {
		return locationService.createLocation(location);
	}
	
	@GetMapping("/locations/{id}")
	public Location getById(@PathVariable("id") int id) {
		return locationService.getById(id);
	}
	
	@GetMapping("/locations")
	public List<Location> getLocation() {
		return locationService.getLocations();
	}
	
	@DeleteMapping("/locations")
	public void deleteLocation(@RequestBody Location location) {
      locationService.deleteLocation(location);
	}
	
	@DeleteMapping("/locations/{id}")
	public void deleteLocationById(@PathVariable("id") int id) {
		locationService.deleteLocationById(id);
	}
	
	@PutMapping("/locations/{id}")
	public Location updateLocationById(@PathVariable("id") int id , @RequestBody Location location) {
		return locationService.updateLocationById(id, location);
	}
	
	@PutMapping("/locations")
	public Location updateLocation(@RequestBody Location Location) {
		return locationService.updateLocation(Location);
	}

}
