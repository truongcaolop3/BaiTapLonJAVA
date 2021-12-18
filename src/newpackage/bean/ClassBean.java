package newpackage.bean;

public class ClassBean {
	private String ngaydangky;
	private int soluong_student;
	public ClassBean() {
		
	}
	public ClassBean(String ngaydangky, int soluong_student) {
		super();
		this.ngaydangky = ngaydangky;
		this.soluong_student = soluong_student;
	}
	public String getNgaydangky() {
		return ngaydangky;
	}
	public void setNgaydangky(String ngaydangky) {
		this.ngaydangky = ngaydangky;
	}
	public int getSoluong_student() {
		return soluong_student;
	}
	public void setSoluong_student(int soluong_student) {
		this.soluong_student = soluong_student;
	}
	@Override
	public String toString() {
		return   ngaydangky + " " + soluong_student ;
	}
	
}
