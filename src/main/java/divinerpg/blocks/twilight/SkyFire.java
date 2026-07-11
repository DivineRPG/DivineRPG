package divinerpg.blocks.twilight;

import divinerpg.blocks.base.PortalBlock;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.LevelRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static net.minecraft.sounds.SoundEvents.BREEZE_JUMP;
import static net.minecraft.sounds.SoundSource.BLOCKS;

public class SkyFire extends PortalFire {
    public SkyFire() {super(2);}
    @Override public PortalBlock getPortalBlock(Level level, BlockState frame, byte timeOfDay) {
        return frame.is(BlockRegistry.skythernBlock) && (timeOfDay == 3 || (timeOfDay == 2 && level.dimension() == LevelRegistry.SKYTHERN)) ? (PortalBlock) BlockRegistry.skythernPortal.get() : null;
    }
    @Override public Block getRift(byte timeOfDay) {
        return timeOfDay == 3 ? BlockRegistry.skythernRift.get() : null;
    }
    @Override protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if(entity instanceof ItemEntity) return;
        boolean canJump = !level.getBlockCollisions(entity, entity.getBoundingBox().expandTowards(0, 2, 0)).iterator().hasNext();
        Vec3 vec3 = entity.getDeltaMovement();
        if(!entity.isSuppressingBounce() && canJump && !(entity instanceof Player player && player.getAbilities().flying)) {
            //TODO: holding the shift down at the right timing causes the sound to play, but ignore the launch (seems like the reason is that setDeltaMovement doesn't apply immediately)
            entity.setDeltaMovement(new Vec3(vec3.x, 3, vec3.z));
            entity.hasImpulse = true;
            //TODO: the sound plays multiple times while inside of the fire, would be nicer if only once
            level.playSound(null, pos, BREEZE_JUMP, BLOCKS);
        }
    }
}