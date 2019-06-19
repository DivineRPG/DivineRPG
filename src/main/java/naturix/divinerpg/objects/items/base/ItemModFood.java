package naturix.divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.ChatFormats;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModFood extends ItemFood implements IHasModel {
	public String name;

	public ItemModFood(int healAmount, float saturation, boolean isWolfFood, String name) {
		super(healAmount, saturation, isWolfFood);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DRPGCreativeTabs.food);
		ModItems.ITEMS.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		//FIXME - Add ability to translate
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

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}