package com.oguztalan.petclinic.service.impl;

import com.oguztalan.petclinic.entities.OwnerEntity;
import com.oguztalan.petclinic.entities.User;
import com.oguztalan.petclinic.entities.UserRole;
import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.repository.UserRepository;
import com.oguztalan.petclinic.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userRoleRepository")
    private UserRoleRepository userRoleRepository;

    public List<User> listAllUsers(){
        List<User> result = userRepository.findAll();
        if (result.size() > 0) {
            return result;
        }
        else
            return new ArrayList<>();
    }

    public User getUserById(Long id) throws RecordNotFoundException {
        Optional<User> users = userRepository.findById(id);
        if (users.isPresent())
            return users.get();
        else
            throw new RecordNotFoundException("Verilen id ile bir kayıt bulunamadı!");
    }

    public void deleteUserById(Long id)throws RecordNotFoundException{

        Optional<User> entity = userRepository.findById(id);
        Integer roleid = entity.get().getId().intValue();
        if (entity.isPresent()){
            userRoleRepository.deleteByUsernameId(roleid);
            userRepository.deleteById(id);
        }else {
            throw new RecordNotFoundException("Verilen id ile bir kayıt bulunamadı!");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
        return buildUser(user, authorities);
    }

    private org.springframework.security.core.userdetails.User buildUser(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

        for (UserRole role : userRoles) {
            auths.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }

    public com.oguztalan.petclinic.model.User createUser(com.oguztalan.petclinic.model.User user) throws RecordNotFoundException {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User userEntity = toEntity(user);

        User usr = userRepository.findByUsername(userEntity.getUsername());
        if (usr != null && (usr.getUsername().equals(userEntity.getUsername()))) {
            throw new RecordNotFoundException("Bu Kullanıcı adı mevcut Lütfen başka bir kullanıcı adı girin");
        }
        else {
            User userCreated = userRepository.save(userEntity);
            userRoleRepository.save(new UserRole(userCreated, "admin"));
            return toModel(userCreated);
        }
    }

    public User updateUser(User entity){

        Optional<User> users = userRepository.findById(entity.getId());
            if (users.isPresent()) {
                User newUser = users.get();
                newUser.setId(entity.getId());
                newUser.setUsername(entity.getUsername());
                newUser.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));

                newUser = userRepository.save(newUser);
                return newUser;
            }
            else {
                return null;
            }





    }

    public User toEntity(com.oguztalan.petclinic.model.User user) {
        User entity = new User();

        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setActive(user.isActive());

        return entity;
    }

    public com.oguztalan.petclinic.model.User toModel(User user) {
        com.oguztalan.petclinic.model.User model = new com.oguztalan.petclinic.model.User();

        model.setUsername(user.getUsername());
        model.setPassword(user.getPassword());
        model.setActive(user.isActive());

        return model;
    }






}
