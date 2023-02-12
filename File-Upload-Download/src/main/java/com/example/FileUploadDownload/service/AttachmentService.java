package com.example.FileUploadDownload.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.FileUploadDownload.entity.Attachment;

public interface AttachmentService {

    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
    
}
