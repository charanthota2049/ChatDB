package com.charan.chatdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charan.chatdb.Model.User;


public interface UserRepository extends JpaRepository<User,Long> {
    
}
