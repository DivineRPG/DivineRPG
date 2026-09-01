package divinerpg.items.vanilla;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.items.base.ItemModSword;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.ToolStats;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static divinerpg.registries.SoundRegistry.BLITZ;

public class ItemAnchor extends ItemModSword {
    protected Supplier<EntityType<? extends DivineThrowableProjectile>> projectileType;
    int baseDamageTooltip;
    public ItemAnchor(ToolStats stats, Supplier<EntityType<? extends DivineThrowableProjectile>> projectileType, int baseDamageTooltip, Properties properties) {
        super(stats, properties);
        this.projectileType = projectileType;
        this.baseDamageTooltip = baseDamageTooltip;
    }
    @Override public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.playSound(BLITZ.get(), 1, 1);
        if(!world.isClientSide()) {
            Projectile bullet = projectileType.get().create(world, EntitySpawnReason.SPAWN_ITEM_USE);
            bullet.setOwner(player);
            bullet.setPos(player.getEyePosition().add(0, -.15, 0));
            bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 1.5F, .5F);
            world.addFreshEntity(bullet);
        } if(!player.isCreative()) stack.hurtAndBreak(1, player, hand);
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.rangedDam(baseDamageTooltip));
        builder.accept(LocalizeUtils.infiniteAmmo());
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }

}