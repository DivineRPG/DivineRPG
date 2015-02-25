package net.divinerpg.blocks.vanilla;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockMinibricks extends VanillaBlock implements IDivineMetaBlock{

	private static IIcon[] iconArray = new IIcon[7];

	public String[] names = {"rupee", "realmite", "arlemite", "", "bloodgem", "netherite", "bedrock"};
	
	public BlockMinibricks() {
		super(EnumBlockType.ROCK, "Minibricks", 3.0F, 2);
		setResistance(30.0F);
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
		for(int i = 0; i < 7; i++){
			list.add(new ItemStack(item, 1, i));
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir){
		for(int i = 0; i<7; i++) {
			this.iconArray[i] = ir.registerIcon("divinerpg:" + names[i] + "Minibricks");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.iconArray[meta];
	}

	@Override
	public void addNames() {
		for(int i = 0; i < 7; i++){
			LangRegistry.instance.localizeName("tile", "tile." + names[i] + "Minibricks");
		}
	}

	@Override
	public String getSuffix() {
		return "Minibricks";
	}

	@Override
	public String[] getNames() {
		return names;
	}

}
