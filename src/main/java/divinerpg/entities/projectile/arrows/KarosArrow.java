package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.EntityRegistry.KAROS_ARROW;
import static divinerpg.registries.ItemRegistry.karos_arrow;

public class KarosArrow extends DivineArrow {
    public KarosArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public KarosArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(KAROS_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public KarosArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(KAROS_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(karos_arrow.get());}
    @Override public float getArrowPower() {return 7;}
}