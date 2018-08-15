package naturix.divinerpg.bases.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetherite extends BlockOreNether {

	private Entity entity;

	public BlockNetherite(String name) {
		super(name);
	} 

	@Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		DivineRPG.logger.info(state.getBlock().getLocalizedName());    
		entity.attackEntityFrom(DamageSource.GENERIC, 1);
        entity.setFire(2);
        DivineRPG.logger.info(entity.getName());
    }
	public boolean requiresUpdates()
    {
        return true;
    }
	
	}