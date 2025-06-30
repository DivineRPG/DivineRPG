package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.EntityRegistry.HUNTER_ARROW;
import static divinerpg.registries.ItemRegistry.hunter_arrow;
import static net.minecraft.world.effect.MobEffects.POISON;

public class HunterArrow extends DivineArrow {
    public HunterArrow(EntityType<? extends DivineArrow> entityType, Level level) {
        super(entityType, level);
        //Poison IV for 2 seconds
        addEffect(new MobEffectInstance(POISON, 2 * 20, 3));
    }
    public HunterArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(HUNTER_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
        //Poison IV for 2 seconds
        addEffect(new MobEffectInstance(POISON, 2 * 20, 3));
    }
    public HunterArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(HUNTER_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
        //Poison IV for 2 seconds
        addEffect(new MobEffectInstance(POISON, 2 * 20, 3));
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(hunter_arrow.get());}
}