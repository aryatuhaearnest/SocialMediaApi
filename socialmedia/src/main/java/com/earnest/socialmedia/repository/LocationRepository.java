package com.earnest.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.earnest.socialmedia.model.Location;
import com.earnest.socialmedia.model.User;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
}
