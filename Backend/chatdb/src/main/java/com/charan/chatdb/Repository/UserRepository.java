package com.charan.chatdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charan.chatdb.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
