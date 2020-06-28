package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntityGrenade;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemGrenade extends ItemMod {
	
	private int counter = 0;

	public ItemGrenade(String name) {
		super(name, DivineRPGTabs.RANGED_WEAPONS);
		
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		// GEtting the reference, not creting new ItemStack
		ItemStack stack = player.getHeldItemMainhand();
		if (counter == 0) {
			if (!world.isRemote) {
				EntityGrenade projectile = new EntityGrenade(world, player);
				projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);

				world.spawnEntity(projectile);
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1, 1);
			}
			if (!player.capabilities.isCreativeMode) stack.shrink(1);
		}
		if (counter < 3) counter++;
		if (counter == 3) counter = 0;
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(LocalizeUtils.explosiveShots());
    }
}
