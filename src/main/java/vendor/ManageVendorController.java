package main.java.vendor;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.base.BaseController;
@RestController("rest")
public class ManageVendorController extends BaseController{
	
	@Autowired
	VendorRepository vendorRepository;
	
	@GetMapping("vendors")
	public ResponseEntity<ArrayList<Vendor>> getVendors() {
		ArrayList<Vendor> vendors = this.vendorRepository.getVendors();
		return new ResponseEntity<ArrayList<Vendor>>(vendors, HttpStatus.OK);
	}
	
	@PostMapping("add/vendor")
	public ResponseEntity<ArrayList<Vendor>> addVendor(@RequestBody Vendor vendor) {
		int inserted = this.vendorRepository.addVendors(vendor);
		if(inserted != 0) {
			return new ResponseEntity<ArrayList<Vendor>>(HttpStatus.OK);
		}
		return new ResponseEntity<ArrayList<Vendor>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
