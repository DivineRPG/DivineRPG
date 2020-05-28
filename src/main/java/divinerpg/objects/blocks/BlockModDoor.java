package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;
import java.util.function.Supplier;

public class BlockModDoor extends BlockDoor {

    private Supplier<Item> doorItem;

    public BlockModDoor(String name, Material materialIn, float hardness, Supplier<Item> doorItem) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        setHardness(hardness);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        this.doorItem = doorItem;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
        IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

        if (iblockstate.getBlock() != this) {
            return false;
        } else {
            state = iblockstate.cycleProperty(OPEN);
            worldIn.setBlockState(blockpos, state, 10);
            worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
            worldIn.playEvent(player, state.getValue(OPEN).booleanValue() ? 1005 : 1011, pos, 0);
            return true;
        }
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(doorItem.get());
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER) ? doorItem.get() :
                Items.AIR;
    }
}
