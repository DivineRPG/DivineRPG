package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.entities.entity.vanilla.TheWatcher;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemCallOfTheWatcher extends ItemMod {

    public ItemCallOfTheWatcher(String name) {
        super(name);
        this.setMaxDamage(1);
        this.setMaxStackSize(1);
        this.setCreativeTab(DRPGCreativeTabs.spawner);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (!world.isRemote) {
            if (world.provider.getDimension() == -1) {
                BlockPos pos = new BlockPos(player);
                if (!player.capabilities.isCreativeMode) {
                    CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) player, itemstack);
                    itemstack.shrink(1);
                }
                TheWatcher entity = new TheWatcher(world);
                entity.setPositionAndRotation(pos.getX() + 0.5D, (double) pos.getY() + 1, pos.getZ(),
                        player.rotationYaw, player.rotationPitch);
                world.spawnEntity(entity);
            } else {
                Logging.message(player, TextFormatting.AQUA + "The Watcher can only be spawned in the Nether.");
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
