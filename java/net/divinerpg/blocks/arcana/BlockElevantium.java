package net.divinerpg.blocks.arcana;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockElevantium extends BlockMod {
	
	public BlockElevantium(String name) {
		super(EnumBlockType.IRON, name, 3f, DivineRPGTabs.utility);
		setResistance(20);
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.03125F, 0.9375F);
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean canPlaceBlockAt(World w, int x, int y, int z) {
		return w.getBlock(x, y-1, z).isSideSolid(w, x, y, z, ForgeDirection.UP);
	}
	
	@Override
    public boolean canBlockStay(World w, int x, int y, int z) {
		return w.getBlock(x, y-1, z).isSideSolid(w, x, y, z, ForgeDirection.UP);
    }
	
	@Override
    public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
		if(!this.canBlockStay(w, x, y, z)){
			this.dropBlockAsItem(w, x, y, z, new ItemStack(this, 1, 0));
			w.setBlockToAir(x, y, z);
		}
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.motionY += 0.75;
		entity.fallDistance = 0;
		if(entity instanceof EntityPlayer) ((EntityPlayer)entity).triggerAchievement(DivineRPGAchievements.skyHigh);
	}

}
