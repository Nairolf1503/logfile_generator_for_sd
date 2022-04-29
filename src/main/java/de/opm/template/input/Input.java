package de.opm.template.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Input {
    /**
     * 
     * @param path_to_file path to a file containing JSON-information
     * @return JSONObject containing information from file under path
     * @throws JSONException when no JSON could be parsed
     * @throws IOException on IOExceptions (i e no file found, no read access)
     */
    public static JSONObject getJSONFromFile(String path_to_file) throws JSONException, IOException{
        File file = new File(path_to_file);

        if(!file.isFile()){
            throw new FileNotFoundException(file.getName() + " was not found");
        }

        JSONObject json = getJSONFromFile(file);

        return json;
    }

    /**
     * 
     * @param path_to_directory Path to directory containing multiple files which should contain json
     * @return Array of each JSONObject read from files. Files containing no or invalid json are skipped and don't throw and outbound exception
     * @throws IOException on IOErrors
     */
    public static JSONObject[] getJSONFromFiles(String path_to_directory) throws IOException{
        File directory = new File(path_to_directory);

        if(!directory.isDirectory()){
            throw new IOException(path_to_directory + " is not a directory");
        }

        File[] files = directory.listFiles();

        List<JSONObject> json_list = new ArrayList<JSONObject>();
        for(File file : files){
            try{
                JSONObject json = getJSONFromFile(file);
                json_list.add(json);
            }catch(JSONException e){
                System.out.println(file.getName() + " does not containt valid JSON data");
            }catch(IOException e){
                System.out.println(file.getName() + " could not be read properly");
            }

        }

        int list_size = json_list.size();
        JSONObject[] json_arr = json_list.toArray(new JSONObject[list_size]);

        return json_arr;
    }

    /**
     * 
     * @param file containing JSON-information
     * @return JSON read rom file 
     * @throws JSONException when file does not contain valid JSON
     * @throws IOException on IO Errors
     */

    public static JSONObject getJSONFromFile(File file) throws JSONException, IOException{
        JSONObject json = FileJSON.getJSONFromFile(file);
        return json;
    }
}
