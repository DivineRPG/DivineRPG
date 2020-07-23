package divinerpg.config;

import net.minecraftforge.common.config.Configuration;

public class OreInfo {
    private String oreName;
    private int tries;
    private int vienSize;
    private int minY;
    private int maxY;

    public OreInfo(String name, int tries, int vienSize, int minY, int maxY) {
        this.oreName = name;
        this.tries = tries;
        this.vienSize = vienSize;
        this.minY = minY;
        this.maxY = maxY;
    }

    public void init(Configuration config, String category) {

        // As we see from MortumChunkGenerator, 70 blocks are TOO MUCH for worldgen
        tries = config.getInt(oreName + "Tries", category, tries, 1, 50,
                "Choose a number between 1 and 50 to choose the amount of times the " + oreName + " tries to spawn");

        vienSize = config.getInt(oreName + "VeinSize", category, vienSize, 1, 50,
                "Choose a number between 1 and 50 to tweak the vein size");

        minY = config.getInt(oreName + "MinHeight", category, minY, 1, 255,
                "Choose a number between 1 and 255 to choose the min " + oreName + " height");

        maxY = config.getInt(oreName + "MaxHeight", category, maxY, 1, 255,
                "Choose a number between 1 and 255 to choose the max " + oreName + " height");
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinY() {
        return minY;
    }

    public int getVienSize() {
        return vienSize;
    }

    public int getTries() {
        return tries;
    }
}
