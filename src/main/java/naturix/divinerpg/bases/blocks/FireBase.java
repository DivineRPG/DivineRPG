package naturix.divinerpg.bases.blocks;

import java.util.ArrayList;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.portal.EdenBlock;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireBase extends BlockFire {

    protected ArrayList<EdenBlock> portals = new ArrayList<EdenBlock>();
    protected String name;
    

    public FireBase(String name) { //TODO
        super();
        this.name = name;
        setLightLevel(1.0F);
        setCreativeTab(null);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void addPortal(EdenBlock portal) {
        portals.add(portal);
    }

    protected void lightPortal(World world, BlockPos pos){
    	EdenBlock portal = (EdenBlock) ModBlocks.portalEden;
        if (world.getBlockState(pos) == (ModBlocks.rockDivine)) {
            DivineRPG.logger.debug("Divine Rock lit"); 
            if (!portal.tryCreatePortal(world, pos))
                DivineRPG.logger.debug("Eden portal did not light");
        }
        portals.add(ModBlocks.portalEden);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
    	lightPortal(worldIn, pos);
    }

    public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}


}