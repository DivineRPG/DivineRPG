package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.EntityRegistry.FURY_ARROW;
import static divinerpg.registries.ItemRegistry.fury_arrow;

public class FuryArrow extends DivineArrow {
    public FuryArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public FuryArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(FURY_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public FuryArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(FURY_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(fury_arrow.get());}
    @Override public float getArrowPower() {return 13;}
}