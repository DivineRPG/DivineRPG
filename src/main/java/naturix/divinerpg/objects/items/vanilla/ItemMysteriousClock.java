package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.entities.entity.vanilla.AncientEntity;
import naturix.divinerpg.objects.items.base.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMysteriousClock extends ItemBase {

	public ItemMysteriousClock(String name) {
		super(name);
		this.setCreativeTab(DRPGCreativeTabs.spawner);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
	        float hitX, float hitY, float hitZ) {
		if (world.provider.getDimensionType().getId() != 0) {
			Logging.message(player, TextFormatting.AQUA + "This item can only be used in the Overworld.");
		}
		if (!world.isRemote) {
			AncientEntity entity = new AncientEntity(world);
			entity.setPositionAndRotation(pos.getX(), (double) pos.getY() + 1, pos.getZ(), player.rotationYaw,
			        player.rotationPitch);
			if (world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).isEmpty()) {
				world.spawnEntity(entity);
				if (!player.capabilities.isCreativeMode) {
					ItemStack stack = new ItemStack(this);
					stack.shrink(1);
				}
			}

		}
		return EnumActionResult.PASS;
	}

}