package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityAyeracoBlue extends EntityAyeraco {

    public EntityAyeracoBlue(World worldIn) {
        super(worldIn);
    }

    public EntityAyeracoBlue(World world, BlockPos beam) {
        super(world, beam, LootTableRegistry.ENTITIES_AYERACO_BLUE);
    }
    
    @Override
    public Color getBarColor() {
        return Color.BLUE;
    }
}
