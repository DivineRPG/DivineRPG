package naturix.divinerpg.bases.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
public class BedBase extends BlockBed {

    private NBTTagCompound persistantData;
    private String name;
    public BedBase(String name) {
        super();
        setCreativeTab(DivineRPG.BlocksTab);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(9);
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        //return state.getValue(PART) == BlockBed.EnumPartType.FOOT ? Items.AIR : Item.getItemFromBlock(ModBlocks.nightmarebed);
    return null;
    }
    public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	
	//
}