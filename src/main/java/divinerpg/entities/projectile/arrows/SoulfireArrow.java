package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.SOULFIRE_ARROW;
import static divinerpg.registries.ItemRegistry.soulfire_arrow;
import static net.minecraft.world.level.Level.ExplosionInteraction.TNT;

public class SoulfireArrow extends DivineArrow {
    public SoulfireArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public SoulfireArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(SOULFIRE_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public SoulfireArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(SOULFIRE_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(soulfire_arrow.get());}
    @Override public byte getPierceLevel() {return 0;}
    @Override protected void doPostHurtEffects(LivingEntity entity) {
        if(!level().isClientSide()) level().explode(this, xo, yo, zo, 3, false, TNT);
    }
}