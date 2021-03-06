package utilitis;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.*;

public class SUtils {

    public static InputStream getResourceAsStream(String path) {
        return SUtils.class.getClassLoader().getResourceAsStream(path);
    }

    public static InputStream getIconAsStream() {
        return getResourceAsStream("images/icon.png");
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
                InputStream bufferedIn = new BufferedInputStream(getResourceAsStream("sounds/%s.wav".formatted(name)));
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
                clip.open(inputStream);
                clip.addLineListener(event -> { if (event.getType() == LineEvent.Type.STOP) clip.close(); });
                clip.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }
}
