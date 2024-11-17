package net.divinerpg.blocks.vanilla;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSpike extends BlockMod {

    public BlockSpike() {
        super(EnumBlockType.ROCK, "spikeBlock", 3);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox(x + f, y, z + f, x + 1 - f, y + 1 - f, z + 1 - f);
    }

    @Override
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity e) {
        if(e instanceof EntityLivingBase) e.attackEntityFrom(Util.spikeSource, 5);
    }
}