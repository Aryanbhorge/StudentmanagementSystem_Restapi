package com.studentmanagement.restapi;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Studentservice {
@Autowired
private final StudentRepository stdRepo;


public Studentservice(StudentRepository stdRepo) {
	this.stdRepo = stdRepo;
}

public Student getEmployeeById(Long id) {
	return stdRepo.findById(id).orElse(null);
}


public List<Student> getAllStd(){
	return stdRepo.findAll();
}

// add new emp

public void addStd(Student std) {
	stdRepo.save(std);
}

//update emp

public void updateEmp(Student std) {
	stdRepo.save(std);
}

// delete emp by id

public void deleteStd(Long id) {
	stdRepo.deleteById(id);
}

public Student getStudentById(Long id) {
	// TODO Auto-generated method stub
	return null;
}

public void updateStudent(Student existing) {
	// TODO Auto-generated method stub
	
}

}


