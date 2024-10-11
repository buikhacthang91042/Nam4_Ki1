package entities;

public class Student {
    // Các thuộc tính
    private String firstName;
    private String lastName;
    private String dateOfBirth;  	
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String hobbies; 
    private String[] qualifications; 
    private String[] boards;
    private double[] percentages; 
    private int[] yearsOfPassing; 
    private String courseAppliesFor;

    // Constructor
    public Student(String firstName, String lastName, String dateOfBirth, String email, String mobileNumber,
                   String gender, String address, String city, String pinCode, String state, String country,
                   String hobbies, String[] qualifications, String[] boards, double[] percentages, int[] yearsOfPassing,String courseAppliesFor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.qualifications = qualifications;
        this.boards = boards;
        this.percentages = percentages;
        this.yearsOfPassing = yearsOfPassing;
        this.courseAppliesFor = courseAppliesFor;
    }
    
    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Các phương thức getter và setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String[] getQualifications() {
        return qualifications;
    }

    public void setQualifications(String[] qualifications) {
        this.qualifications = qualifications;
    }

    public String[] getBoards() {
        return boards;
    }

    public void setBoards(String[] boards) {
        this.boards = boards;
    }

    public double[] getPercentages() {
        return percentages;
    }

    public void setPercentages(double[] percentages) {
        this.percentages = percentages;
    }

    public int[] getYearsOfPassing() {
        return yearsOfPassing;
    }

    public void setYearsOfPassing(int[] yearsOfPassing) {
        this.yearsOfPassing = yearsOfPassing;
    }

	public String getCourseAppliesFor() {
		return courseAppliesFor;
	}

	public void setCourseAppliesFor(String courseAppliesFor) {
		this.courseAppliesFor = courseAppliesFor;
	}
    
}
