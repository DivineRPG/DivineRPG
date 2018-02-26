package naturix.divinerpg.bases;

import java.util.Set;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ShickaxeBase extends ItemPickaxe {
protected String name;

public ShickaxeBase(float attack, float speed, ToolMaterial toolMaterial, Set<Block> effectiveBlocksIn, String name)
{
	super(toolMaterial);
	setCreativeTab(DivineRPG.ToolsTab);
	this.setUnlocalizedName(name);
	this.setRegistryName(name);
	this.name = name;
}
public void registerItemModel(Item item) {
	DivineRPG.proxy.registerItemRenderer(this, 0, name);
}
}