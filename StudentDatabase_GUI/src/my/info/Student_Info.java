package my.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student_Info {
	
	private int idnum;
	private String l_name;
	private String f_name;
	private String m_name;
	private char gender;
	private String college;
	private String course;
	private String year_lvl;
	private int ad_house_num;
	private String ad_street;
	private String ad_brgy;
	private String ad_city;
	private String bdate;
	
	public Student_Info(){
		
	}
	
	public Student_Info(ResultSet rs){
		
		try{
			idnum = rs.getInt("idnum");
			l_name = rs.getString("l_name");
			f_name = rs.getString("f_name");
			m_name = rs.getString("m_name");
			gender = rs.getString("gender").charAt(0);
			college = rs.getString("college");
			course = rs.getString("course");
			year_lvl = rs.getString("year_lvl");
			ad_house_num = rs.getInt("h_num");
			ad_street = rs.getString("street");
			ad_brgy = rs.getString("brgy");
			ad_city = rs.getString("city");
			bdate = rs.getString("bdate");
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public Student_Info(int id, Connection con){

		PreparedStatement stmt;
		try{
			
			stmt = con.prepareStatement("SELECT idnum, (name).l_name AS l_name, (name).f_name AS f_name, (name).m_name AS m_name, " + 
					"gender, college, course, year_lvl, (address).house_num AS h_num, (address).street AS street, (address).brgy AS brgy, " +
					"(address).city AS city, bdate FROM student where idnum = " + id);
			ResultSet rs = stmt.executeQuery();

			rs.next();
			
			idnum = rs.getInt("idnum");
			l_name = rs.getString("l_name");
			f_name = rs.getString("f_name");
			m_name = rs.getString("m_name");
			gender = rs.getString("gender").charAt(0);
			college = rs.getString("college");
			course = rs.getString("course");
			year_lvl = rs.getString("year_lvl");
			ad_house_num = rs.getInt("h_num");
			ad_street = rs.getString("street");
			ad_brgy = rs.getString("brgy");
			ad_city = rs.getString("city");
			bdate = rs.getString("bdate");

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public Student_Info(int idnum, String l_name, String f_name, String m_name, char gender, String college,
			String course, String year_lvl, int ad_house_num, String ad_street, String ad_brgy, String ad_city,
			String bdate) {
		super();
		this.idnum = idnum;
		this.l_name = l_name;
		this.f_name = f_name;
		this.m_name = m_name;
		this.gender = gender;
		this.college = college;
		this.course = course;
		this.year_lvl = year_lvl;
		this.ad_house_num = ad_house_num;
		this.ad_street = ad_street;
		this.ad_brgy = ad_brgy;
		this.ad_city = ad_city;
		this.bdate = bdate;
	}

	public int getIdnum() {
		return idnum;
	}

	public void setIdnum(int idnum) {
		this.idnum = idnum;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear_lvl() {
		return year_lvl;
	}

	public void setYear_lvl(String year_lvl) {
		this.year_lvl = year_lvl;
	}

	public int getAd_house_num() {
		return ad_house_num;
	}

	public void setAd_house_num(int ad_house_num) {
		this.ad_house_num = ad_house_num;
	}

	public String getAd_street() {
		return ad_street;
	}

	public void setAd_street(String ad_street) {
		this.ad_street = ad_street;
	}

	public String getAd_brgy() {
		return ad_brgy;
	}

	public void setAd_brgy(String ad_brgy) {
		this.ad_brgy = ad_brgy;
	}

	public String getAd_city() {
		return ad_city;
	}

	public void setAd_city(String ad_city) {
		this.ad_city = ad_city;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	public void updateToDB(Connection con){
		PreparedStatement stmt = null;
		
		String update_query = "UPDATE student SET name.l_name = '" + l_name + "', name.f_name = '" + f_name +
								"', name.m_name = '" + m_name + "', gender = '" + gender + "', college = '" + college +
								"', course = '" + course + "', year_lvl = '" + year_lvl +
								"', address.house_num = " + ad_house_num + ", address.street = '" + ad_street +
								"', address.brgy = '" + ad_brgy + "', address.city = '" + ad_city + "', bdate = '" + bdate +
								"' WHERE idnum = " + idnum;
		
		try{
			stmt = con.prepareStatement(update_query);
			stmt.executeUpdate();
			System.out.println("HERE");
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void addToDB(Connection con){
		PreparedStatement stmt = null;
		String insert_query = "INSERT INTO student(idnum, name.l_name, name.f_name, name.m_name, gender, college, course, year_lvl," + 
				"address.house_num, address.street, address.brgy, address.city, bdate) " +
				"VALUES (" + idnum  + ", '" + l_name + "', '" + f_name + "', '" + m_name + "', '" +
						gender + "', '" + college + "', '" + course + "', '" + year_lvl + "', " +
						ad_house_num + ", '" + ad_street + "', '" + ad_brgy + "', '" + ad_city + "', '" +
						bdate + "')";
		
		try{
			stmt = con.prepareStatement(insert_query);
			stmt.executeUpdate();
			
		} catch(Exception ex){
			
		}
	}
	
	public void deleteFromDB(Connection con){
		try{
			PreparedStatement stmt = con.prepareStatement("DELETE from STUDENT where idnum = " + idnum);
			stmt.executeUpdate();
			
		}catch(Exception ex){
			
		}
	}
	
	public void display(){

		String fullname = l_name + ", " + f_name + " " + m_name.charAt(0) + ". ";
		String current_fulladdress = ad_house_num + " " + ad_street + ", " + ad_brgy + ", " + ad_city;
		int age = getAge(bdate);
		
		System.out.println("ID Number: " + idnum +
				"\nName: " + fullname +
				"\nCollege: " + college +
				"\nCourse: " + course +
				"\nYear Level: " + year_lvl +
				"\nAddress: " + current_fulladdress +
				"\nAge: " + age + "\n\n");
		
	}
	
	public static int getAge(String temp_bdate){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date temp_date;
		Calendar bdate = null;
		try {
			temp_date = df.parse(temp_bdate);
			bdate = Calendar.getInstance();
			bdate.setTime(temp_date);
			
		} catch(ParseException e) {
			e.printStackTrace();
		}
		Calendar curr_date = Calendar.getInstance();
		long bdate_millis = bdate.getTimeInMillis();
		long curr_date_millis = curr_date.getTimeInMillis();
		long age_millis = curr_date_millis - bdate_millis;
		
		double YEARS = 1000*60*60*24*365.25;
		
		return (int) (age_millis/YEARS);
		
	}
	
}
