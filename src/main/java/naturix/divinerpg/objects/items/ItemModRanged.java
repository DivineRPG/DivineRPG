package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModRanged extends ItemBase {

	protected int weaponDamage;
	protected SoundEvent sound;
	protected Class<? extends EntityThrowable> clazz;

	public ItemModRanged(String name, int maxDamage, SoundEvent sound, Class<? extends EntityThrowable> clazz) {
		super(name);
		this.clazz = clazz;
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		this.setCreativeTab(DRPGCreativeTabs.ranged);
		this.sound = sound;
	}

	protected void addAdditionalInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		if (getMaxDamage() == -1) {
			list.add(TooltipLocalizer.infiniteUses());
		}
	}

	protected boolean additionalRightClickChecks(EntityPlayer player) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote && additionalRightClickChecks(player)) {
			if (sound != null) {
				// world.playSound(player, sound.getSoundLocation(), 1, 1);
			}
			try {
				final EntityThrowable projectile = (clazz.getConstructor(World.class, EntityPlayer.class)
				        .newInstance(world, player));
				projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
				world.spawnEntity(projectile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
	}

}