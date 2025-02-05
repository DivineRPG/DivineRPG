package divinerpg.items.vanilla;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.enums.*;
import divinerpg.items.base.ItemModSword;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import java.util.List;
import java.util.function.Supplier;

public class ItemAnchor extends ItemModSword {
    protected Supplier<EntityType<? extends DivineThrowableProjectile>> projectileType;
    int baseDamageTooltip;
    public ItemAnchor(ToolStats stats, Supplier<EntityType<? extends DivineThrowableProjectile>> projectileType, int baseDamageTooltip) {
        super(stats, new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)));
        this.projectileType = projectileType;
        this.baseDamageTooltip = baseDamageTooltip;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.playSound(SoundRegistry.BLITZ.get(), 1, 1);
        if(!world.isClientSide) {
            Projectile bullet = projectileType.get().create(world);
            bullet.setOwner(player);
            bullet.setPos(player.getEyePosition().add(0, -.15, 0));
            bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 1.5F, .5F);
            world.addFreshEntity(bullet);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.consume(stack);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(baseDamageTooltip));
        tooltip.add(LocalizeUtils.infiniteAmmo());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}