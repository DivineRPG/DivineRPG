package naturix.divinerpg.objects.items.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BookBase extends ItemMod {

	protected int healAmount = 0;
	public BookBase(String name) {
		super(name);
		setMaxStackSize(1);
	}
	public ItemMod setHealAmount(int healAmount){
		this.healAmount = healAmount;
		return this;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
		float var4 = 1.0F;
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		RayTraceResult pos = entity.rayTrace(4, 20);
			double i = pos.getBlockPos().getX();
			double j = pos.getBlockPos().getY();
			double k = pos.getBlockPos().getZ();
			BlockPos pos2 = new BlockPos(i, j, k);
		
		
		if (true) {
			
			
			//if(world.getBlockState(pos2) == ModBlocks.altarParasecta.getDefaultState()) {
			//	world.spawnEntity(new Parasecta(world));
			//}
		}

		return ar;
	}
}