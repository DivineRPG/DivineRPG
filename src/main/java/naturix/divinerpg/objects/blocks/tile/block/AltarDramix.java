package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.objects.entities.entity.arcana.Dramix;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
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
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityDramixAltar();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
	        EnumFacing facing, float hitX, float hitY, float hitZ) {
		Dramix dramix = new Dramix(worldIn);
		worldIn.spawnEntity(dramix);
		return false;
	}

	@Override
	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, name);
	}

}