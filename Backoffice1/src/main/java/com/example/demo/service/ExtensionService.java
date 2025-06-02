package com.example.demo.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.metamodel.mapping.ordering.ast.PathConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Ext;
import com.example.demo.entity.ExtType;
import com.example.demo.pojo.InformationalExt;
import com.example.demo.repository.ExtRepository;
import com.example.demo.repository.ExtTypesRepository;

@Service
public class ExtensionService {

	@Autowired
	private ExtRepository extRepository;

	@Autowired
	private ExtTypesRepository extTypesRepository;

	@Value("${file.upload.image.path}")
	private String UPLOAD_FILE_PATH;

	public void saveTypesOfExtenion(ExtType extType) {
		extTypesRepository.save(extType);
	}

	public ExtType getExtTypesDetials(int extTypeId) {
		return extTypesRepository.findById(extTypeId).get();
	}

	public Ext saveInformationalExtension(Ext exts) throws Exception {
		Optional<Ext> ext = extRepository.verifyExtById(exts.getExtId());
		System.out.println(ext.toString());
		if (ext.isPresent()) {
			throw new Exception("Extension already exists.");
		}
		Ext extusers = extRepository.save(exts);
		return extusers;
	}
	public void uploadAudioFiles(MultipartFile inpuFile) throws Exception {
		String inputFileWithSanitization = StringUtils.cleanPath(inpuFile.getOriginalFilename());
		String fileExt = StringUtils.getFilenameExtension(inputFileWithSanitization);
		System.out.println(fileExt);
		String[] fileExtsallowed = { "wav", "mp3", "WAV", "MP3" };

		Boolean isextallowed = Arrays.stream(fileExtsallowed).anyMatch(fileExt::equals);
		if (isextallowed == false) {
			throw new Exception("mp3 and wav ext files are allowed");
		}
		int FILE_SIZE = 1024 * 1024;

		if (FILE_SIZE < inpuFile.getSize()) {
			throw new Exception("1 MB file is only allowed");
		}

		String filename = UUID.randomUUID().toString() + "." + fileExt;
		System.out.println(filename);

		Path uploadfilepath = Paths.get(UPLOAD_FILE_PATH + filename);
		Files.copy(inpuFile.getInputStream(), uploadfilepath);

	}

}
