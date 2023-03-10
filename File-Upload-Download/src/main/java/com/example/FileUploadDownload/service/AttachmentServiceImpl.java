package com.example.FileUploadDownload.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileUploadDownload.entity.Attachment;
import com.example.FileUploadDownload.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository){
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid path"+ fileName);
            }
            Attachment attachment = new Attachment(fileName, file.getContentType(),file.getBytes());
            return attachmentRepository.save(attachment);

        }catch(Exception e){
            throw new Exception("could not save file"+ fileName);

        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        // TODO Auto-generated method stub
        return attachmentRepository
            .findById(fileId)
            .orElseThrow(
                ()-> new Exception("File not found with Id: " + fileId));
    }
    
}
