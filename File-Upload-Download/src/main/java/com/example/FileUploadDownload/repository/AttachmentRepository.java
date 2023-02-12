package com.example.FileUploadDownload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FileUploadDownload.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {
    
}
