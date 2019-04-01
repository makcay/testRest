package com.mock;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;

@RestController
public class fileMockController {

    @RequestMapping("/fileMock")
    public String fileMock(@RequestParam(value="fileName", defaultValue="test.json") String fileName){
        String prefix="files/";
        return readFile(prefix+fileName);
    }

    private String readFile(String filename)
    {
        StringBuffer records = new StringBuffer();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null){
                records.append(line);
            }
            reader.close();
            return records.toString();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
}
