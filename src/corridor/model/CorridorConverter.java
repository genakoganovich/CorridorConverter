package corridor.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CorridorConverter {
    private static final int HEADER_LINES = 13;
    private ArrayList<StackImagingEntry> stackImagingEntries;
    private ArrayList<ZomfCorridorEntry> zomfCorridorEntries;
    private static final String ZOMF_CORRIDOR_HEADER = "XCoord\tYCoord\tV\tA\tT\tDeltaV\tDeltaA\n";

    public CorridorConverter() {
        stackImagingEntries = new ArrayList<>();
        zomfCorridorEntries = new ArrayList<>();
    }
    public void read(String name) {
        File file = new File(name);
        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < HEADER_LINES; i++) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(scanner.nextLine());
                double x = lineScanner.nextDouble();
                double y = lineScanner.nextDouble();
                double h = lineScanner.nextDouble();
                double v = lineScanner.nextDouble();
                lineScanner.next();
                StackImagingEntry stackImagingEntry = new StackImagingEntry(x, y, h, v);
                stackImagingEntries.add(stackImagingEntry);
                System.out.println(stackImagingEntry);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void write(String name) {
        File file = new File(name);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(ZOMF_CORRIDOR_HEADER);
            for(ZomfCorridorEntry entry: zomfCorridorEntries) {
                writer.write(entry.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void convert(double a, double deltaV, double deltaA, double minVel) {
        for(StackImagingEntry entry: stackImagingEntries) {
            if (entry.horiz - deltaV < minVel) {
                double v = (entry.horiz + deltaV + minVel) / 2;
                double deltaVNew = v - minVel;
                zomfCorridorEntries.add(
                        new ZomfCorridorEntry(
                                entry.xCoord, entry.yCoord, v, a, entry.vert, deltaVNew, deltaA));
            } else {
                zomfCorridorEntries.add(
                        new ZomfCorridorEntry(
                                entry.xCoord, entry.yCoord, entry.horiz, a, entry.vert, deltaV, deltaA));
            }

        }
    }
    public void narrowZomfCorridor(String name, String addToName) {
        String saveName = new StringBuilder(new String(name.substring(0, name.lastIndexOf('.'))) )
                            .append(addToName)
                            .append(new String(name.substring(name.lastIndexOf('.'))))
                            .toString();

        try (BufferedReader reader = new BufferedReader(new FileReader(name));
             BufferedWriter writer = new BufferedWriter(new FileWriter(saveName));) {

            String line = null;
            long lineCount = 0;
            double time = 0;
            String[] elements = null;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount == 1) {
                    writer.write(line);
                } else {
                    elements = line.split("\\s+");
                    time = Double.parseDouble(elements[4]);
                    if (time > 1) {
                        elements[5] = Double.toString(50);
                    } else {
                        elements[5] = Double.toString(500 - 450 * time);
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < elements.length - 1; i++) {
                        sb.append(elements[i]).append("\t");
                    }
                    sb.append(elements[elements.length - 1]);
                    writer.write(sb.toString());
                }
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
