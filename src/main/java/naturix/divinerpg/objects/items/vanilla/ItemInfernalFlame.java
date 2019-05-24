package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.entities.entity.vanilla.KingOfScorchers;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemInfernalFlame extends ItemMod {

    public ItemInfernalFlame(String name) {
        super(name, DRPGCreativeTabs.spawner);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (!world.isRemote) {
            if (world.provider.getDimension() == -1) {
                KingOfScorchers entity = new KingOfScorchers(world);
                entity.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                if (world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).isEmpty()) {
                    world.spawnEntity(entity);
                    if (!player.capabilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }
                    return EnumActionResult.SUCCESS;
                }
            } else {
                Logging.message(player,
                        TextFormatting.AQUA + "The King of the Scorchers can only be spawned in the Nether.");
            }
        }
        return EnumActionResult.FAIL;
    }
}
