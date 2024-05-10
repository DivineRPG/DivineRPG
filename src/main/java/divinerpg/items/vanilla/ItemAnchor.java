package divinerpg.items.vanilla;

import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.*;
import divinerpg.items.base.ItemModSword;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemAnchor extends ItemModSword {
    protected BulletType bulletType;
    public ItemAnchor(ToolStats stats, BulletType projectileType) {
        super(stats);
        bulletType = projectileType;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.playSound(SoundRegistry.BLITZ.get(), 1, 1);
        if(!world.isClientSide) {
            ThrowableProjectile bullet;
            bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, bulletType);
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, .5F);
            world.addFreshEntity(bullet);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.consume(stack);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam((int)bulletType.getDamage()));
        tooltip.add(LocalizeUtils.infiniteAmmo());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}