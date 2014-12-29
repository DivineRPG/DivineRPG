package net.divinerpg.blocks.twilight;

import net.divinerpg.api.blocks.BlockModDoublePlant;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockBrambles extends BlockModDoublePlant {

	public BlockBrambles(String name, Block grass) {
		super(name, grass);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity entity) {
		if(entity instanceof EntityPlayer) entity.attackEntityFrom(DamageSource.cactus, 6);
	}

}
