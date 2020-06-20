package divinerpg.objects.items.twilight;

import divinerpg.events.DimensionHelper;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.StructureRegistry;
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
import java.util.Random;
import java.util.Set;

public class ItemTwilightClock extends ItemMod {
    private final Set<Block> possibleBlocks = new HashSet<Block>() {{
        add(BlockRegistry.divineRock);
        add(BlockRegistry.edenBlock);
        add(BlockRegistry.wildwoodBlock);
        add(BlockRegistry.apalachiaBlock);
        add(BlockRegistry.skythernBlock);
    }};

    public ItemTwilightClock(String name) {
        super(name);
        setCreativeTab(DivineRPGTabs.utility);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {

        StructureRegistry.ARCHER_DUNGEON.generate(worldIn, new Random(), pos);
        StructureRegistry.ROLLUM_DUNGEON.generate(worldIn, new Random(), pos.add(64, 0, 64));

        ItemStack itemstack = player.getHeldItem(hand);
        if (!player.canPlayerEdit(pos, facing, itemstack)) {
            return EnumActionResult.FAIL;
        }

        BlockPos withOffset = pos.offset(facing);

        if (!worldIn.isRemote
                && worldIn.isAirBlock(withOffset)
                && worldIn.isAirBlock(pos.up())) {

            worldIn.playSound(player, withOffset, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                    itemRand.nextFloat() * 0.4F + 0.8F);

            Block block = worldIn.getBlockState(pos).getBlock();

            if (possibleBlocks.contains(block)) {
                IPortalDescription description = DimensionHelper.descriptionsByBlock.get(block);
                if (description != null) {
                    Block frame = description.getFrame();
                    BlockPos end = pos.add(0, description.getMaxSize().getY(), 0);
                    boolean findFrame = false;

                    while (!end.equals(pos)) {
                        if (worldIn.getBlockState(end).getBlock() == frame) {
                            findFrame = true;
                            break;
                        }

                        end = end.down();
                    }

                    if (findFrame) {
                        BlockPattern.PatternHelper match = description.matchFrame(worldIn, pos);
                        if (match != null) {
                            description.lightPortal(worldIn, match);

                            return EnumActionResult.SUCCESS;
                        }
                    }
                }
            }
        }

        return EnumActionResult.FAIL;
    }
}
