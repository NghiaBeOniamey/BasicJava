package com.oniamey.server.repository;

import com.oniamey.server.entity.Student;
import com.oniamey.server.model.response.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = """
        SELECT
            s.id as id,
            s.name as name,
            s.code as code
        FROM student s
    """, nativeQuery = true)
    List<StudentResponse> getStudents();

}
