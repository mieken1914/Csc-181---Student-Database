
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainUI {
	public static void main(String[] args){
		try{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_db", "postgres", "apipahdessopolao");
			
			
			operations(con);
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public static boolean checkIdNum(int temp_id, Connection temp_con){
		boolean idnum_checked = false;
		try{
			PreparedStatement stmt = temp_con.prepareStatement("SELECT idnum FROM student");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("idnum") == temp_id){
					idnum_checked = true;
					break;
				}
			}
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return idnum_checked;
		
	}

	
	public static void addAccount(Connection temp_con){
		Scanner sc = new Scanner(System.in);
		char choice_cont;
		System.out.println("New account menu:");
		System.out.println("\n\nPlease enter idumber: ");
		
		int new_idnum = sc.nextInt();
		
		
		if(!checkIdNum(new_idnum, temp_con)){
			System.out.println("Please enter last name: ");
			sc.nextLine();
			String new_l_name = sc.nextLine();
			System.out.println("Please enter first name: ");
			String new_f_name = sc.nextLine();
			System.out.println("Please enter middle name: ");
			String new_m_name = sc.nextLine();
			System.out.println("Please enter gender: ");
			char new_gender = sc.next().charAt(0);
			System.out.println("Please enter college: ");
			String new_college = chooseCollege();
			System.out.println("Please enter course");
			String new_course = chooseCourse(new_college);
			System.out.println("Please enter yr level");
			String new_year = chooseYear();
			System.out.println("Please enter address:");
			System.out.println("->Please enter block no: ");
			int new_block = sc.nextInt();
			System.out.println("->Please enter street: ");
			sc.nextLine();
			String new_street = sc.nextLine();
			System.out.println("->Please enter brgy: ");
			String new_brgy = sc.nextLine();
			System.out.println("->Please enter city: ");
			String new_city = sc.nextLine();
			System.out.println("Please enter bdate(yyyy-MM-dd): ");
			String new_date = sc.next();
			
			
			
			Student_Info temp_acct = new Student_Info(new_idnum, new_l_name, new_f_name, new_m_name, new_gender,
													new_college, new_course, new_year, new_block, new_street,
													new_brgy, new_city, new_date);
			
			System.out.println("New student info:");
			temp_acct.display();
			
			System.out.println("\nWould you like to continue adding new student?");
			choice_cont = sc.next().charAt(0);
			
			if(choice_cont == 'y'){
				temp_acct.addToDB(temp_con);
				System.out.println("Adding successful.");
			}
			else{
				System.out.println("Adding canceled.");
			}
			
		}
		
	}
	
	public static void delAccount(Connection temp_con){
		System.out.println("Delete menu:\n--Displaying all acounts:\n");
		displayList(temp_con);
		System.out.println("Please enter idnumber: ");
		Scanner sc = new Scanner(System.in);
		int del_id = sc.nextInt();
		char choice_cont;
		
		if(checkIdNum(del_id, temp_con)){
			System.out.println("ID Found!");
			Student_Info temp_acct = new Student_Info(del_id, temp_con);
			System.out.println("Info:");
			temp_acct.display();
			System.out.println("\nWould you continue delete? ");
			choice_cont = sc.next().charAt(0);
			
			if(choice_cont == 'y'){
				System.out.println("Proceeding deletion...");
				temp_acct.deleteFromDB(temp_con);
				System.out.println("Deletion successful.");
			}
			else{
				System.out.println("Deletion canceled.");
			}
			
		}
		else{
			System.out.println("ID not found.");
		}
		
	}
	
	public static void updateAccount(Connection temp_con){
		System.out.println("Update Menu\n--Displaying all acounts:\n");
		displayList(temp_con);
		System.out.println("Please enter idnumber: ");
		Scanner sc = new Scanner(System.in);
		int up_id = sc.nextInt();
		int choice;
		char loop_cont = 'y';
		
		if(checkIdNum(up_id, temp_con)){
			Student_Info temp = new Student_Info(up_id, temp_con);
			temp.display();
			
			
			while(loop_cont == 'y'){
				System.out.println("Please select what field to update:\n" +
						"1. Name\n" +
						"2. Gender\n" +
						"3. College/Course\n" +
						"4. Year Level\n" +
						"5. Address\n" +
						"6. Birthdate\n" +
						"\n--Choice: ");
				choice = sc.nextInt();
				switch(choice){
				case 1:
					System.out.println("Please enter last name: ");
					sc.nextLine();
					temp.setL_name(sc.nextLine());
					System.out.println("Please enter first name: ");
					temp.setF_name(sc.nextLine());
					System.out.println("Please enter middle name: ");
					temp.setM_name(sc.nextLine());
					break;
				case 2:
					System.out.println("Please enter gender: ");
					temp.setGender(sc.next().charAt(0));
					break;
				case 3:
					System.out.println("Please enter college: ");
					temp.setCollege(sc.next());
					System.out.println("Please enter course");
					temp.setCourse(chooseCourse(temp.getCollege()));
					break;
				case 4:
					System.out.println("Please enter yr level");
					temp.setYear_lvl(chooseYear());
					break;
				case 5:
					System.out.println("Please enter address:");
					System.out.println("->Please enter block no: ");
					temp.setAd_house_num(sc.nextInt());
					System.out.println("->Please enter street: ");
					sc.nextLine();
					temp.setAd_street(sc.nextLine());
					System.out.println("->Please enter brgy: ");
					temp.setAd_brgy(sc.nextLine());
					System.out.println("->Please enter city: ");
					temp.setAd_city(sc.nextLine());
					break;
				case 6:
					System.out.println("Please enter bdate(yyyy-MM-dd): ");
					temp.setBdate(sc.next());
					break;
					
				}
				
				System.out.println("\nUpdate more infos? Y/N");
				loop_cont = sc.next().charAt(0);
			}
			System.out.println("The new info:");
			temp.display();
			System.out.println("Would you like to continu update? ");
			char choice_cont = sc.next().charAt(0);
			
			if(choice_cont == 'y'){
				temp.updateToDB(temp_con);
				System.out.println("Update successful.");
			}
			else{
				System.out.println("Update canceled.");
			}
			
		}
	}
	
	public static void displayAllAccount(Connection temp_con){
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Student Database Display:\n");
		displayList(temp_con);
		
		System.out.println("Enter idnumber to view: ");
		int choice_id = sc.nextInt();
		
		if(checkIdNum(choice_id,temp_con)){
			Student_Info temp = new Student_Info(choice_id, temp_con);
			temp.display();
		}
		else{
			System.out.println("ID does not exist!");
		}
		
		
	}
	
	public static void displayList(Connection temp_con) {
		PreparedStatement stmt;
		try {
			stmt = temp_con.prepareStatement("SELECT idnum, (name).l_name AS l_name, (name).f_name AS f_name, (name).m_name AS m_name, course FROM student");
			ResultSet rs = stmt.executeQuery();
			System.out.println("IDNumber\t" + "Name\t" + "Course\n" );
			while(rs.next()){
				int current_id = rs.getInt("idnum");
				String current_fullname = rs.getString("l_name") + ", " + rs.getString("f_name") + " " + rs.getString("m_name").charAt(0) + ". ";
				String current_course = rs.getString("course");
				
				System.out.println(current_id + "\t" + current_fullname + "\t" + current_course);
			}
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public static String chooseCollege(){
		String[] college = new String[]{"CNSM", "CHS", "CSSH", "CPA", "CBAA", "COE", "CIT"};
		
		for(int i = 0; i<college.length; i++){
			System.out.println((i+1) + ". " + college[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Choice: ");
		int choice = sc.nextInt();
		
		return college[choice-1];
	}
	public static String chooseCourse(String college){
		List <String> courseList = new ArrayList<String>();
		
		switch(college){
			case "CNSM":
				courseList.addAll(Arrays.asList("BS-Biology", "BS-Zoology", "BS-Chemistry", "BS-Math", "BS-Physics"));
				break;
			case "CHS":
				courseList.addAll(Arrays.asList("BS-Nursing"));
				break;
			case "CSSH":
				courseList.addAll(Arrays.asList("AB-English", "AB-History", "AB-Philosophy", "AB-Filipino", "BS-Psychology"));
				break;
			case "CPA":
				courseList.addAll(Arrays.asList("BS-PublicAd", "PS-SocialWork"));
				break;
			case "CBAA":
				courseList.addAll(Arrays.asList("BS-Accountacy", "BS-Marketing", "BSA-Management", "BS-Economics"));
				break;
			case "COE":
				courseList.addAll(Arrays.asList("BS-C.Engineering", "BS-M.Engineering", "BS-Ch.Engineering", "BS-A.Engineering","BS-E.Engineering", "BS-EC.Engineering"));
				break;
			case "CIT":
				courseList.addAll(Arrays.asList("BS-IT", "BS-ComputerScience"));
				break;
		}
		System.out.println("Choose:\n");
		for (int i = 0; i<courseList.size(); i++){
			System.out.println((i+1) + ". " + courseList.get(i));
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter choice: ");
		int choice = sc.nextInt();
		
		return courseList.get(choice - 1);
		
	}
	
	public static String chooseYear(){
		System.out.println("Choose\n" +
							"1. 1st Year\n" +
							"2. 2nd Year\n" +
							"3. 3rd Year\n" +
							"4. 4th Year\n" +
							"5. 5th Year\n" + 
							"6. Irregular Year\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		
		switch(choice){
			case 1:
				return "1st Year";
			case 2:
				return "2nd Year";
			case 3:
				return "3rd Year";
			case 4:
				return "4th Year";
			case 5:
				return "5th Year";
			default:
				return "Irregular Year";
		}
	}
	
	
	public static void displayMenu(){
		System.out.println("Database Menu:\n" +
							"1. Add new student\n" +
							"2. Update existing student info\n" +
							"3. Display info\n" +
							"4. Delete student\n" +
							"5. Exit\n");
	}
	
	public static void operations(Connection con){
		Scanner sc = new Scanner(System.in);
		int menu_choice;
		char cont;
		do{
			displayMenu();
			System.out.print("\nCHOICE: ");
			menu_choice = sc.nextInt();
			switch(menu_choice){
				case 1:
					addAccount(con);
					break;
				case 2:
					updateAccount(con);
					break;
				case 3:
					displayAllAccount(con);
					break;
				case 4:
					delAccount(con);
					break;
			}
			System.out.println("CONTINUE?");
			cont = sc.next().charAt(0);
			
			if(cont != 'y') break;
			
		}while(menu_choice > 0 && menu_choice < 5);
		
		
	}

}
