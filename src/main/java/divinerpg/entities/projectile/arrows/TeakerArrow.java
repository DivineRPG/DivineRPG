package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.TEAKER_ARROW;
import static divinerpg.registries.ItemRegistry.teaker_arrow;

public class TeakerArrow extends DivineArrow {
    public TeakerArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public TeakerArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(TEAKER_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public TeakerArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(TEAKER_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(teaker_arrow.get());}
}