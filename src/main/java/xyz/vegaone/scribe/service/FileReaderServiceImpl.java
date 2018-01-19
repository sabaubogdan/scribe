package xyz.vegaone.scribe.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public Map<Integer, String> contentReaderPdf() throws IOException {

        Map<Integer, String> pageNumberAndText = new HashMap<>();

        List<String> textFromFile = new ArrayList<>();

        FileDiscoveryServiceImpl fileDiscoveryService = new FileDiscoveryServiceImpl();
        List<String> name = fileDiscoveryService.discoverFiles("C:\\Test").get("pdf");

        for (int i = 0; i < name.size(); i++) {

            File file = new File(name.get(i));

            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            int firstPage = 1;

            while (firstPage <= document.getNumberOfPages()) {

                pdfTextStripper.setStartPage(firstPage);
                pdfTextStripper.setEndPage(firstPage);
                textFromFile.add(pdfTextStripper.getText(document));
                pageNumberAndText.put(firstPage, textFromFile.toString());
                firstPage++;

            }
            document.close();

        }


        return pageNumberAndText;
    }

    @Override
    public Map<Integer, String> contentReaderExcel() {
        return null;
    }

    @Override
    public Map<Integer, String> contentReaderWord() {
        return null;
    }
}
