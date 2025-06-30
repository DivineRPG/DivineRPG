package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.EntityRegistry.INFERNO_ARROW;
import static divinerpg.registries.ItemRegistry.inferno_arrow;

public class InfernoArrow extends DivineArrow {
    public InfernoArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public InfernoArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(INFERNO_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public InfernoArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(INFERNO_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(inferno_arrow.get());}
    @Override protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        if(entity instanceof LivingEntity livingEntity && !(entity instanceof EnderMan) && !(entity instanceof Player p && p.isCreative())) livingEntity.igniteForSeconds(6);
        super.onHitEntity(result);
    }
}