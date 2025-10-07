package com.polatavci.repository;

import com.polatavci.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
       @Query(value = """
       SELECT *
       FROM student
       WHERE CURRENT_DATE - date_of_birth > (:age * 365)
       """, nativeQuery = true)
     */
    @Query(value = """
       SELECT * FROM student WHERE EXTRACT(YEAR FROM AGE(CURRENT_DATE, date_of_birth)) > :age 
       """, nativeQuery = true) // ":age" parametre olan age'i alır, nativeQuery = true sql sorgusu yapmayı sağlar, false olursa HQL (Hibernate query language)
    List<Student> getStudentsGreaterThanAge(Integer age);

    List<Student> getStudentsByName(String name);
}
