package naturix.divinerpg.bases.items.special;

import java.util.Random;

import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.entities.entity.vanilla.AyeracoBlue;
import naturix.divinerpg.entities.entity.vanilla.AyeracoGreen;
import naturix.divinerpg.entities.entity.vanilla.AyeracoPurple;
import naturix.divinerpg.entities.entity.vanilla.AyeracoRed;
import naturix.divinerpg.entities.entity.vanilla.AyeracoYellow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HordeHorn extends ItemBase {

	
	public HordeHorn(String name) {
		super(name);
		this.setMaxDamage(1);
		this.setMaxStackSize(1);
		
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        BlockPos pos = new BlockPos(playerIn);
        Random rand = new Random();
        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        if (!worldIn.isRemote && worldIn.provider.getDimension() == 1)
        {
        	AyeracoBlue ayeracoBlue = new AyeracoBlue(worldIn);
        	AyeracoGreen ayeracoGreen = new AyeracoGreen(worldIn);
        	AyeracoPurple ayeracoPurple = new AyeracoPurple(worldIn);
        	AyeracoRed ayeracoRed = new AyeracoRed(worldIn);
        	AyeracoYellow ayeracoYellow = new AyeracoYellow(worldIn);
            
        	ayeracoBlue.setPositionAndRotation((double)pos.getX() + rand.nextDouble(), (double)pos.getY() +1, (double)pos.getZ(), playerIn.rotationYaw, playerIn.rotationPitch);
        	ayeracoGreen.setPositionAndRotation((double)pos.getX() + rand.nextDouble(), (double)pos.getY() +1, (double)pos.getZ(), playerIn.rotationYaw, playerIn.rotationPitch);
        	ayeracoPurple.setPositionAndRotation((double)pos.getX() + rand.nextDouble(), (double)pos.getY() +1, (double)pos.getZ(), playerIn.rotationYaw, playerIn.rotationPitch);
        	ayeracoRed.setPositionAndRotation((double)pos.getX() + rand.nextDouble(), (double)pos.getY() +1, (double)pos.getZ(), playerIn.rotationYaw, playerIn.rotationPitch);
        	ayeracoYellow.setPositionAndRotation((double)pos.getX() + rand.nextDouble(), (double)pos.getY() +1, (double)pos.getZ(), playerIn.rotationYaw, playerIn.rotationPitch);
            
            
            
        	worldIn.spawnEntity(ayeracoBlue);
        	worldIn.spawnEntity(ayeracoGreen);
        	worldIn.spawnEntity(ayeracoPurple);
        	worldIn.spawnEntity(ayeracoRed);
        	worldIn.spawnEntity(ayeracoYellow);
        	
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

}