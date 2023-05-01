package helpers;

import hookFiles.hooks;
import org.apache.commons.io.FileUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class utility {

    public static void writeToFile(String filePath, String textToBeWritten) throws IOException {
        FileWriter fw = new FileWriter(filePath,true);
        PrintWriter pw = new PrintWriter(fw, false);
        pw.println(textToBeWritten);
        pw.close();
    }

    public static List<Integer> minMaxValue(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int min=Integer.MAX_VALUE;
        int max = 0;
        List<Integer> arr = new ArrayList<Integer>();
        while((line = br.readLine()) != null){
            String line1 = line.replaceAll("[^0-9]", "");
            int test = Integer.parseInt(line1);
            if(test > max) {
                max = test;
            }
            if(test < min){
                min=test;
            }
        }
        arr.add(min);
        arr.add(max);
        br.close();
        fr.close();
        return arr;
    }

    public static void takeScreenshot(String fileName){
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(hooks.driver);
        try {
            ImageIO.write(screenshot.getImage(),"PNG",new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteFileIfExists(String filePath) throws IOException {
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
        }
        else {
            file.createNewFile();
        }
    }
}
