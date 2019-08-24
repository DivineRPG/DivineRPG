package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.DivineRPG;
import divinerpg.objects.items.itemblock.ItemBlockDoor;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.IHasModel;
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

public class BlockModDoor extends BlockDoor implements IHasModel {
    protected boolean canOpenByHand;
    protected boolean unbreakable;

    public BlockModDoor(String name, Material materialIn, float hardness, boolean canOpenByHand) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        if (hardness == -1F) {
            unbreakable = true;
            setResistance(6000000F);
        }
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        this.canOpenByHand = canOpenByHand;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlockDoor(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
        IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

        if (iblockstate.getBlock() != this) {
            return false;
        } else {
            if (!canOpenByHand) {
                Item key = this == ModBlocks.soulSludgeDoor ? ModItems.sludgeKey :
                        (this == ModBlocks.ancientBrickDoor ? ModItems.ancientKey :
                                (this == ModBlocks.soulStoneDoor ? ModItems.soulKey :
                                        (this == ModBlocks.degradedBrickDoor ? ModItems.degradedKey : null)));
                ItemStack itemstack = player.getHeldItem(hand);
                if (itemstack == null || itemstack.getItem() != key) {
                    return false;
                }
                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
            }
            state = iblockstate.cycleProperty(OPEN);
            worldIn.setBlockState(blockpos, state, 10);
            worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
            worldIn.playEvent(player, ((Boolean) state.getValue(OPEN)).booleanValue() ? 1005 : 1011, pos, 0);
            return true;
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER && !unbreakable) ? Item.getItemFromBlock(this) :
                Items.AIR;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
            EntityPlayer player) {
        return new ItemStack(this);
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
