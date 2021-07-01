package divinerpg.items.base;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemModThrowable extends ItemMod {
    protected BulletType bulletType;

    public ItemModThrowable(String name, BulletType bulletType) {
        super(name, DivineRPG.tabs.ranged);
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