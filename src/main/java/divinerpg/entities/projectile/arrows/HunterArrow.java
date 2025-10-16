package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.EntityRegistry.HUNTER_ARROW;
import static divinerpg.registries.ItemRegistry.hunter_arrow;

public class HunterArrow extends DivineArrow {
    public HunterArrow(EntityType<? extends HunterArrow> entityType, Level level) {
        super(entityType, level);
    }
    public HunterArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(HUNTER_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public HunterArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(HUNTER_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(hunter_arrow.get());}
}