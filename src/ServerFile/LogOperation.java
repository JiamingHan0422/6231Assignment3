package ServerFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogOperation {

    String writeline;
    File logfile;

    public LogOperation(){
        this.logfile = null;
        this.writeline = "";
    }

    public void writeLog(String writeline, File file) {
        this.logfile = file;
        this.writeline = writeline;

        if (!file.exists())
            return;
        try {
            synchronized (file) {
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(writeline);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
