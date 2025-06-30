package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.EntityRegistry.SHADOW_ARROW;
import static divinerpg.registries.ItemRegistry.shadow_arrow;

public class ShadowArrow extends DivineArrow {
    public ShadowArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public ShadowArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(SHADOW_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public ShadowArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(SHADOW_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(shadow_arrow.get());}
    @Override public void tick() {
        if(!onGround()) setDeltaMovement(getDeltaMovement().scale(1.009));
        super.tick();
    }
}