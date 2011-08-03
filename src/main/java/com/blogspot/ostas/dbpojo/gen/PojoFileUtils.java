package com.blogspot.ostas.dbpojo.gen;

import de.hunsicker.jalopy.Jalopy;
import org.apache.log4j.Logger;

import java.io.*;

public class PojoFileUtils {
    private static Logger logger = Logger.getLogger(PojoFileUtils.class);
    private Jalopy jalopy = null;
    public PojoFileUtils(String path)
    {
        try {
            final File f = new File(path);
            if(!f.exists()){
                f.mkdirs();
            }
            if(!path.endsWith(File.separator)) path+=File.separator;
            jalopy = new Jalopy();
        }catch(Exception e){
            logger.error(e);
        }
    }
    public void writeStringToFile(String string, String fileName, String path) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(path+fileName));
            out.write(string);
            out.close();
        } catch (IOException e) {
            logger.error(e);
        }
        formatCode(path+fileName);
    }
    public void formatCode(String file)
    {
        try {
            jalopy.setInput(new File(file));
            jalopy.setOutput(new File(file));
             // format and overwrite the given input file
            jalopy.format();

        if (jalopy.getState() == Jalopy.State.OK)
            logger.debug(file + " successfully formatted");
        else if (jalopy.getState() == Jalopy.State.WARN)
            logger.debug(file + " formatted with warnings");
        else if (jalopy.getState() == Jalopy.State.ERROR)
            logger.debug(file + " could not be formatted");
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
    }
}
