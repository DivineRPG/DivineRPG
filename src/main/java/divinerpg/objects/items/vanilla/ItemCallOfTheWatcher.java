package divinerpg.objects.items.vanilla;

import divinerpg.objects.entities.entity.vanilla.TheWatcher;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.log.Logging;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemCallOfTheWatcher extends ItemMod {

    public ItemCallOfTheWatcher(String name) {
        super(name);
        this.setMaxDamage(1);
        this.setMaxStackSize(1);
        this.setCreativeTab(DivineRPGTabs.spawner);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (!world.isRemote) {
            if (world.provider.getDimension() == -1) {
                TheWatcher entity = new TheWatcher(world);
                entity.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                if (world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).isEmpty()) {
                    world.spawnEntity(entity);
                    if (!player.capabilities.isCreativeMode) {
                        CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) player, itemstack);
                        itemstack.shrink(1);
                    }
                    return EnumActionResult.SUCCESS;
                }
            } else {
                Logging.message(player, TextFormatting.AQUA + "The Watcher can only be spawned in the Nether.");
            }
        }
        return EnumActionResult.FAIL;
    }
}
