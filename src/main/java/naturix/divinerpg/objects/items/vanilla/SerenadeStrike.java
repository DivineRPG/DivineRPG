package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SerenadeStrike extends ItemMod {

	public SerenadeStrike(String name) {
		super(name);
		this.setCreativeTab(DRPGCreativeTabs.ranged);
		setMaxDamage(100);
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Shoots lightning");
		tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);

		RayTraceResult pos = entity.rayTrace(300, 20);

		double i = pos.getBlockPos().getX();
		double j = pos.getBlockPos().getY();
		double k = pos.getBlockPos().getZ();

		if (world.getBlockState(pos.getBlockPos()) != null) {
			world.spawnEntity(new EntityLightningBolt(world, i, j, k, false));
			world.spawnEntity(new EntityLightningBolt(world, i, j, k, false));
			world.spawnEntity(new EntityLightningBolt(world, i, j, k, false));
		}

		return ar;
	}
}