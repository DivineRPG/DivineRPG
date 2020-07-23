package divinerpg.utils;

public class SpawnEggColors {

    public enum Dimension {
        OVERWORLD, NETHER, END, ICEIKA, EDEN, WILDWOOD, APALACHIA, SKYTHERN, MORTUM, ARCANA, VETHEA, BOSS
    }

    private final int primaryColor, secondaryColor;

    private SpawnEggColors(int primary, int secondary) {
        this.primaryColor = primary;
        this.secondaryColor = secondary;
    }

    public int getPrimaryColor() {
        return this.primaryColor;
    }

    public int getSecondaryColor() {
        return this.secondaryColor;
    }

    public static SpawnEggColors getColorsForDimension(Dimension dimension) {
        switch (dimension) {
            case OVERWORLD:
                return new SpawnEggColors(5240, 30740);

            case NETHER:
                return new SpawnEggColors(12126720, 5505024);

            case END:
                return new SpawnEggColors(15267765, 986904);

            case ICEIKA:
                return new SpawnEggColors(15132390, 3602682);

            case EDEN:
                return new SpawnEggColors(14661905, 8873984);

            case WILDWOOD:
                return new SpawnEggColors(675282, 729423);

            case APALACHIA:
                return new SpawnEggColors(8404128, 3284040);

            case SKYTHERN:
                return new SpawnEggColors(13684944, 3947580);

            case MORTUM:
                return new SpawnEggColors(1973790, 657930);

            case ARCANA:
                return new SpawnEggColors(1975950, 9936364);

            case VETHEA:
                return new SpawnEggColors(18012, 1504400);

            case BOSS:
                return new SpawnEggColors(11801600, 1315860);

            default:
                return new SpawnEggColors(16448250, 328965);
        }
    }
}