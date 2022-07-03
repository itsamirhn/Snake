package utilitis;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class SUtils {

    public static File getResourceFile(String path) throws FileNotFoundException {
        URL url = SUtils.class.getClassLoader().getResource(path);
        if (url == null) throw new FileNotFoundException("Resource not found: " + path);
        return new File(url.getFile());
    }

    public static boolean getRandomProbability(float probability) {
        return Math.random() < probability;
    }

    public static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }
    public static int getRandomInt(int min, int max) {
        return min + getRandomInt(max - min);
    }

    public static Toml loadTOML(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) throw new FileNotFoundException();
        return new Toml().read(file);
    }

    public static <T> T loadFromTOML(String filePath, Class<T> targetClass) throws FileNotFoundException {
        return loadTOML(filePath).to(targetClass);
    }

    public static void saveToTOML(String filePath, Object obj) throws IOException {
        File file = new File(filePath);
        new TomlWriter().write(obj, file);
    }
    public static synchronized void playSoundByName(String name) {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(getResourceFile("sounds/%s.wav".formatted(name)));
                clip.open(inputStream);
                clip.addLineListener(event -> { if (event.getType() == LineEvent.Type.STOP) clip.close(); });
                clip.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }
}
