package com.oguztalan.petclinic.service.impl;

import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.entities.OwnerEntity;
import com.oguztalan.petclinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public List<OwnerEntity> listAllOwners(){
        List<OwnerEntity> result = ownerRepository.findAll();

        if (result.size() > 0 ) {
            Collections.reverse(result);
            return result;
        }
        else
            return new ArrayList<OwnerEntity>();

    }

    public OwnerEntity getOwnerById(Long id) throws RecordNotFoundException {
        Optional<OwnerEntity> owner = ownerRepository.findById(id);
        if (owner.isPresent())
            return owner.get();
        else
            throw new RecordNotFoundException("Verilen id ile kayıt bulunamadı!");
    }

    public OwnerEntity createOrUpdateOwner(OwnerEntity entity){

        if (entity.getId() == null){
            entity = ownerRepository.save(entity);
            return entity;
        }
        else {
            Optional<OwnerEntity> owner = ownerRepository.findById(entity.getId());

            if (owner.isPresent()){
                OwnerEntity newEntity = owner.get();
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());
                newEntity.setEmail(entity.getEmail());

                newEntity = ownerRepository.save(newEntity);

                return newEntity;
            }
            else {
                entity = ownerRepository.save(entity);

                return entity;
            }
        }
    }

    public void deleteOwnerById(Long id)throws RecordNotFoundException{

        Optional<OwnerEntity> owner = ownerRepository.findById(id);

        if (owner.isPresent()){
            ownerRepository.deleteById(id);
        }else {
            throw new RecordNotFoundException("Verilen id ile bir kayıt bulunamadı!");
        }
    }

}
