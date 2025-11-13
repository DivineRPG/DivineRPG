package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class BlockModPillar extends RotatedPillarBlock {
    public BlockModPillar(MapColor color, float hardness, float resistance, SoundType sound) {
        super(Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).sound(sound));
    }
    //Unbreakable
    public BlockModPillar(MapColor color, SoundType sound) {
        super(Properties.of().mapColor(color).strength(-1, 3600000).noLootTable().sound(sound));
    }
}