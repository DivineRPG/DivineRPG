package divinerpg.objects.items.twilight;

import divinerpg.dimensions.vethea.layer2.HiveNest;
import divinerpg.dimensions.vethea.layer3.KarosMadhouse;
import divinerpg.dimensions.vethea.layer3.QuadroticPost;
import divinerpg.dimensions.vethea.layer4.Evergarden;
import divinerpg.dimensions.vethea.layer4.RaglokChamber;
import divinerpg.dimensions.vethea.layer4.WreckHall;
import divinerpg.dimensions.vethea.village.*;
import divinerpg.dimensions.vethea.village.WorldGenVillageIsland;
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
        new HouseDown1().generate(worldIn, new Random(), pos);
        new HouseDown2().generate(worldIn, new Random(), pos.add(24, 0, 0));
        new HouseDown3().generate(worldIn, new Random(), pos.add(48, 0, 0));
        new HouseUp1().generate(worldIn, new Random(), pos.add(0, 0, 24));
        new HouseUp2().generate(worldIn, new Random(), pos.add(24, 0, 24));
        new HouseUp3().generate(worldIn, new Random(), pos.add(48, 0, 24));
        new HouseUp4().generate(worldIn, new Random(), pos.add(72, 0, 24));
        new HouseUp5().generate(worldIn, new Random(), pos.add(96, 0, 24));

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
