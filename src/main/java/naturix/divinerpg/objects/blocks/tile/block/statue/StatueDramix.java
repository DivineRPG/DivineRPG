package naturix.divinerpg.objects.blocks.tile.block.statue;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BaseStatue;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixStatue;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class StatueDramix extends BaseStatue{
	private String name;

	public StatueDramix(String name) {
		super(name);
		setBlockUnbreakable();
		setResistance(6000000F);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Item model isnt in yet");
	}
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityDramixStatue();
	}

}
