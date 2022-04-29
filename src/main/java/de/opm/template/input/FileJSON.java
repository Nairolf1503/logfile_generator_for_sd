package de.opm.template.input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONException;
import org.json.JSONObject;

public class FileJSON {
    /**
     * 
     * @param file Flie-instance, whose content will be attempted to be turned into a JSONObject
     * @return JSONObject containing the data from the file
     * @throws IOException on IO Errors (i.e. no file found, no read access)
     * @throws JSONException when no JSON could be parsed from the file-content
     */
    protected static JSONObject getJSONFromFile(File file) throws IOException, JSONException{
        Path path = file.toPath();

        Stream<String> lines = Files.lines(path);
        String file_content = lines.collect(Collectors.joining("\n"));
        lines.close();

        JSONObject json = new JSONObject(file_content);

        return json;
    }


}
