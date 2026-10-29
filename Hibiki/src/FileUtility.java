import java.io.*;
import java.util.*;

public class FileUtility {

    public static List<File> getFiles(String directory, String selfName) {
        List<File> files = new ArrayList<>();
        File dir = new File(directory);
        File[] entries = dir.listFiles();
        if (entries == null) return files;
        for (File f : entries) {
            if (f.isFile() && !f.getName().equals(selfName)) {
                files.add(f);
            }
        }
        return files;
    }

    public static byte[] readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return data;
    }

    public static void writeFile(File file, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    }
}
