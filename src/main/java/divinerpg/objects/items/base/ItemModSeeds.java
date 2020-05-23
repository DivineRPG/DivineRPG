package divinerpg.objects.items.base;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.function.Supplier;

public class ItemModSeeds extends Item implements IPlantable {

    private Supplier<Block> cropSupplier;
    public Supplier<Block> soilSupplier;

    public ItemModSeeds(String name, Supplier<Block> cropSupplier, Supplier<Block> soilSupplier) {
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        this.cropSupplier = cropSupplier;
        this.soilSupplier = soilSupplier;
        setCreativeTab(DivineRPGTabs.food);

    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);

        Block crop = cropSupplier.get();

        if (crop != null && facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack)
                && crop.canPlaceBlockAt(worldIn, pos.up()) && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), crop.getDefaultState());

            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos.up(), itemstack);
            }

            if (!player.capabilities.isCreativeMode)
                itemstack.shrink(1);

            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Crop;
    }

    @Override
    public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return cropSupplier.get().getDefaultState();
    }
}