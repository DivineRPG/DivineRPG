package divinerpg.blocks.twilight;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SkyFire extends TwilightFire {
    public SkyFire() {
        super(2F);
    }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if(entity instanceof ItemEntity) return;
        entity.addDeltaMovement(new Vec3(0, 3, 0));
        entity.hasImpulse = true;
        level.playSound(null, pos, SoundEvents.BREEZE_JUMP, SoundSource.BLOCKS);
    }
}