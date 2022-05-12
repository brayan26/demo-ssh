package com.example.demo.application.helm.version;

import com.example.demo.domain.helm.HelmResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class FindVersions {
    private static final String DEFAULT_FILE_YAML = "Chart.yaml";
    private static final String DEFAULT_FILE_YML = "Chart.yml";
//    private static final String DEFAULT_SLOT = "chart_slot";
    private static final String REGEX_EXPRESSION = "(\\\\|\\/)Chart\\.(yaml|yml)$";

    @Value("${helm.path.base}")
    String folder;

    public List<HelmResponse> find() throws IOException {
        List<HelmResponse> list = new ArrayList<>();
        Files.walk(Paths.get(folder),2)
                .filter(Files::isRegularFile)
                .filter(path -> DEFAULT_FILE_YAML.contains(path.getFileName().toString()) ||
                        DEFAULT_FILE_YML.contains(path.getFileName().toString()))
                .forEach(path -> {
                    try {
                        //Prepare file to read
                        InputStream is = new FileInputStream(path.toFile().getPath());
                        //Read file
                        Yaml yaml = new Yaml();
                        Map<String, Object> data = yaml.load(is);

                        //Set values
                        HelmResponse helmResponse = new HelmResponse();
                        helmResponse.setName((String) data.get("name"));
                        helmResponse.setVersion((String) data.get("version"));
                        //Parse path
                        String directory = path.toFile().getPath();
                        directory = directory.replaceAll(REGEX_EXPRESSION, "");
                        helmResponse.setPath(directory);

                        //Accumulate objects
                        list.add(helmResponse);
                        //Close buffer
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        return list;
    }
}
