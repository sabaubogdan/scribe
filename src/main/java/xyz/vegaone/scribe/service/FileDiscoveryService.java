package xyz.vegaone.scribe.service;

import java.util.List;

public interface FileDiscoveryService {
    List<String> discoverFiles(String directoryPath);
}
