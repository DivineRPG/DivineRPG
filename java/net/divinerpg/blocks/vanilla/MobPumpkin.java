package net.divinerpg.blocks.vanilla;

import java.util.Random;

import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MobPumpkin extends BlockDirectional {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	private static SoundType wood = Block.soundTypeWood;
	private static Material pumpkin = Material.gourd;
	private Random rand = new Random();
	
	public MobPumpkin() {
		super(pumpkin);
		setTickRandomly(true);
		setHardness(1.0F);
		setCreativeTab(DivineRPGTabs.blocks);
		setSoundType(wood);
		LangRegistry.addBlock(this);
	}

	public Block setSoundType(Block.SoundType name) {
		return setStepSound(name);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.top : (par1 == 0 ? this.top : (par2 == 2 && par1 == 2 ? this.front : (par2 == 3 && par1 == 5 ? this.front : (par2 == 0 && par1 == 3 ? this.front : (par2 == 1 && par1 == 4 ? this.front : this.blockIcon)))));
	}

	@Override
	public boolean canPlaceBlockAt(World world, int par1, int par2, int par3) {
		return  world.getBlock(par1, par2, par3).isReplaceable(world, par1, par2, par3) && World.doesBlockHaveSolidTopSurface(world, par1, par2 - 1, par3);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int var6, float var7, float var8, float var9) {
		if(!p.isSneaking()) {
			if(w.getBlock(x, y, z) == VanillaBlocks.spiderPumpkin)
				w.playSoundAtEntity(p, "mob.spider.say", 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.glaconPumpkin)
				w.playSoundAtEntity(p, Sounds.glacide.getPrefixedName(), 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.enderWatcherPumpkin)
				w.playSoundAtEntity(p, "mob.endermen.idle", 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.jungleSpiderPumpkin)
				w.playSoundAtEntity(p, Sounds.hellSpider.getPrefixedName(), 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.hellSpiderPumpkin)
				w.playSoundAtEntity(p, Sounds.hellSpider.getPrefixedName(), 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.enderPumpkin)
				w.playSoundAtEntity(p, "mob.endermen.scream", 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.creeperPumpkin)
				w.playSoundAtEntity(p, "mob.creeper.say", 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.skeletonPumpkin)
				w.playSoundAtEntity(p, "mob.skeleton.say", 100, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.blazePumpkin)
				w.playSoundAtEntity(p, "mob.blaze.breathe", 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.zombiePumpkin)
				w.playSoundAtEntity(p, "mob.zombie.say", 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.frostPumpkin)
				w.playSoundAtEntity(p, Sounds.frost.getPrefixedName(), 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.cyclopsPumpkin)
				w.playSoundAtEntity(p, Sounds.cyclops.getPrefixedName(), 1, 1);
			if(w.getBlock(x, y, z) == VanillaBlocks.ghastPumpkin)
				w.playSoundAtEntity(p, "mob.ghast.scream", 1, 1);
		} 
		return true;
	}

	public Block setName(String name){
		setBlockName(name);
		setTextureName(name);
		GameRegistry.registerBlock(this, name);
		return this;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.front = icon.registerIcon(this.getTextureName() + "_front");
		this.top = icon.registerIcon(this.getTextureName() + "_top");
		this.blockIcon = icon.registerIcon(this.getTextureName() + "_side");
	}

	public Block setTextureName(String name){
		return setBlockTextureName(Reference.PREFIX + name);
	}
}