package com.vanin.techdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class TechDemoApplication {

	private final DiskService diskService;

	@Autowired
	public TechDemoApplication(DiskService diskService) {
		this.diskService = diskService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TechDemoApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	ModelAndView getDisk() {
		String diskName = null;
		if (null != diskService.getDisk("Sergey")) {
			diskName = diskService.getDisk("Sergey").getName();
		}
		return new ModelAndView("disks/search", "found", diskName);
	}

	@RequestMapping("/createDisk")
	@ResponseBody
	@Transactional(readOnly = true)
	String createNewDisk() {
		return diskService.getDisk( "Sergey").getName();
	}

	@RequestMapping("/createUser")
	@ResponseBody
	@Transactional(readOnly = true)
	String createUser() {
		return diskService.getDisk("Sergey").getName();
	}

	@RequestMapping("/listOfFreeDisks")
	@ResponseBody
	@Transactional(readOnly = true)
	Page<Disk> listOfFreeDisks() {
		return diskService.getFreeDisks();
	}

	@RequestMapping("/listOfDisksHoldingByUser")
	@ResponseBody
	@Transactional(readOnly = true)
	Page<Disk> listOfDisksHoldingByUser() {
		return diskService.disksByHolder( "Sergey");
	}

	@RequestMapping("/listOfDisksByUserWhoHolds")
	@ResponseBody
	@Transactional(readOnly = true)
	Page<Disk> listOfDisksByUserWhoHolds() {
		return diskService.disksByOwnerWhoHolds("Sergey");
	}

}
