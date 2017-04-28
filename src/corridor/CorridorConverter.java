package corridor;

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
    public void readStackImagingCorridor() {
        String name = "stack_imaging_corridor.corr";
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
    public void writeZomfCorridor() {
        String name = "zomf_corridor.corr";
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
    public void convertStackImagingToZomfCorridor(double a, double deltaV, double deltaA) {
        for(StackImagingEntry entry: stackImagingEntries) {
            zomfCorridorEntries.add(
                    new ZomfCorridorEntry(
                            entry.xCoord, entry.yCoord, entry.horiz, a, entry.vert, deltaV, deltaA));
        }
    }
}
