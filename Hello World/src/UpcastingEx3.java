class PersonX{
	String name="Person";
	String id;
	String grade;
	public PersonX(String name){
		this.name=name;
	}
	public void work() {
		System.out.println("행복하고 의미있는 삶");
	}
}

class underGraduate extends PersonX{
	
	String name="Under graduate";
	String grade;
	String department;
	public underGraduate (String name) {
		super(name);
	}
	
	public void work() {
		System.out.println("진리탐구");
	}
}

class highSchool extends PersonX{
	String name="High School";
	String grade;
	String department;
	public highSchool(String name) {
		super(name);
	}
	
	public void work() {
		System.out.println("적성과 소질에 맞는 진로 탐색");
	}
}

public class UpcastingEx3 {
	   public static void main(String[] args) {
	       PersonX  pu, ph;
	       PersonX p = new PersonX("Person");
	       underGraduate uG = new underGraduate("대학생");
	       highSchool hS = new highSchool("고등학생");
	       pu = uG; // 업캐스팅 발생
	       //pu = (PersonX) uG;
	       ph = hS; // 업캐스팅 발생
	       //System.out.println(pu.name); // 오류 없음
	       System.out.println(uG.name); // 오류 없음
	        pu.work();
	         //System.out.println(ph.name); // 오류 없음
	        System.out.println(hS.name); // 오류 없음
	        ph.work();
	        //hS.work();
	        uG = (underGraduate) pu; // 다운캐스팅 발생
	        System.out.println(p.name); // 오류 없음
	        p.work();
	        }
	    }
