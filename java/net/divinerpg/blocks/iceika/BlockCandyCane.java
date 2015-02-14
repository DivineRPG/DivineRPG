package net.divinerpg.blocks.iceika;

import java.util.List;

import net.divinerpg.blocks.vanilla.IDivineMetaBlock;
import net.divinerpg.blocks.vanilla.VanillaBlock;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCandyCane extends VanillaBlock implements IDivineMetaBlock {

	private static IIcon[] iconArray = new IIcon[5];

	public String[] names = {"blue", "green", "pink", "red", "yellow"};
	
	public BlockCandyCane() {
		super(EnumBlockType.ROCK, "CandyCane", 1.0F, 2);
		setResistance(1.0F);
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
		for(int i = 0; i < 5; i++){
			list.add(new ItemStack(item, 1, i));
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir){
		for(int i = 0; i<5; i++) {
			this.iconArray[i] = ir.registerIcon("divinerpg:" + names[i] + "CandyCane");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.iconArray[meta];
	}

	@Override
	public void addNames() {
		for(int i = 0; i < 5; i++){
			LangRegistry.instance.localizeName("tile", "tile." + names[i] + "CandyCane");
		}
	}

	@Override
	public String getSuffix() {
		return "CandyCane";
	}

	@Override
	public String[] getNames() {
		return names;
	}

}
