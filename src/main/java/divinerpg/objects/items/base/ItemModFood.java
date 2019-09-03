package divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;
import divinerpg.utils.ChatFormats;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModFood extends ItemFood  {

	public ItemModFood(int healAmount, float saturation, boolean isWolfFood, String name) {
		super(healAmount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DivineRPGTabs.food);
		ModItems.ITEMS.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add("Fills " + (double) getHealAmount(item) / 2 + " Hunger Bars");
		list.add(getSaturationModifier(item) + " Saturation");
		list.add(!isWolfsFavoriteMeat() ? ChatFormats.BLUE + "Pet Food:" + ChatFormats.RESET + " false"
		        : ChatFormats.BLUE + "Pet Food:" + ChatFormats.RESET + " true");
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack item, World world, EntityLivingBase entityLiving) {
		super.onItemUseFinish(item, world, entityLiving);
		if (entityLiving instanceof EntityPlayer && item.getItem() == ModItems.chickenDinner) {
		}
		return item;
	}
}