package divinerpg.items.vethea;

import divinerpg.entities.projectile.EntityDisk;
import divinerpg.enums.DiskType;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemVetheanDisk extends ItemMod {
    DiskType diskType;

    public ItemVetheanDisk(DiskType diskType) {
        super(new Properties().stacksTo(1));
        this.diskType = diskType;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(diskType.getDamage()));
        tooltip.add(LocalizeUtils.i18n("tooltip.vethean_return"));
    }

    @Override
    public InteractionResult useOn(UseOnContext p_195939_1_) {
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.MASTER, 1, 1);

        if (!world.isClientSide) {
            EntityDisk disk = new EntityDisk(EntityRegistry.DISK.get(), world, player, this.diskType, itemstack.getItem());
            disk.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(disk);
        }

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, itemstack);
    }
}
