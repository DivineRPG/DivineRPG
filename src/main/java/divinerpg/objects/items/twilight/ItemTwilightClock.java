package divinerpg.objects.items.twilight;

import divinerpg.dimensions.iceika.structures.WorldGenRollumDungeon;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ItemTwilightClock extends ItemMod {

    public ItemTwilightClock(String name) {
        super(name);
        setCreativeTab(DivineRPGTabs.utility);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {

        //testing code until a structure gen command or something is implemented
        //new WorldGenRollumDungeon().generate(worldIn, new Random(), pos);

        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);
        if (!player.canPlayerEdit(pos, facing, itemstack)) {
            return EnumActionResult.FAIL;
        } else {
            if (worldIn.isAirBlock(pos)) {
                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                        itemRand.nextFloat() * 0.4F + 0.8F);
                if (worldIn.getBlockState(pos.down()) == ModBlocks.divineRock.getDefaultState()
                        || worldIn.getBlockState(pos.down()) == ModBlocks.edenBlock.getDefaultState()
                        || worldIn.getBlockState(pos.down()) == ModBlocks.wildwoodBlock.getDefaultState()
                        || worldIn.getBlockState(pos.down()) == ModBlocks.apalachiaBlock.getDefaultState()
                        || worldIn.getBlockState(pos.down()) == ModBlocks.skythernBlock.getDefaultState()
                        || worldIn.getBlockState(pos.down()) == ModBlocks.mortumBlock.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.blueFire.getDefaultState(), 11);
                }
            }

            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos, itemstack);
            }

            return EnumActionResult.SUCCESS;
        }
    }
}
