package main.java.vendor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.base.BaseController;
import main.java.base.Response;
@RestController()
@RequestMapping("rest")
@CrossOrigin("http://localhost:3000")
public class ManageVendorController extends BaseController{
	
	private static Logger log = Logger.getLogger( ManageVendorController.class.getName());
	
	@Autowired
	VendorRepository vendorRepository;
	
	@GetMapping("vendors")
	public ResponseEntity<Response> getVendors() {
		List<Vendor> vendors = this.vendorRepository.getVendors();
		return sendResponseSuccess(vendors);
	}
	
	@GetMapping("vendor/{id}")
	public ResponseEntity<Response> getVendor(@PathVariable int id) {
		List<Vendor> vendors = this.vendorRepository.findById(id);
		return sendResponseSuccess(vendors);
	}
	
	@PostMapping("add/vendor")
	public <T> ResponseEntity<Response> add(@RequestBody Vendor vendor) throws Exception {
		int inserted = this.vendorRepository.add(vendor);
		if(inserted != 0) {
			return sendResponseSuccess(vendor);
		}
		log.error("Cannot add for vendor id:" + vendor.getId());
		return sendResponseError();
	}
	
	@PostMapping("edit/vendor")
	public ResponseEntity<Response> edit(@RequestBody Vendor vendor) {
		List<Vendor> duplicateVendor = this.vendorRepository.findById(vendor.getId());
		if(duplicateVendor.size() == 0) {
			return sendResponseNotFound();
		}
		int update = this.vendorRepository.edit(vendor);
		if(update != 0) {
			return sendResponseSuccess();
		}
		return sendResponseError();
	}
	
	@PostMapping("delete/vendor/{id}")
	public ResponseEntity<Response> delete(@PathVariable (required = true) int id) {
		int update = this.vendorRepository.delete(id);
		if(update != 0) {
			return sendResponseSuccess();
		}
		return sendResponseNotFound();
	}
	
	
}
