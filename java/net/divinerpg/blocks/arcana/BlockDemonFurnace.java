package net.divinerpg.blocks.arcana;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.blocks.BlockModFurnace;
import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityDemonFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityMoltenFurnace;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDemonFurnace extends BlockModFurnace {

	@SideOnly(Side.CLIENT)
	protected IIcon side, top, front;
	
	public BlockDemonFurnace(String name, boolean act) {
		super(name, act, GuiHandler.demon);
		setBlockTextureName("stone");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityDemonFurnace();
	}
	
	public static void updateFurnaceBlockState(boolean act, World par1World, int par2, int par3, int par4) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
		keepInventory = true;
		if(act) par1World.setBlock(par2, par3, par4, ArcanaBlocks.demonFurnaceOn);
		else par1World.setBlock(par2, par3, par4, ArcanaBlocks.demonFurnace);
		keepInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
		if(tileentity != null) {
			tileentity.validate();
			par1World.setTileEntity(par2, par3, par4, tileentity);
		}
	}
	
	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float j, float k, float f) {
		TileEntityModFurnace furnace  = (TileEntityModFurnace)w.getTileEntity(x, y, z);
		if(!w.isRemote && furnace != null){
			if(!p.isSneaking()){
				p.openGui(DivineRPG.instance, GuiHandler.demon, w, x, y, z);
				p.triggerAchievement(DivineRPGAchievements.totalDemonization);
			}
		}
		return false;
	}
	
    @Override
    public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
        int meta = ((MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 1) % 4;
        int i1 = w.getBlockMetadata(x, y, z);
        if(meta == 0) w.setBlockMetadataWithNotify(x, y, z, 1, 2);
        if(meta == 1) w.setBlockMetadataWithNotify(x, y, z, 0, 2);
        if(meta == 2) w.setBlockMetadataWithNotify(x, y, z, 3, 2);
        if(meta == 3) w.setBlockMetadataWithNotify(x, y, z, 2, 2);
    }

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
}