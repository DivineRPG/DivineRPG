package naturix.divinerpg.bases.blocks.tile;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.entities.entity.arcana.Dramix;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AltarDramix extends AltarParasecta {
	private static String name;
	public AltarDramix(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityDramixAltar();
	}
	@Override
	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	@Override
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		Dramix dramix = new Dramix(worldIn);
		worldIn.spawnEntity(dramix);	
		return false;
    }

}