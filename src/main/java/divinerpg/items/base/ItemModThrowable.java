package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModThrowable extends ItemMod {
    protected BulletType bulletType;
    protected Rarity rarity;

    public ItemModThrowable(String name, Rarity rarity, BulletType bulletType) {
        super(name, rarity, DivineRPG.tabs.ranged);
        this.rarity = rarity;
        this.bulletType = bulletType;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.rangedDam(bulletType.getDamage()));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundCategory.MASTER, 1, 1);

        if (!world.isClientSide) {
            EntityShooterBullet bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET, player, world, bulletType);
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(bullet);
        }

        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemstack);
    }
}