package com.studentmanagement.restapi;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "name", nullable = false)
    private String studentName;

    @Column(name = "email", nullable = false, unique = true)
    private String studentEmail;

    @Column(name = "marks", precision = 5, scale = 2)
    private BigDecimal marks;

    public Student() {}

    public Student(Long studentId, String studentName, String studentEmail, BigDecimal marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.marks = marks;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public BigDecimal getMarks() {
        return marks;
    }

    public void setMarks(BigDecimal marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId +
               ", studentName=" + studentName +
               ", studentEmail=" + studentEmail +
               ", marks=" + marks + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentEmail, studentId, studentName, marks);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Student))
            return false;
        Student other = (Student) obj;
        return Objects.equals(studentEmail, other.studentEmail) &&
               Objects.equals(studentId, other.studentId) &&
               Objects.equals(studentName, other.studentName) &&
               Objects.equals(marks, other.marks);
    }

	public Object getCourse() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCourse(Object course) {
		// TODO Auto-generated method stub
		
	}
}
