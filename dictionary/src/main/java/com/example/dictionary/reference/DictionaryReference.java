package com.example.dictionary.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Component
public class DictionaryReference {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryReference.class.getName());

    private static Map<String, String> dictionary;

    static {
        try {
            readDictionaryFile();
        } catch (Exception e) {
            logger.error("There was a problem reading the dictionary file");
        }
    }

    private DictionaryReference() {
    }

    private static void readDictionaryFile() throws UnsupportedEncodingException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // Implementation to read the dictionary file and populate the 'dictionary' map

        InputStream inputStream = DictionaryReference.class.getClassLoader()
                        .getResourceAsStream("dictionary.json");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // TODO: Parse the JSON and populate the dictionary map

        stopWatch.stop();
        long milliseconds = stopWatch.getLastTaskTimeMillis();
        String message = new StringBuilder().append("Dictionary created with ")
                                            .append(dictionary.size())
                                            .append(" entries in ")
                                            .append(milliseconds)
                                            .append("ms")
                                            .toString();
        logger.info(message);
    }
}
