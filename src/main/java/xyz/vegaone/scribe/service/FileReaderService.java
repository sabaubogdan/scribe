package xyz.vegaone.scribe.service;

import xyz.vegaone.scribe.dto.FileDto;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileReaderService {
    Map<Integer, String> contentReaderPdf(String path) throws IOException;

    List<FileDto> contentReaderPdfList(List<String> pathList) throws IOException;

    Map<Integer, String> contentReaderExcel();

    Map<Integer, String> contentReaderWord();
}
