package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static divinerpg.registries.ItemRegistry.tomato;
import static net.minecraft.core.particles.ParticleTypes.ITEM;
import static net.minecraft.sounds.SoundEvents.HONEY_BLOCK_BREAK;

public class Tomato extends DivineThrownItem {
    public Tomato(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        drop();
    }

    @Override
    public void drop() {
        playSound(HONEY_BLOCK_BREAK);
        level().broadcastEntityEvent(this, (byte) 3);
        discard();
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) for (int i = 0; i < 8; ++i)
            level().addParticle(new ItemParticleOption(ITEM, ItemStackTemplate.fromNonEmptyStack(getItem())), getX(), getY(), getZ(), (random.nextFloat() - .5) * .08, (random.nextFloat() - .5) * .08, (random.nextFloat() - .5) * .08);
    }

    @Override
    protected Item getDefaultItem() {
        return tomato.get();
    }
}