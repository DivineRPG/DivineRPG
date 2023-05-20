package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;
import divinerpg.util.DamageSources;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockSpike extends BlockMod {
    private final boolean isHot;

    public BlockSpike(boolean isHot, MaterialColor color) {
        super(Block.Properties.of(Material.METAL, color).strength(5F, 6F).requiresCorrectToolForDrops().sound(SoundType.METAL));
        this.isHot = isHot;
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter block, Entity entityIn){
        if (isHot) {
            if (entityIn instanceof LivingEntity) {
                entityIn.hurt(DamageSources.source(entityIn.level, DamageSources.SPIKE), 8);
                entityIn.setSecondsOnFire(10);
            }
        } else {
            if (entityIn instanceof LivingEntity) {
                entityIn.hurt(DamageSources.source(entityIn.level, DamageSources.SPIKE), 5);
            }
        }
    }

}
