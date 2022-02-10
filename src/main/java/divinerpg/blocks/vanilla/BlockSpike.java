package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;
import divinerpg.util.DamageSources;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockSpike extends BlockMod {
    private final boolean isHot;

    public BlockSpike(String name, boolean isHot) {
        super(name, 3);
        this.isHot = isHot;
    }

    @Override
    public void updateEntityAfterFallOn(IBlockReader block, Entity entityIn){
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
