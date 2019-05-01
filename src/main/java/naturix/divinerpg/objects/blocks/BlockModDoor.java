package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.itemblock.ItemBlockDoor;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on Jan /29/2019
 */
public class BlockModDoor extends BlockDoor implements IHasModel {

    public BlockModDoor(String name, Material materialIn, float hardness) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        if (hardness == -1F) {
            setBlockUnbreakable();
            setResistance(6000000F);
        }
        this.setCreativeTab(DRPGCreativeTabs.BlocksTab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlockDoor(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : Item.getItemFromBlock(this);
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
