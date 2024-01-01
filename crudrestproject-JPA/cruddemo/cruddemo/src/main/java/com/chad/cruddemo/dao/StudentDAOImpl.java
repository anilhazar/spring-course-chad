package com.chad.cruddemo.dao;

import com.chad.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist( theStudent );
    }

    public Student findById(Long id) {
        return entityManager.find( Student.class, id );

    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery( "FROM Student ", Student.class );
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery( "FROM Student WHERE lastName= :theData ", Student.class );
        theQuery.setParameter( "theData", lastName );
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void update(Student student) {
        entityManager.merge( student );
    }

   @Transactional
    public void updateAllStudents(String thelastName){
        int numsRowsUpdated = entityManager.createQuery( "UPDATE Student SET lastName=:theData")
                .setParameter("theData", thelastName)
                .executeUpdate();

    }
@Transactional
    public void delete(Student student, Long studentId){
        Student studentToDelete = entityManager.find(Student.class, studentId);
        entityManager.remove( studentToDelete );
    }
@Transactional
    public int deleteAllStudents(){
       return entityManager.createQuery( "DELETE FROM Student" ).executeUpdate();
    }
}
