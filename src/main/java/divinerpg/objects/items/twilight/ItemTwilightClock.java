package divinerpg.objects.items.twilight;

import divinerpg.events.TeleporterEvents;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class ItemTwilightClock extends ItemMod {
    private final Set<Block> possibleBlocks = new HashSet<Block>() {{
        add(ModBlocks.divineRock);
        add(ModBlocks.edenBlock);
        add(ModBlocks.wildwoodBlock);
        add(ModBlocks.apalachiaBlock);
        add(ModBlocks.skythernBlock);
    }};

    public ItemTwilightClock(String name) {
        super(name);
        setCreativeTab(DivineRPGTabs.utility);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {

        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);
        if (!player.canPlayerEdit(pos, facing, itemstack)) {
            return EnumActionResult.FAIL;
        }

        if (worldIn.isAirBlock(pos) && !worldIn.isRemote) {

            worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                    itemRand.nextFloat() * 0.4F + 0.8F);

            Block block = worldIn.getBlockState(pos.down()).getBlock();

            if (possibleBlocks.contains(block)) {
                IPortalDescription description = TeleporterEvents.descriptionsByBlock.get(block);
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
