package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityAyeracoRed extends EntityAyeraco {

    public EntityAyeracoRed(World worldIn) {
        super(worldIn);
    }

    public EntityAyeracoRed(World world, BlockPos beam) {
        super(world, beam, LootTableRegistry.ENTITIES_AYERACO_RED);
    }
    
    @Override
    public Color getBarColor() {
        return Color.RED;
    }
}
