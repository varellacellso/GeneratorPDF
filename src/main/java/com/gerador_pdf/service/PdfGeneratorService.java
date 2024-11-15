package com.gerador_pdf.service;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGeneratorService {

    public byte[] generatePdf() throws IOException {

        // Criação de PDF
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Criar documento PDF
        PdfDocument pdfDoc = new PdfDocument(new com.itextpdf.kernel.pdf.PdfWriter(baos));
        Document document = new Document(pdfDoc);

        // Adicionar conteudo ao documento
        document.add(new Paragraph("Olá, este é um exemplo de PDF gerado com iText...")
                .setFontColor(ColorConstants.BLACK));

        // Fechar o documento
        document.close();

        // Retorna os bytes do PDF gerado
        return baos.toByteArray();
    }
}
