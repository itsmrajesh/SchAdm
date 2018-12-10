package com.ncet.spenoues;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class School implements Serializable{
	private String Schoolname;
	private String Schoolboard;
	private String contactNumber;
	private int SchoolId;
	private int classNumber;
	private int totalstrength[];
	private int totalSeats;
	private int currentStrength[];
	ArrayList<School>school=new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static Scanner sc1= new Scanner(System.in);
        File f = new File("obj.txt");
	public School() {

	}
	public School(String schoolname, String schoolboard, String contactNumber, int schoolId,int totalstrength[],
			int currentStrength[] ,int totalSeats) {

		this.Schoolname = schoolname;
		this.Schoolboard = schoolboard;
		this.contactNumber = contactNumber;
		this.SchoolId = schoolId;
		this.classNumber = classNumber;
		this.totalstrength=totalstrength;
		this.currentStrength = currentStrength;
        this.totalSeats = totalSeats;
	}
	public String getSchoolname() {
		return Schoolname;
	}
	public void setSchoolname(String schoolname) {
		Schoolname = schoolname;
	}
	public String getSchoolboard() {
		return Schoolboard;
	}
	public void setSchoolboard(String schoolboard) {
		Schoolboard = schoolboard;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getSchoolId() {
		return SchoolId;
	}
	public void setSchoolId(int schoolId) {
		SchoolId = schoolId;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int[]  getCurrentStrength() {
		return currentStrength;
	}
	public void setCurrentStrength(int currentStrength[]) {
		this.currentStrength = currentStrength;

	}	
	public static void compute(int id)throws InvalidException
	{
		if(id<10000 || id>999)
		{
			throw new InvalidException(id);
		}
	}
	
	public void print()
	{
		System.out.println("****************");
		System.out.println("School Name:"+Schoolname);
		System.out.println("School Id:"+SchoolId);
		System.out.println("School Contact Number:"+contactNumber);
		System.out.println("School Board:"+Schoolboard);
		System.out.println("School Totalseats:"+totalSeats);
		System.out.println("*****************");
	}

}
