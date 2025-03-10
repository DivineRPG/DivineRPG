package divinerpg.items.ranged.arrows;

import divinerpg.entities.projectile.arrows.EnderArrow;
import divinerpg.items.ranged.ItemDivineArrow;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnderArrowItem extends ItemDivineArrow {
    public EnderArrowItem() {super(new Properties());}
    @Override public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        return new EnderArrow(level, shooter, ammo.copyWithCount(1), weapon);
    }
    @Override public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        AbstractArrow arrow = new EnderArrow(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }
    @Override public int getBaseDamage() {return 4;}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        tooltip.add(LocalizeUtils.hitEnder());
    }
}