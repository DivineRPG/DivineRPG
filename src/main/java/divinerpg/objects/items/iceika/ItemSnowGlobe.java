package divinerpg.objects.items.iceika;

import divinerpg.events.TeleporterEvents;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSnowGlobe extends ItemMod {

    public ItemSnowGlobe(String name) {
        super(name);
        setMaxStackSize(1);
        this.setCreativeTab(DivineRPGTabs.utility);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {
        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);
        if (!player.canPlayerEdit(pos, facing, itemstack)) {
            return EnumActionResult.FAIL;
        }

        if (worldIn.isAirBlock(pos)) {
            worldIn.playSound(player, pos, SoundEvents.BLOCK_SNOW_STEP, SoundCategory.BLOCKS, 1.0F,
                    itemRand.nextFloat() * 0.4F + 0.8F);

            Block snow = Blocks.SNOW;

            if (worldIn.getBlockState(pos.down()).getBlock() == snow) {
                IPortalDescription description = TeleporterEvents.descriptionsByBlock.get(snow);
                if (description != null) {
                    BlockPattern.PatternHelper match = description.matchFrame(worldIn, pos.down());
                    if (match != null) {
                        description.lightPortal(worldIn, match);
                    }
                }
            }
        }

        return EnumActionResult.SUCCESS;
    }
}