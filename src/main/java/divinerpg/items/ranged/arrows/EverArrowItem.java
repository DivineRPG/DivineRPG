package divinerpg.items.ranged.arrows;

import divinerpg.entities.projectile.arrows.EverArrow;
import divinerpg.items.ranged.ItemDivineArrow;
import net.minecraft.core.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class EverArrowItem extends ItemDivineArrow {
    public EverArrowItem() {super(new Properties());}
    @Override public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        return new EverArrow(level, shooter, ammo.copyWithCount(1), weapon);
    }
    @Override public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        AbstractArrow arrow = new EverArrow(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }
    @Override public int getBaseDamage() {return 25;}
}