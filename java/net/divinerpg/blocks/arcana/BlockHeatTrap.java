package net.divinerpg.blocks.arcana;

import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHeatTrap extends BlockMod {
	
    public BlockHeatTrap(String name, float hardness) {
        super(name, hardness);
    }

    @Override
    public int tickRate(World par1) {
        return 30;
    }
 
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)  {
        float var5 = 0.0625F;
        return AxisAlignedBB.getBoundingBox(var2 + var5, var3, var4 + var5, var2 + 1 - var5, var3 + 1 - var5, var4 + 1 - var5);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        float var5 = 0.0625F;
        return AxisAlignedBB.getBoundingBox(var2 + var5, var3, var4 + var5, var2 + 1 - var5, var3 + 1, var4 + 1 - var5);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if(this == ArcanaBlocks.heatTrapOn)
            par1World.setBlock(par2, par3, par4, ArcanaBlocks.heatTrap); 
    }

    @Override
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
        if(this == ArcanaBlocks.heatTrap) {
            var1.setBlock(var2, var3, var4, ArcanaBlocks.heatTrapOn);
        }

        if(this == ArcanaBlocks.heatTrapOn && var5 instanceof EntityPlayerMP) {
            var5.attackEntityFrom(DamageSource.cactus, 16);
            var5.setFire(15);
            ((EntityPlayerMP)var5).addStat(DivineRPGAchievements.hoterThanHell, 1);
        }
    }
}