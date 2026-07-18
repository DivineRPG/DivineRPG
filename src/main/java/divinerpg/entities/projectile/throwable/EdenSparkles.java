package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.*;

import java.util.List;

import static divinerpg.registries.ItemRegistry.eden_sparkles;
import static net.minecraft.sounds.SoundEvents.FIREWORK_ROCKET_BLAST;

public class EdenSparkles extends DivineThrownItem {
    public EdenSparkles(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {super(entityType, level);}
    @Override protected void onHit(HitResult result) {
        super.onHit(result);
        drop();
    }
    @Override public void drop() {
        level().setBlock(blockPosition(), Blocks.FIRE.defaultBlockState(), 3);
        playSound(FIREWORK_ROCKET_BLAST);
        level().broadcastEntityEvent(this, (byte)3);
        discard();
    }
    @Override public void handleEntityEvent(byte id) {
        if(id == 3) {
            Vec3 vec3 = getDeltaMovement();
            level().createFireworks(getX(), getY(), getZ(), vec3.x, vec3.y, vec3.z, List.of(new FireworkExplosion(FireworkExplosion.Shape.SMALL_BALL, IntList.of(14003720), IntList.of(5255174), false, true)));
        }
    }
    @Override protected Item getDefaultItem() {return eden_sparkles.get();}
}