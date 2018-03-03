package main.java.vendor;
import java.util.Collections;
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
	
	public List<Vendor> getVendors() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM VENDOR.VENDOR ");
		List<Vendor> vendors = this.jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<Vendor>(Vendor.class));
		if(vendors.isEmpty()) {
			return Collections.emptyList();
		}
		return vendors;
	}

	public int add(Vendor vendor) {
		StringBuilder sb = new StringBuilder();
		List<Object> params = new LinkedList<Object>();
		sb.append("INSERT INTO VENDOR.VENDOR (NAME, TYPE, ADDR, ADDR_IN_BILL, TEL, TEL_IN_BILL, IS_ACTIVE, CREATE_DATE, UPDATE_DATE) ");
		sb.append("VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())" );
		params.add(vendor.getName());
		params.add(vendor.getType());
		params.add(vendor.getAddr());
		params.add(vendor.getAddrInBill());
		params.add(vendor.getTel());
		params.add(vendor.getTelInBill());
		params.add(vendor.getActive());
		return this.jdbcTemplate.update(sb.toString(), params.toArray());
	}

	public int edit(Vendor vendor) {
		StringBuilder sb = new StringBuilder();
		List<Object> params = new LinkedList<Object>();
		sb.append(" UPDATE VENDOR.VENDOR SET NAME = ?, TYPE = ?, ADDR = ?,");
		sb.append(" ADDR_IN_BILL = ?, TEL = ?, TEL_IN_BILL = ?, IS_ACTIVE = ?, UPDATE_DATE = NOW() ");
		sb.append(" WHERE ID = ? ");
		params.add(vendor.getName());
		params.add(vendor.getType());
		params.add(vendor.getAddr());
		params.add(vendor.getAddrInBill());
		params.add(vendor.getTel());
		params.add(vendor.getTelInBill());
		params.add(vendor.getActive());
		params.add(vendor.getId());
		return this.jdbcTemplate.update(sb.toString(), params.toArray());
	}

	public int delete(int id) {
		StringBuilder sb = new StringBuilder();
		List<Object> params = new LinkedList<Object>();
		sb.append(" UPDATE VENDOR.VENDOR SET IS_ACTIVE = 'Y', UPDATE_DATE = NOW()");
		sb.append(" WHERE ID = ? ");
		params.add(id);
		return this.jdbcTemplate.update(sb.toString(), params.toArray());
	}

	public List<Vendor> findById(int id) {
		StringBuilder sb = new StringBuilder();
		List<Object> params = new LinkedList<Object>();
		sb.append(" SELECT * FROM VENDOR.VENDOR WHERE ID = ? ");
		params.add(id);
		return this.jdbcTemplate.query(sb.toString(),params.toArray(), new BeanPropertyRowMapper<Vendor>(Vendor.class));
	}

}
