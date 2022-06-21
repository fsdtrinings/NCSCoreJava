package p1.dto;


public class EmployeeDTO {
	private int empId;
	private String empName;
	private String emailId;
	private String projectName;
	private String projectHeadEmail;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectHeadEmail() {
		return projectHeadEmail;
	}
	public void setProjectHeadEmail(String projectHeadEmail) {
		this.projectHeadEmail = projectHeadEmail;
	}
	public EmployeeDTO(int empId, String empName, String emailId, String projectName, String projectHeadEmail) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.emailId = emailId;
		this.projectName = projectName;
		this.projectHeadEmail = projectHeadEmail;
	}
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", emailId=" + emailId + ", projectName="
				+ projectName + ", projectHeadEmail=" + projectHeadEmail + "]";
	}
	
	

}
