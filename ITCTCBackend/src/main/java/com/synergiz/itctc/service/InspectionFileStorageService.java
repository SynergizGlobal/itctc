package com.synergiz.itctc.service;

import org.springframework.web.multipart.MultipartFile;

public interface InspectionFileStorageService {

    /**
     * Saves a selfie file and returns the generated file name.
     */
    String saveSelfie(
            MultipartFile file,
            String formCode,
            Long referenceId);

    /**
     * Saves an attachment/document and returns the generated file name.
     */
    String saveAttachment(
            MultipartFile file,
            String formCode,
            Long referenceId,
            int attachmentNumber);

    /**
     * Deletes a selfie file if it exists.
     */
    void deleteSelfie(String fileName);

    /**
     * Deletes an attachment/document if it exists.
     */
    void deleteAttachment(String fileName);
}