package divinerpg.objects.items.base;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;
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

public class ItemModSeeds extends Item implements IPlantable {

    private Block crop;
    public Block soil;

    public ItemModSeeds(String name, Block soil) {
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        this.crop = null;
        this.soil = soil;
        setCreativeTab(DivineRPGTabs.food);
        ModItems.ITEMS.add(this);
    }

    /**
     * Sets the crop block only if it hasn't been set yet.
     * To be called during FML init event after blocks and items are registered
     *
     * @param crop the crop block to be set
     */
    public void setCrop(Block crop) {
        if(this.crop == null) {
            this.crop = crop;
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!(this.crop == null) && facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack)
                && this.crop.canPlaceBlockAt(worldIn, pos.up()) && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), this.crop.getDefaultState());

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
        return this.crop.getDefaultState();
    }
}