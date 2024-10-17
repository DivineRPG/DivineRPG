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

public class BlockDivineBricks extends VanillaBlock implements IDivineMetaBlock{

	private static IIcon[] iconArray = new IIcon[15];

	public String[] names = {"aquatonic", "arlemite", "darkstone", "diamond", "gold", "green", "iron", "lapisLazuli", "lava", "netherite", "pink", "purple", "realmite", "redstone", "milkStone"};
	
	public BlockDivineBricks() {
		super(EnumBlockType.ROCK, "Bricks", 3.0F, 2);
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
		for(int i = 0; i < 15; i++){
			list.add(new ItemStack(item, 1, i));
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir){
		for(int i = 0; i<15; i++) {
			this.iconArray[i] = ir.registerIcon("divinerpg:" + names[i] + "Bricks");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.iconArray[meta];
	}

	@Override
	public void addNames() {
		for(int i = 0; i < 15; i++){
			LangRegistry.instance.localizeName("tile", "tile." + names[i] + "Bricks");
		}
	}

	@Override
	public String getSuffix() {
		return "Bricks";
	}

	@Override
	public String[] getNames() {
		return names;
	}

}
