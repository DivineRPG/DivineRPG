package divinerpg.structure.base;

import divinerpg.DivineRPG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

public abstract class DivineFixedAltitudeStructure extends DivineLargeStructure {
    protected int spawnAltitude;
    private int chunkDistance; //Moved here for now so I can test

    public DivineFixedAltitudeStructure(World world, String structureName, ResourceLocation folder, int chunkDistance, int spawnAltitude) {
        super(world, structureName, folder, chunkDistance);
        this.spawnAltitude = spawnAltitude;
        this.chunkDistance = chunkDistance;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        int i = chunkX;
        int j = chunkZ;
        if (chunkX < 0) {
            i = chunkX - chunkDistance - 1;
        }

        if (chunkZ < 0) {
            j = chunkZ - chunkDistance - 1;
        }

        int k = i / chunkDistance;
        int l = j / chunkDistance;

        int folderHash = folder.hashCode();

        Random random = this.world.setRandomSeed(k, l, folderHash);
        k *= chunkDistance;
        l *= chunkDistance;

        int smallerParameter = (int) (chunkDistance * 0.75);

        k += (random.nextInt(smallerParameter) + random.nextInt(smallerParameter)) / 2;
        l += (random.nextInt(smallerParameter) + random.nextInt(smallerParameter)) / 2;
        return chunkX == k && chunkZ == l;
    }
}
