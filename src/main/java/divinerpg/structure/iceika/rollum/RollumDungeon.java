package divinerpg.structure.iceika.rollum;

import divinerpg.DivineRPG;
import divinerpg.structure.StructureRarities;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class RollumDungeon extends DivineLargeStructure {
    public RollumDungeon(World world) {
        super(world, "RollumDungeon", new ResourceLocation(DivineRPG.MODID, "iceika/dungeons/rollum"), StructureRarities.ROLLUM_DUNGEON_RARITY);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, x, z);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        int offset = this.rand.nextInt(40);
        return new RollumDungeonStart(folder, manager, rotation, offset, x, z);
    }
}
