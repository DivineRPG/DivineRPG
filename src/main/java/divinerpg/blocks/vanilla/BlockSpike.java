package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.*;
import divinerpg.util.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockSpike extends BlockMod {
    private final boolean isHot;

    public BlockSpike(boolean isHot) {
        super(Block.Properties.of(Material.METAL).strength(3).requiresCorrectToolForDrops());
        this.isHot = isHot;
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter block, Entity entityIn){
        if (isHot) {
            if (entityIn instanceof LivingEntity) {
                entityIn.hurt(DamageSources.spikeSource, 8);
                entityIn.setSecondsOnFire(10);
            }
        } else {
            if (entityIn instanceof LivingEntity) {
                entityIn.hurt(DamageSources.spikeSource, 5);
            }
        }
    }

}
