package com.synergy.recupro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.synergy.recupro.model.Document;

public interface IAws3Service {

	List<Document> upload(MultipartFile[] multipartFiles,Long id);

	List<S3ObjectSummary> list();

}