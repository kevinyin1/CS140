package assignment05;

public class Child extends Parent {

	private String cName;

	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public void print() {
		System.out.println(cName);
		super.print();
	}
}
