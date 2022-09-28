package com.example.RegistryWeb.repository;

import com.example.RegistryWeb.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    //Custom query
    @Query(value = "select * from person s where s.first_name like %:keyword% or s.occupation like %:keyword%", nativeQuery = true)
    List<Person> findByKeyword(@Param("keyword") String keyword);
}

