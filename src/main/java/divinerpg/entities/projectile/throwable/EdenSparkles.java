package divinerpg.entities.projectile.throwable;

import it.unimi.dsi.fastutil.ints.IntList;
import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.ItemRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.rabbit.Rabbit;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static net.minecraft.sounds.SoundEvents.FIREWORK_ROCKET_BLAST;

public class EdenSparkles extends DivineThrownItem {
    private boolean flame = true;
    public EdenSparkles(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
        drop();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(result.getEntity() instanceof /*EntityGlinthop*/ Rabbit hop){
            if(level() instanceof ServerLevel) hop.setTarget(null);
            flame = false;
            drop();
        }else super.onHitEntity(result);
    }

    @Override
    public void drop() {
        if(flame) level().setBlock(blockPosition(), Blocks.FIRE.defaultBlockState(), 3);
        playSound(FIREWORK_ROCKET_BLAST);
        level().broadcastEntityEvent(this, (byte)3);
        discard();
    }

    @Override
    public void handleEntityEvent(byte id) {
    if(id == 3){
        Vec3 vec3 = getDeltaMovement();
        level().createFireworks(getX(), getY(), getZ(), vec3.x, vec3.y, vec3.z, List.of(new FireworkExplosion(FireworkExplosion.Shape.SMALL_BALL, IntList.of(14003720), IntList.of(5255174), false, true)));
    }
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.eden_sparkles.get();
    }
}
