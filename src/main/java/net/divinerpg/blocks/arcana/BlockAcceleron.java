package net.divinerpg.blocks.arcana;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAcceleron extends BlockMod {

	private IIcon side;
	private IIcon top_n;
	private IIcon top_s;
	private IIcon top_e;
	private IIcon top_w;
	
	public BlockAcceleron() {
		super(EnumBlockType.ROCK, "acceleron", 3.0F, DivineRPGTabs.utility);
		slipperiness = 1.2F;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        side = icon.registerIcon(Reference.PREFIX + "acceleron" + "_side");
        top_n = icon.registerIcon(Reference.PREFIX + "acceleron" + "_north");
        top_s = icon.registerIcon(Reference.PREFIX + "acceleron" + "_south");
        top_e = icon.registerIcon(Reference.PREFIX + "acceleron" + "_east");
        top_w = icon.registerIcon(Reference.PREFIX + "acceleron" + "_west");
    }
	
    @Override
    public IIcon getIcon(int side, int meta) {
    	if(side <= 1) return meta == 2 ? top_n : (meta == 3 ? top_s : (meta == 4 ? top_w : top_e));
    	return this.side;
    }
    
    @Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase living, ItemStack item) {
		int meta = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(meta == 0) w.setBlockMetadataWithNotify(x, y, z, 2, 2);
		if(meta == 1) w.setBlockMetadataWithNotify(x, y, z, 5, 2);
		if(meta == 2) w.setBlockMetadataWithNotify(x, y, z, 3, 2);
		if(meta == 3) w.setBlockMetadataWithNotify(x, y, z, 4, 2);
	}
}