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

public class BlockLamp1 extends VanillaBlock implements IDivineMetaBlock{

	private static IIcon[] iconArray = new IIcon[11];
	public static String[] names = {"aqua", "arlemite", "blaze", "bluefire", "diamond", "divine", "draken", "eden", "ender", "enderStone", "gold"};
	
	public BlockLamp1() {
		super(EnumBlockType.GLASS, "lamp1", 3.0F, 3);
		setResistance(30.0F);
		setLightLevel(1);
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
		for(int i = 0; i < 11; i++){
			list.add(new ItemStack(item, 1, i));
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir){
		for(int i = 0; i<11; i++) {
			this.iconArray[i] = ir.registerIcon("divinerpg:" + names[i] + "Lamp");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.iconArray[meta];
	}
	
	@Override
	public void addNames(){
		for(int i = 0; i < 11; i++){
			LangRegistry.instance.localizeName("tile", "tile." + names[i] + "Lamp");
		}
	}

	@Override
	public String getSuffix() {
		return "Lamp";
	}

	@Override
	public String[] getNames() {
		return names;
	}

}
