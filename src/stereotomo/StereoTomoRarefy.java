package stereotomo;

import java.io.*;

public class StereoTomoRarefy {
    private static final int HEADER_SIZE = 3;
    private final int step;

    public StereoTomoRarefy(int step) {
        this.step = step;
    }
    public StereoTomoRarefy() {
        this(2);
    }
    public void rarefy(String name) {
        String saveName = name.substring(0, name.length() - ".txt".length()) + "_rarefied" + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(name));
             BufferedWriter writer = new BufferedWriter(new FileWriter(saveName));) {
            long lineCount = 0;
            String line = null;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount <= HEADER_SIZE || lineCount > HEADER_SIZE && lineCount % step == 0) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
