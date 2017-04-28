package corridor;

public class CorridorConverterTest {
    public static void main(String[] arg) {
        CorridorConverter corridorConverter = new CorridorConverter();
        corridorConverter.readStackImagingCorridor();
        corridorConverter.convertStackImagingToZomfCorridor(0, 500, 1.5);
        corridorConverter.writeZomfCorridor();
    }
}
