package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityMerikMissile;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMeriksMissile extends ItemMod{ 

	private float arcana = 50;
	public ItemMeriksMissile(String name) {
		super(name, DivineRPGTabs.tools);
		this.maxStackSize = 1;
		this.setMaxDamage(-1);
	}
	
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {	
		ItemStack stack = player.getHeldItem(hand);
		if(stack.getItem() == ModItems.meriksMissile){
			int var6 = this.getMaxItemUseDuration(stack) - stack.getItemDamage();
			boolean var5 = player.capabilities.isCreativeMode;
	    	IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
			if(arcana.getArcana() >= this.arcana) {
				arcana.consume(player, this.arcana);
				float var7 = (float)var6 / 20.0F;
				var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
				if ((double)var7 < 0.1D) return EnumActionResult.FAIL;
				if (var7 > 1.0F) var7 = 1.0F;
				EntityMerikMissile var8 = new EntityMerikMissile(world, player);
				var8.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
				if (!world.isRemote)  world.spawnEntity(var8);
			}
		}
		
		
		return EnumActionResult.FAIL;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add("Explosive homing projectile");
		list.add(TooltipLocalizer.rangedDam(22));
		list.add(TooltipLocalizer.arcanaConsumed(arcana));
		list.add(TooltipLocalizer.infiniteUses());
	}
}