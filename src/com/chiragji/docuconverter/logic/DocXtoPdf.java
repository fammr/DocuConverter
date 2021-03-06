package com.chiragji.docuconverter.logic;

import com.chiragji.docuconverter.enums.PageSize;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Chirag Gupta (chirag-ji)
 */
public final class DocXtoPdf extends AbstractDocuConverter {

    DocXtoPdf(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void convertIn(OutputStream outputStream) throws Exception {
        setOutputStream(outputStream);
        onStart();
        XWPFDocument xwpfDocument = new XWPFDocument(this.inputStream);
        PdfOptions pdfOptions = PdfOptions.create();
        onProcessing();
        PDFConverter.convert(xwpfDocument, this.outputStream, pdfOptions);
        onCompleted();
    }

    @Override
    public void setPageSize(PageSize pageSize) {
        throw new UnsupportedOperationException();
    }
}
