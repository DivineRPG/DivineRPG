package divinerpg.structure.vethea.crypt1;

import divinerpg.DivineRPG;
import divinerpg.structure.StructureRarities;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.vethea.evergarden.EvergardenStart;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Crypt1 extends DivineFixedAltitudeStructure {

    public Crypt1(World world, int spawnAltitude) {
        super(world, "Crypt1", new ResourceLocation(DivineRPG.MODID, "vethea/layer1/crypt1"), StructureRarities.CRYPT_1_RARITY, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new Crypt1Start(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
