package com.ncet.spenoues;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkingOfSchool {
	boolean z = true;
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<School> school = new ArrayList<School>();
	static int arr1[] = new int[12];
	int[] arr = new int[12];
	static Scanner sc = new Scanner(System.in);
	static Scanner sc1 = new Scanner(System.in);

	public boolean AddSchool() {
		System.out.println("Enter the school Name :");
		String name = sc.next();
		while (!name.matches("[a-zA-Z]+")) {
			System.out.println("Enter the  Valid school Name :");
			name = sc.next();
		}

		int id = 0;
		boolean az = true;
		while (az) {
			try {
				System.out.println("Enter School ID :");
				id = sc1.nextInt();
				az = false;
				break;
			} catch (InputMismatchException e) {
				sc1.next();
				System.out.println("****Enter valid School ID");

			}

		}
//		School s = new School();
//		if (id < 999 || id > 10000) {
//			try {
//				s.compute(id);
//			} catch (InvalidException e) {
//				System.out.println("Exception occured id should of 4 digits " + " " + e);
//			}
//		}

		System.out.println("Enter the  SchoolBoard :");
		String board = sc.next();
		while (!(board.matches("cbse") || board.matches("icse") || board.matches("state"))) {
			System.out.println("Enter the  Valid Board Name (cbse,icse,state) :");
			board = sc.next();
		}

		String cn = null;
		System.out.println("Enter School Contact Number:");
		cn = sc.next();
		while (!cn.matches("[0-9]{10}")) {
			System.out.println("Enter valid  10 Digit Number :");
			cn = sc.next();
		}
		boolean flag = false;

		/*
		 * do {
		 * 
		 * System.out.println("Please enter the valid phone number"); String ucn =
		 * sc1.next(); flag=isValid(ucn); }while(flag!=true);
		 */
		/*
		 * System.out.println("Enter the no of class in school"); int nc = sc.nextInt();
		 */

		System.out.println("Enter the total strength for each class [1-12] ");

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the total strength for class " + (i + 1) + " : ");
			int st = sc1.nextInt();
			arr[i] = st;
		}
		System.out.println("Enter the current strength for each class ");
		for (int i = 0; (i < arr1.length) && (i < arr.length); i++) {
			boolean f = false;
			do {
				System.out.println("Enter the  current strength for class " + (i + 1) + " : ");
				int st = sc1.nextInt();
				if (st <= arr[i]) {
					arr1[i] = st;
					f = true;
				} else
					System.out.println("*****Current strength should be less then or equal to total strength");
			} while (f != true);

		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		int sum1 = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum1 += arr1[i];
		}

		int tsum = sum - sum1;

		School s1 = new School(name, board, cn, id, arr, arr1, tsum);
		school.add(s1);
		System.out.println("School Added Sucessfully with School ID : " + id);
		System.out.println("----------------------------------");
		return true;
	}

//	public static boolean isValid(String s) {
//		Pattern p = Pattern.compile("(0/91)?[7-9]{9}");
//		Matcher m = p.matcher(s);
//		return (m.find() && m.group().equals(s));
//	}

	public void ListOfSchool() {
		System.out.println("List of Schools");
		for (int i = 0; i < school.size(); i++) {
			School s = school.get(i);
			s.print();
		}

	}

	public void DeleteSchool(int id) {
		System.out.println("Deleting School with ID :" + id);
		boolean flag = false;
		School s1;
		for (int i = 0; i < school.size(); i++) {
			s1 = school.get(i);
			int myid = s1.getSchoolId();
			if (myid == id) {
				school.remove(i);
				System.out.println("School Deleted Sucessfully with ID " + id);
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("School not Found with ID :" + id);
		}
	}

	public boolean GetSchool(int id) {
		boolean flag = false;
		System.out.println("Searching School with ID : " + id);
		School s1;
		for (int i = 0; i < school.size(); i++) {
			s1 = school.get(i);
			int myid = s1.getSchoolId();
			if (myid == id) {
				
				s1.print();
				flag = true;
				return true;
			}
		}
		if (flag == false) {
			System.out.println("School not Found with ID : " + id);
		}
		return false;
	}

	public void UpdateSchool(int id) {
		School s;
		boolean flag = false;
		for (int i = 0; i < school.size(); i++) {
			s = school.get(i);
			int myid = s.getSchoolId();
			if (myid == id) {
				System.out.println("---------------------------------");
				System.out.println("1.Change school Name");
				System.out.println("2.Change school Id");
				System.out.println("3.Change SchoolBoard");
				System.out.println("4.change School ContactNumber");
				System.out.println("---------------------------------");
			
				int ch =0;
				boolean dfg=true;
				while (dfg) {
					try {
						System.out.println("Enter your choice : ");
						ch = sc.nextInt();
						if (ch >= 5 && ch != 0) {
							System.out.println("Make Choice between 1 - 4 ");
						} else {
							dfg = false;
							break;
						}

					} catch (InputMismatchException e) {
						sc.next();
						System.out.println("****Enter only digits");

					}
				}
				
				switch (ch) {
				case 1:
					System.out.println("Enter the School Name to Update ");
					String cgName = sc.next();
					while (!cgName.matches("[a-zA-Z]+")) {
						System.out.println("Enter the  Valid school Name to Update :");
						cgName = sc.next();
					}
					s.setSchoolname(cgName);
					System.out.println("Update Successfull..!");
					break;
				case 2:
					int cgid = 0;
					boolean az = true;
					while (az) {
						try {
							System.out.println("Enter the school ID to Update :");
							cgid = sc1.nextInt();
							az = false;
							break;
						} catch (InputMismatchException e) {
							sc1.next();
							System.out.println("****Enter valid School ID");
						}
					}
					s.setSchoolId(cgid);
					System.out.println("Update Successfull..!");
					break;
				case 3:
					System.out.println("Enter the  School Board to update :");
					String board = sc.next();
					while (!(board.matches("cbse") || board.matches("icse") || board.matches("state"))) {
						System.out.println("Enter the  Valid Board Name to update(cbse,icse,state) :");
						board = sc.next();
					}
					s.setSchoolboard(board);
					System.out.println("Update Successfull..!");
					break;
				case 4:
					String cnum = null;
					System.out.println("Enter School Contact Number to Update :");
					cnum = sc.next();
					while (!cnum.matches("[0-9]{10}")) {
						System.out.println("Enter  Valid 10 digit Number to Update :");
						cnum = sc.next();
					}
					s.setContactNumber(cnum);
					System.out.println("Update Successfull..!");
					break;
				}
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("School not Found with ID :" + id);
		}
	}

	public void CalculateStrength(int stdid, int c) {
		School s1;
		for (int i = 0; i < school.size(); i++) {
			s1 = school.get(i);
			int myid = s1.getSchoolId();
			if (myid == stdid) {
				for (int j = 0; j < arr1.length; j++) {
					if (c == j)
						arr1[j]++;
				}
				int sum = 0;
				for (int x = 0; x < arr.length; x++) {
					sum += arr[x];
				}
				int sum1 = 0;
				for (int y = 0; y < arr1.length; y++) {
					sum1 += arr1[y];
				}
				int tsum = sum - sum1;
				s1.setTotalSeats(tsum);
			}
		}

	}

	public boolean AdmitStudent() {
		System.out.println("Enter the Student Name :");
		String name = sc.next();
		while (!name.matches("[a-zA-Z]+")) {
			System.out.println("Enter the  Valid Student Name :");
			name = sc.next();
		}

		Random rd = new Random();
		int id = rd.nextInt(1000);
		System.out.println("Student id:" + " " + id);

		System.out.println("Enter Student's father name :");
		String fname = sc.next();
		while (!fname.matches("[a-zA-Z]+")) {
			System.out.println("Enter the valid name :");
			fname = sc.next();
		}

		System.out.println("Enter Student's mother name :");
		String mname = sc.next();
		while (!mname.matches("[a-zA-Z]+")) {
			System.out.println("Enter the valid name :");
			mname = sc.next();
		}

		String cn = null;
		System.out.println("Enter Student Contact Number:");
		cn = sc.next();
		while (!cn.matches("[0-9]{10}")) {
			System.out.println("Enter valid Student Contact Number :");
			cn = sc.next();
		}

		ListOfSchool(); // To Display Available Schools

		int stdid;
		int cl = 0;
		double fees = 0;
		boolean f = false;
		do {
			stdid = 0;
			boolean dw = true;
			while (dw) {
				try {
					System.out.println("Enter the School Id the student wish to join :");
					stdid = sc.nextInt();
					dw = false;
					break;
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println("****Enter only digits :");
				}
			}

			boolean an = true;
			while (an) {
				try {
					System.out.println("Enter the class student should  to join ");
					cl = sc1.nextInt();
					if (cl > 12) {
						System.out.println("Class "+ cl + "is not allowed ");
					} else {
						an = false;
						break;
					}
				} catch (InputMismatchException e) {
					sc1.next();
					System.out.println("****Enter only digits");

				}

			}
			if (cl <= 6) {
				fees = 25000;
			} else if (cl >= 7) {
				fees = 35000;
			}
			f = GetSchool(stdid);
		} while (f != true);

		System.out.println("Calculated Fees for Class " + cl + " is : Rs." + fees);
		CalculateStrength(stdid, cl);
System.out.println("Student Admitted to School in class "+cl+" for School ID "+stdid);
		Student s1 = new Student(name, id, fname, mname, cn, stdid);
		students.add(s1);
		return true;
	}

	public void ListOfStudents() {
		System.out.println("List of Students");
		System.out.println("----------------------------------");
		for (int i = 0; i < students.size(); i++) {
			Student s = students.get(i);
			if (students.size() != 0) {
				s.print();
				System.out.println("----------------------------------");
			} else {
				System.out.println("List is Empty");
			}
		}
	}

	public void DeleteStudent(int id) {
		System.out.println("Deleting Student with ID :  " + id);
		boolean flag = false;
		Student s1;
		for (int i = 0; i < students.size(); i++) {
			s1 = students.get(i);
			int myid = s1.getStudentId();
			if (myid == id) {
				students.remove(i);
				System.out.println("Students details Deleted Sucessfully for ID : " + id);
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Student data not found with ID : " + id);
		}
	}

	public void GetStudent(int id) {
		boolean flag = false;
		System.out.println("Searching Student with ID  : " + id);
		Student s1;
		for (int i = 0; i < students.size(); i++) {
			s1 = students.get(i);
			int myid = s1.getStudentId();
			if (myid == id) {
				s1.print();
				System.out.println("--------------------------------------");
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Student not found with ID  : " + id);
		}
	}

	public void UpdateStudent(int id) {
		System.out.println("Take a look at Student Details ");
		GetStudent(id);
		System.out.println("----------------------------------");
		Student s;
		boolean flag = false;
		for (int i = 0; i < students.size(); i++) {
			s = students.get(i);
			int myid = s.getStudentId();
			if (myid == id) {
				System.out.println("1.Change student name");
				System.out.println("2.Change student Id");
				System.out.println("3.Change School name");
				System.out.println("4.change Student ContactNumber");

				int ch = 0;
				boolean al = true;
				while (al) {
					try {
						System.out.println("Enter your choice :");
						ch = sc1.nextInt();
						if (ch >= 5 && ch != 0) {
							System.out.println("Make Choice between 1 - 4 ");
						} else {
							al = false;
							break;
						}
					} catch (InputMismatchException e) {
						sc1.next();
						System.out.println("****Enter only digits ");
					}
				}

				switch (ch) {
				case 1:
					System.out.println("Enter the name of the Student to Update :");
					String stName = sc.next();
					while (!stName.matches("[a-zA-Z]+")) {
						System.out.println("Enter the  Valid student Name to Update :");
						stName = sc.next();
					}
					s.setStudentName(stName);
					System.out.println("Update Successfull..!");
					break;
				case 2:
					int sid = 0;
					boolean aas = true;
					while (aas) {
						try {
							System.out.println("Enter the student ID to Update :");
							sid = sc1.nextInt();
							aas = false;
							break;
						} catch (InputMismatchException e) {
							sc1.next();
							System.out.println("****Enter valid Student ID");
						}
					}
					s.setStudentId(sid);
					System.out.println("Update Successfull..!");
					break;
				case 3:
					int scid = 0;
					boolean aas1 = true;
					while (aas1) {
						try {
							System.out.println("Enter School ID to Update :");
							scid = sc.nextInt();
							aas1 = false;
							break;
						} catch (InputMismatchException e) {
							sc.next();
							System.out.println("****Enter valid ID");
						}
					}
					s.setSchoolAdmittedTo(scid);
					System.out.println("Update Successfull..!");
					break;
				case 4:
					System.out.println("Enter student contact number to Update :");
					String scontact = sc.next();
					while (!scontact.matches("[0-9]{10}")) {
						System.out.println("Enter Valid Student Contact Number to Update :");
						scontact = sc.next();
					}
					s.setContact(scontact);
					System.out.println("Update Successfull..!");
					break;
				}
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Student data not Found with ID  : " + id);
		}
	}

	public void ReportingOnSchoolId(int id) {
		boolean flag = false;

		School s1;
		for (int i = 0; i < school.size(); i++) {
			s1 = school.get(i);
			int myid = s1.getSchoolId();
			if (myid == id) {
				System.out.print("School details are :");
				s1.print();
				System.out.println("-------------------------------");
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("School data not found with School ID : " + id);
		}

	}

	public void ReportingOnSchoolBoard(String board) {
		boolean flag = false;
		School s1;
		for (int i = 0; i < school.size(); i++) {
			s1 = school.get(i);
			String bd = s1.getSchoolboard();
			if (board.equals(bd)) {
				System.out.println("School details are for board :" + board);
				s1.print();
				System.out.println("-------------------------------");
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("School data not found with School Board :" + board);
		}
	}

	public void Vacany() {
		School s2;
		for (int i = 0; i < school.size(); i++) {
			s2 = school.get(i);
			System.out.println("---------------------------");
			System.out.println("School Name   : " + s2.getSchoolname());
			System.out.println("School Board  : " + s2.getSchoolboard());
			System.out.println("Total Seats Available : " + s2.getTotalSeats());
			System.out.println("---------------------------");
		}
	}

	public static void main(String args[]) {
		WorkingOfSchool sw1 = new WorkingOfSchool();
		School s = new School();
		Scanner sc1 = new Scanner(System.in);
		int num1 = 0;
		while (num1 != 4) {
			System.out.println("*************************************************");
			System.out.println("Welcome To School Admission Application ");
			System.out.println("*************************************************");
			System.out.println("1. Add/View School ");
			System.out.println("2. Admit Student ");
			System.out.println("3. Reporting On School info ");
			System.out.println("4. Exit");
			System.out.println("---------------------------------");

			boolean d = true;
			while (d) {
				try {
					System.out.println("Enter Your Choice :");
					num1 = sc1.nextInt();
					if (num1 >= 5 && num1 != 0) {
						System.out.println("Make Choice only between 1 - 3 ");
					} else {
						d = false;
						break;
					}

				} catch (InputMismatchException e) {
					sc1.next();
					System.out.println("****Enter only digits ");

				}
			}
			boolean sch = true;

			switch (num1) {

			case 1:
				int num2 = 0;
				while (num2 != 6) {
					System.out.println("---------------------------------");
					System.out.println("1.Add School");
					System.out.println("2.List of schools ");
					System.out.println("3.Update School information ");
					System.out.println("4.SearchSchool by id");
					System.out.println("5.DeleteSchool");
					System.out.println("6.Exit ");
					System.out.println("---------------------------------");

					boolean dl = true;
					while (dl) {
						try {
							System.out.println("Enter Your Choice :");
							num2 = sc1.nextInt();
							if (num2 >= 7 && num2 != 0) {
								System.out.println("Make Choice only between 1 - 6 ");
							} else {
								dl = false;
								break;
							}

						} catch (InputMismatchException e) {
							sc1.next();
							System.out.println("****Enter only digits ");

						}
					}
					switch (num2) {
					case 1:
						boolean s1 = sw1.AddSchool();
						break;

					case 2:
						sw1.ListOfSchool();
						break;

					case 3:
						int id1 = 0;
						boolean up = true;
						while (up) {
							try {
								System.out.println("Enter the School ID to Update :");
								id1 = sc1.nextInt();
								up = false;
								break;
							} catch (InputMismatchException e) {
								sc1.next();
								System.out.println("****Enter valid School ID to Update");
							}
						}
						sw1.UpdateSchool(id1);
						break;

					case 4:
						int id = 0;
						boolean az1 = true;
						while (az1) {
							try {
								System.out.println("Enter School ID to Search :");
								id = sc1.nextInt();
								az1 = false;
								break;
							} catch (InputMismatchException e) {
								sc1.next();
								System.out.println("****Enter valid School ID");

							}

						}
						sw1.GetSchool(id);
						break;

					case 5:
						int id2 = 0;
						boolean del = true;
						while (del) {
							try {
								System.out.println("Enter the School ID to delete :");
								id2 = sc1.nextInt();
								del = false;
								break;
							} catch (InputMismatchException e) {
								sc1.next();
								System.out.println("****Enter valid School ID to Delete");
							}
						}
						sw1.DeleteSchool(id2);
						break;
					case 6:
						System.out.println(" ");
						break;
					}
				}
				break;
			case 2:
				int num3 = 0;
				while (num3 != 6) {
					System.out.println("---------------------------------");
					System.out.println("1.Admit Student");
					System.out.println("2.List of students ");
					System.out.println("3.UpdateStudent Information");
					System.out.println("4.Search student by id");
					System.out.println("5.Delete student");
					System.out.println("6.Exit");
					System.out.println("---------------------------------");

					boolean dpk = true;
					while (dpk) {
						try {
							System.out.println("Enter Your Choice :");
							num3 = sc1.nextInt();
							if (num3 >= 7 && num3 != 0) {
								System.out.println("Make Choice only between 1 - 6 ");
							} else {
								dpk = false;
								break;
							}

						} catch (InputMismatchException e) {
							sc1.next();
							System.out.println("****Enter only digits ");

						}
					}

					switch (num3) {
					case 1:
						boolean su = sw1.AdmitStudent();
						break;
					case 5:
						int idd = 0;
						boolean an = true;
						while (an) {
							try {
								System.out.println("Enter Student ID to Delete : ");
								idd = sc1.nextInt();
								an = false;
								break;
							} catch (InputMismatchException e) {
								sc1.next();
								System.out.println("****Enter valid Student ID to Delete");
							}
						}
						sw1.DeleteStudent(idd);
						break;
					case 3:
						int idu = 0;
						boolean a5 = true;
						while (a5) {
							try {
								System.out.println("Enter Student ID to Update : ");
								idu = sc1.nextInt();
								a5 = false;
								break;
							} catch (InputMismatchException e) {
								sc1.next();
								System.out.println("****Enter valid School ID");
							}
						}
						sw1.UpdateStudent(idu);
						break;
					case 4:
						int idn = 0;
						boolean aqw1 = true;
						while (aqw1) {
							try {
								System.out.println("Enter Student ID to Search : ");
								idn = sc.nextInt();
								aqw1 = false;
								break;
							} catch (InputMismatchException e) {
								sc.next();
								System.out.println("****Enter valid Student ID to Search");
							}
						}

						sw1.GetStudent(idn);
						break;
					case 2:sw1.ListOfStudents();
					default:
						break;
					}
				}
				break;
			case 3:
				int num4 = 0;
				while (num4 != 4) {
					System.out.println("---------------------------------");
					System.out.println("1.Reporting on Id");
					System.out.println("2.Reporting on board");
					System.out.println("3.Reporting on vacant seats");
					System.out.println("4.Exit");
					System.out.println("---------------------------------");

					boolean dpko = true;
					while (dpko) {
						try {
							System.out.println("Enter Your Choice :");
							num4 = sc1.nextInt();
							if (num4 >= 5 && num4 != 0) {
								System.out.println("Make Choice only between 1 - 4 ");
							} else {
								dpko = false;
								break;
							}

						} catch (InputMismatchException e) {
							sc1.next();
							System.out.println("****Enter only digits ");

						}
					}

					switch (num4) {
					case 1:
						int sid = 0;
						boolean aqw = true;
						while (aqw) {
							try {
								System.out.println("enter the school id to Search");
								sid = sc1.nextInt();
								aqw = false;
								break;
							} catch (InputMismatchException e) {
								sc1.next();
								System.out.println("****Enter valid School ID to Search");
							}
						}
						System.out.println("Reporting on School ID");
						sw1.ReportingOnSchoolId(sid);
						break;
					case 2:
						System.out.println("Enter the  SchoolBoard to Search :");
						String bd = sc.next();
						while (!(bd.matches("cbse") || bd.matches("icse") || bd.matches("state"))) {
							System.out.println("Enter the  Valid Board Name :");
							bd = sc.next();
						}
						sw1.ReportingOnSchoolBoard(bd);
						break;
					case 3:
						System.out.println("Reporting on Vacancy ");
						System.out.println("--------------------------");
						sw1.Vacany();
						break;
					default:
						System.out.println(" ");
						break;
					}
				}
				break;
			case 4:
				System.out.println("Exiting Application Sucessfull ");
				System.exit(0);
				break;
			}
		}

	}
}
