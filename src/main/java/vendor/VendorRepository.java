package main.java.vendor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VendorRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public VendorRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public ArrayList<Vendor> getVendors() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM VENDOR.VENDOR ");
		return (ArrayList<Vendor>) this.jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper(Vendor.class));
	}

	public int addVendors(Vendor vendor) {
		StringBuilder sb = new StringBuilder();
		List params = new LinkedList<Object>();
		sb.append("INSERT INTO VENDOR.VENDOR (NAME, TYPE, ADDR, ADDR_IN_BILL, TEL, TEL_IN_BILL) VALUES (?, ?, ?, ?, ?, ?)");
		params.add(vendor.getName());
		params.add(vendor.getType());
		params.add(vendor.getAddr());
		params.add(vendor.getAddrInBill());
		params.add(vendor.getTel());
		params.add(vendor.getTelInBill());
		return this.jdbcTemplate.update(sb.toString(), params.toArray());
	}

}
