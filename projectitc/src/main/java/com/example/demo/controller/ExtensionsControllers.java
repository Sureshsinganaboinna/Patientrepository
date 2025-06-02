package com.example.demo.controller;

import java.util.List;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmCompositeIndexType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.apiresponse.ApiResponse;
import com.example.demo.entity.Ext;
import com.example.demo.entity.ExtType;
import com.example.demo.pojo.InformationalExt;
import com.example.demo.service.ExtensionService;


@RestController
public class ExtensionsControllers {
	
	@Autowired
	private ExtensionService extensionService;
	
	@PostMapping("/InfoExt")
	public ResponseEntity<ApiResponse<Ext>> saveAndGetExtDetails( @RequestParam String extId,
	        @RequestParam String displayName,
	        @RequestParam String description,
	        @RequestParam String FollowUptext,
	        @RequestParam Integer extTypeId,
	        @RequestParam("file") MultipartFile inpFile) throws Exception
	{
		
		ExtType ext	= extensionService.getExtTypesDetials(extTypeId);
	        	  // Create InformationalExt object manually
		System.out.println(ext);
		Ext exts = new Ext();
		exts.setExtId(extId);
		exts.setDescription(description);
		exts.setDisplayName(displayName);
		exts.setFollowUptext(FollowUptext);
        exts.setExtTypes(ext);
	extensionService.uploadAudioFiles(inpFile);
	 Ext response =	extensionService.saveInformationalExtension(exts);
	 ApiResponse<Ext> response2 = new ApiResponse<Ext>("success", "OK", response);
	 return ResponseEntity.status(HttpStatus.OK).body(response2);
	 
	}
	
	@PostMapping("/Exttypes")
	public void extTypes(@RequestBody ExtType extType)
	{
		System.out.println(extType.toString());
		extensionService.saveTypesOfExtenion(extType);
	}

}
