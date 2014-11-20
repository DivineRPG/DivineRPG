package net.divinerpg.blocks.vanilla;

import java.util.List;

import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSteel extends VanillaBlock implements IDivineMetaBlock{

	private IIcon[] iconArray = new IIcon[10];
	public static String[] names = {"teal", "red", "purple", "green", "yellow", "blue", "white", "black", "orange", "brightRed"};
	
	public BlockSteel() {
		super(EnumBlockType.ROCK, "steel", 10.0F, 3);
		setResistance(60.0F);
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
		for(int i = 0; i < 10; i++){
			list.add(new ItemStack(item, 1, i));
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir){
		for(int i = 0; i<10; i++) {
			this.iconArray[i] = ir.registerIcon("divinerpg:" + names[i] + "Steel");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.iconArray[meta];
	}
	
	@Override
	public void addNames(){
		for(int i = 0; i < 10; i++){
			LangRegistry.instance.localizeName("tile", "tile." + names[i] + "Steel");
		}
	}

	@Override
	public String getSuffix() {
		return "Steel";
	}

	@Override
	public String[] getNames() {
		return names;
	}

}
