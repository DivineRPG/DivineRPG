package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModDoor;
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

public class BlockArcanaDoor extends BlockModDoor {
    private Supplier<Item> keyItem;

    public BlockArcanaDoor(String name, Supplier<Item> key, Supplier<Item> doorItem) {
        super(name, Material.ROCK, -1F, doorItem);
        this.setResistance(6000000F);
        this.keyItem = key;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
        IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

        if (iblockstate.getBlock() != this) {
            return false;
        }
        else {
            if(!player.capabilities.isCreativeMode) {
                if(iblockstate.getProperties().get(OPEN).equals(true)) {
                    return false;
                }
                Item key = this.keyItem.get();
                ItemStack itemstack = player.getHeldItem(hand);
                if (itemstack == null || itemstack.getItem() != key) {
                    return false;
                }
                itemstack.shrink(1);
            }
            state = iblockstate.cycleProperty(OPEN);
            worldIn.setBlockState(blockpos, state, 10);
            worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
            worldIn.playEvent(player, ((Boolean) state.getValue(OPEN)).booleanValue() ? 1005 : 1011, pos, 0);

            BlockPos[] adjacent = {
                    blockpos.north(),
                    blockpos.east(),
                    blockpos.south(),
                    blockpos.west()
            };

            for(BlockPos adjacentPos: adjacent) {
                IBlockState adjacentBlockState =  worldIn.getBlockState(adjacentPos);
                if (adjacentBlockState.getBlock() != this) {
                    continue;
                }
                else if(!player.capabilities.isCreativeMode && adjacentBlockState.getProperties().get(OPEN).equals(true)) {
                    break;
                }
                else {
                    adjacentBlockState = iblockstate.cycleProperty(OPEN);
                    worldIn.setBlockState(adjacentPos, adjacentBlockState, 10);
                    worldIn.markBlockRangeForRenderUpdate(adjacentPos, adjacentPos);
                    worldIn.playEvent(player, ((Boolean) state.getValue(OPEN)).booleanValue() ? 1005 : 1011, adjacentPos, 0);
                    return true;
                }
            }
            return true;
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.AIR;
    }
}
