package naturix.divinerpg.bases.items.serenade;

import java.util.List;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.entities.projectile.serenade.EntitySerenadeOfIce;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SerenadeInfusion extends ItemBase {

	public SerenadeInfusion(String name) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxDamage(15);
		setMaxStackSize(1);
		showDurabilityBar(getDefaultInstance());
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {

		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);

		entity.getHeldItem(hand).damageItem(1, entity);
        //world.playSoundAtEntity(entity, Sounds.heal.getPrefixedName(), 1, 1);
        entity.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 2, true, false));
		return ar;
}
}