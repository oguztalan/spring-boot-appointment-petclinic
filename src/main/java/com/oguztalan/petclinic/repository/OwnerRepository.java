package com.oguztalan.petclinic.repository;

import com.oguztalan.petclinic.model.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<OwnerEntity, Long> {
    List<OwnerEntity> findAll();
}
