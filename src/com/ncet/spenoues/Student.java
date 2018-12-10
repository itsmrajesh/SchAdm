package com.ncet.spenoues;
	public class Student {
	private String studentName;
	private int studentId;
	private String fatherName;
	private String motherName;
	private String contact;
	private int schoolAdmittedTo;

	Student(String studentName,int studentId,String fatherName,String motherName,String contact,int schoolAdmittedTo){
		this.studentName=studentName;
		this.studentId=studentId;
		this.fatherName=fatherName;
		this.motherName=motherName;
		this.contact=contact;
		this.schoolAdmittedTo=schoolAdmittedTo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getSchoolAdmittedTo() {
		return schoolAdmittedTo;
	}
	public void setSchoolAdmittedTo(int  schoolAdmittedTo) {
		this.schoolAdmittedTo = schoolAdmittedTo;
	}

	public void print() {
		System.out.println("*****************");
		System.out.println("Stuent name    : "+studentName);
		System.out.println("Student ID     :"+studentId);
		System.out.println("Father name    : "+fatherName);
		System.out.println("Mother name    : "+motherName);
		System.out.println("Contact Number : "+contact);
		System.out.println("Student is Admitted School With School ID :"+schoolAdmittedTo);
		System.out.println("*******************");
	}
	}
