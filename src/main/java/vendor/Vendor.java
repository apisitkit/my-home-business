package main.java.vendor;

public class Vendor {
	private int id;
	private String name;
	private String type;
	private String addr;
	private String addrInBill;
	private String tel;
	private String telInBill;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrInBill() {
		return addrInBill;
	}
	public void setAddrInBill(String addrInBill) {
		this.addrInBill = addrInBill;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTelInBill() {
		return telInBill;
	}
	public void setTelInBill(String telInBill) {
		this.telInBill = telInBill;
	}
}
