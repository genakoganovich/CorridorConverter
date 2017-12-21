package corridor.test;

import corridor.model.CorridorConverter;

public class CorridorConverterTest {
    public static void main(String[] arg) {
        CorridorConverter corridorConverter = new CorridorConverter();
        corridorConverter.read("002_94-021-vel-final-redone.15855_vel002.corr");
        corridorConverter.convert(0, 1000, 1.5, 1500);
        corridorConverter.write("001_F94SBT-021_zomf_corr002_1000.corr");
    }
}
