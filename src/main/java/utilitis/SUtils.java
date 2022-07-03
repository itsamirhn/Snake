package utilitis;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SUtils {

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
    public static void playSoundByName(String path){
        try {
            File yourFile = new File("assets/" + path);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        }
        catch (Exception e) {
            System.out.println("404.File Not Found.");
        }
    }
}
