package com.example.identitymanagement.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.identitymanagement.model.concretes.User;

//JpaRepository'e extend edip Entity anatosyonu ile süslenmiş table ı parametre olarak veriyoruz ve primary key tipini belirtiyoruz.
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
