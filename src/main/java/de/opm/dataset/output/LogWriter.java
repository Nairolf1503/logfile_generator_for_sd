package de.opm.dataset.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class LogWriter {
    private File logfile;
    
    private BufferedWriter output = null;

    /**
     * 
     * @param path_to_file location to the file which will be written to (will be created or overwritten)
     */
    public LogWriter(String path_to_file){
        try {
            logfile = new File(path_to_file);
            logfile.createNewFile();
            clearFile();
            output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logfile, true), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace(); 
            System.exit(0);
        }
    }

    /**
     * 
     * @param line written to the File
     * @throws IOException
     */
    public void writeLineToLogFile(String line) throws IOException{
        output.append(line + "\n");
    }

    /**
     * closes OutputStream
     * @throws IOException
     */
    public void closeWriter() throws IOException{
        output.close();
    }

    /**
     * removes contents from a file
     * @throws FileNotFoundException
     */
    private void clearFile() throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(logfile);
        writer.print("");
        writer.close();
    }
}
