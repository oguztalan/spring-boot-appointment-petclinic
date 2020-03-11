package com.oguztalan.petclinic.service;

import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.model.OwnerEntity;
import com.oguztalan.petclinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    public List<OwnerEntity> getAllOwners(){
        List<OwnerEntity> result = (List<OwnerEntity>) ownerRepository.findAll();

        if (result.size() > 0 )
            return  result;
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
                newEntity.setPhoneNumber(entity.getPhoneNumber());

                newEntity = ownerRepository.save(newEntity);

                return newEntity;
            }
            else {
                entity = ownerRepository.save(entity);

                return entity;
            }
        }
    }

}
