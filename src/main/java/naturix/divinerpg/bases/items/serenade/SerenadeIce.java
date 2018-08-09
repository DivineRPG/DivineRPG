package naturix.divinerpg.bases.items.serenade;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.entities.projectile.serenade.EntitySerenadeOfIce;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SerenadeIce extends ItemBase {

	public SerenadeIce(String name) {
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
		
		if(!world.isRemote) {
			world.spawnEntity(new EntitySerenadeOfIce(world, entity));
			//world.playSoundAtEntity(entity, Sounds.serenade.getPrefixedName(), 1, 1);

			entity.getHeldItem(hand).damageItem(1, entity);
	}
		return ar;
}
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add("Slows mobs for 5 seconds");
		tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
    }
}