package divinerpg.objects.entities.entity.boss.ayeraco;

import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityAyeracoGreen extends EntityAyeraco {

    public EntityAyeracoGreen(World worldIn) {
        super(worldIn);
    }

    public EntityAyeracoGreen(World world, BlockPos beam) {
        super(world, beam, LootTableRegistry.ENTITIES_AYERACO_GREEN);
    }
    
    @Override
    public Color getBarColor() {
        return Color.GREEN;
    }
}
