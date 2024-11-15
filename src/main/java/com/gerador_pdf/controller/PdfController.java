package com.gerador_pdf.controller;

import com.gerador_pdf.service.PdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()
public class PdfController {

    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf() throws Exception {

        // Gerar o PDF
        byte[] pdfContent = pdfGeneratorService.generatePdf();

        // Retornar o PDF como HTTP
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=documento.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }

}
