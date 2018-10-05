package naturix.divinerpg.bases.items.special;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.entities.entity.vanilla.TheWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CallOfTheWatcher extends ItemBase{

	public CallOfTheWatcher(String name) {
		super(name);
		this.setMaxDamage(1);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(worldIn.isRemote) {
		if(worldIn.provider.getDimension() == -1) {
			TheWatcher watcher = new TheWatcher(worldIn);
			 watcher.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY() +1, (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
			 watcher.onEntityUpdate();
			 watcher.onUpdate();
			 watcher.onLivingUpdate();
			 worldIn.spawnEntity(watcher);
			 if(!player.capabilities.isCreativeMode) {ItemStack stack=new ItemStack(this); stack.splitStack(1);}
            }else {
			DivineRPG.logger.info(player.getName()+" just attempted to spawn the watcher in the dimension "+ worldIn.provider.getDimension());
            }	}
        return EnumActionResult.PASS;
    }
}
