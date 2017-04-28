package corridor;

public class CorridorConverterTest {
    public static void main(String[] arg) {
        CorridorConverter corridorConverter = new CorridorConverter();
        corridorConverter.read();
        corridorConverter.convert(0, 500, 1.5);
        corridorConverter.write();
    }
}
