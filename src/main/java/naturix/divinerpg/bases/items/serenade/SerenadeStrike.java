package naturix.divinerpg.bases.items.serenade;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SerenadeStrike extends ItemBase{

	public SerenadeStrike(String name) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxDamage(100);
		setMaxStackSize(1);
		showDurabilityBar(getDefaultInstance());
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
		float var4 = 1.0F;
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		
		RayTraceResult pos = entity.rayTrace(100, 20);

			double i = pos.getBlockPos().getX();
			double j = pos.getBlockPos().getY();
			double k = pos.getBlockPos().getZ();

		if (true) {
			world.spawnEntity(new EntityLightningBolt(world, i, j, k, false));


			entity.getHeldItem(hand).damageItem(1, entity);
			}
		
		return ar;
	}
}