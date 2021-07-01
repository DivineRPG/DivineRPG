package divinerpg.items.vethea;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
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

public class ItemVetheanDisk extends ItemMod {
    DiskType diskType;

    public ItemVetheanDisk(String name, DiskType diskType) {
        super(name, new Properties().tab(DivineRPG.tabs.vethea).stacksTo(1));
        this.diskType = diskType;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(diskType.getDamage()));
        tooltip.add(LocalizeUtils.i18n("tooltip.vethean_return"));
    }

    @Override
    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        return ActionResultType.SUCCESS;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundCategory.MASTER, 1, 1);

        if (!world.isClientSide) {
            EntityDisk disk = new EntityDisk(EntityRegistry.DISK, world, player, this.diskType, itemstack.getItem());
            disk.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(disk);
        }

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemstack);
    }
}
