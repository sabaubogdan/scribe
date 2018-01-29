package xyz.vegaone.scribe.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import xyz.vegaone.scribe.dto.FileDto;

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
    public Map<Integer, String> contentReaderPdf(String path) throws IOException {

        Map<Integer, String> pageNumberAndText = new HashMap<>();

        File file = new File(path);

        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        int page = 1;

        while (page <= document.getNumberOfPages()) {
            pdfTextStripper.setStartPage(page);
            pdfTextStripper.setEndPage(page);
            String pageContent = pdfTextStripper.getText(document);
            pageNumberAndText.put(page, pageContent);
            page++;
        }

        document.close();

        return pageNumberAndText;
    }

    @Override
    public List<FileDto> contentReaderPdfList(List<String> pathList) throws IOException {
        List<FileDto> fileDtoList = new ArrayList<>();

        for (String path : pathList) {
            FileDto fileDto = new FileDto();

            fileDto.setPath(path);
            fileDto.setFileContent(contentReaderPdf(path));

            fileDtoList.add(fileDto);
        }

        return fileDtoList;
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

