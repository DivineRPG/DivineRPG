package divinerpg.items.base;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemModThrowable extends ItemMod {
    protected BulletType bulletType;
    protected Rarity rarity;

    public ItemModThrowable(Rarity rarity, BulletType bulletType) {
        super(rarity, DivineRPG.tabs.ranged);
        this.rarity = rarity;
        this.bulletType = bulletType;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.rangedDam(bulletType.getDamage()));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.MASTER, 1, 1);

        if (!world.isClientSide) {
            EntityShooterBullet bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, bulletType);
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(bullet);
        }

        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, itemstack);
    }
}