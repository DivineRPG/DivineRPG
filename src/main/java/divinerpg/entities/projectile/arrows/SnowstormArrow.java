package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.SNOWSTORM_ARROW;
import static divinerpg.registries.ItemRegistry.snowstorm_arrow;

public class SnowstormArrow extends DivineArrow {
    public SnowstormArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public SnowstormArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(SNOWSTORM_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public SnowstormArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(SNOWSTORM_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(snowstorm_arrow.get());}
    @Override public byte getPierceLevel() {return 0;}
    @Override protected void doPostHurtEffects(LivingEntity entity) {
        if(!level().isClientSide()) level().explode(this, xo, yo, zo, 3, false, Level.ExplosionInteraction.NONE);
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        if(!level().isClientSide()) level().explode(this, xo, yo, zo, 3, false, Level.ExplosionInteraction.NONE);
        discard();
    }
}