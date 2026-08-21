package com.synergiz.itctc.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.synergiz.itctc.service.InspectionFileStorageService;

@Service
public class InspectionFileStorageServiceImpl implements InspectionFileStorageService {

	private final Path selfieUploadPath;
	private final Path documentUploadPath;

	public InspectionFileStorageServiceImpl(@Value("${inspection.upload.selfies}") String selfieUploadDirectory,
			@Value("${inspection.upload.documents}") String documentUploadDirectory) {

		this.selfieUploadPath = Paths.get(selfieUploadDirectory);
		this.documentUploadPath = Paths.get(documentUploadDirectory);

		createDirectoryIfNotExists(selfieUploadPath);
		createDirectoryIfNotExists(documentUploadPath);

	}

	// =========================================================
	// SAVE SELFIE
	// =========================================================

	@Override
	public String saveSelfie(MultipartFile file, String formCode, Long referenceId) {

		validateFile(file);

		String extension = getExtension(file.getOriginalFilename());

		String generatedFileName = formCode + "-" + referenceId + extension;

		Path targetPath = selfieUploadPath.resolve(generatedFileName);

		try {

			Files.copy(file.getInputStream(), targetPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {

			throw new RuntimeException("Failed to save selfie file : " + generatedFileName, e);
		}

		return generatedFileName;
	}

	// =========================================================
	// SAVE ATTACHMENT
	// =========================================================

	@Override
	public String saveAttachment(MultipartFile file, String formCode, Long referenceId, int attachmentNumber) {

		validateFile(file);

		String extension = getExtension(file.getOriginalFilename());

		String generatedFileName = formCode + "-" + referenceId + "-" + attachmentNumber + extension;

		Path targetPath = documentUploadPath.resolve(generatedFileName);

		try {

			Files.copy(file.getInputStream(), targetPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {

			throw new RuntimeException("Failed to save attachment file : " + generatedFileName, e);
		}

		return generatedFileName;
	}

	// =========================================================
	// DELETE SELFIE
	// =========================================================

	@Override
	public void deleteSelfie(String fileName) {

		if (fileName == null || fileName.trim().isEmpty()) {
			return;
		}

		deleteFile(selfieUploadPath, fileName);
	}

	// =========================================================
	// DELETE ATTACHMENT
	// =========================================================

	@Override
	public void deleteAttachment(String fileName) {

		if (fileName == null || fileName.trim().isEmpty()) {
			return;
		}

		deleteFile(documentUploadPath, fileName);
	}

	// =========================================================
	// VALIDATE FILE
	// =========================================================

	private void validateFile(MultipartFile file) {

		if (file == null || file.isEmpty()) {

			throw new IllegalArgumentException("Uploaded file is empty or missing.");
		}
	}

	// =========================================================
	// GET FILE EXTENSION
	// =========================================================

	private String getExtension(String originalFileName) {

		if (originalFileName == null || originalFileName.trim().isEmpty()) {

			throw new IllegalArgumentException("Original file name is missing.");
		}

		int lastDot = originalFileName.lastIndexOf('.');

		if (lastDot == -1) {

			throw new IllegalArgumentException("File extension is missing.");
		}

		return originalFileName.substring(lastDot).toLowerCase();
	}

	// =========================================================
	// CREATE DIRECTORY
	// =========================================================

	private void createDirectoryIfNotExists(Path path) {

		try {

			Files.createDirectories(path);

		} catch (IOException e) {

			throw new RuntimeException("Unable to create upload directory : " + path, e);
		}
	}

	// =========================================================
	// DELETE FILE
	// =========================================================

	private void deleteFile(Path directory, String fileName) {

		try {

			Path filePath = directory.resolve(fileName).normalize();

			// Security check
			if (!filePath.getParent().equals(directory.normalize())) {

				throw new IllegalArgumentException("Invalid file name.");
			}

			Files.deleteIfExists(filePath);

		} catch (IOException e) {

			throw new RuntimeException("Failed to delete file : " + fileName, e);
		}
	}
}