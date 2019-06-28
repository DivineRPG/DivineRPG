package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockModCrop extends BlockCrops implements IHasModel {
    protected String name;
    private static int amountOfStages;

    public BlockModCrop(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockModCrop(String name, int stages) {
	    setUnlocalizedName(name);
        setRegistryName(name);
		this.setTickRandomly(true);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.disableStats();
		amountOfStages = stages;
		this.name = name;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
    
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && soil.getBlock() == Blocks.FARMLAND;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
    @Override
    public int getMaxAge() {
    	if(amountOfStages >= 1) {
        return amountOfStages;
    	}else {
    		return 7;}
    	}
}