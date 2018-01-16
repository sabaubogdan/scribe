package xyz.vegaone.scribe.service;

import java.util.List;
import java.util.Map;

public interface FileDiscoveryService {
    Map<String, List<String>> discoverFiles(String directoryPath);
}
