package divinerpg.objects.items.base;

import divinerpg.api.Reference;
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

import javax.annotation.Nullable;
import java.util.List;

public class ItemModFood extends ItemFood {

	public ItemModFood(int healAmount, float saturation, String name) {
		this(healAmount, saturation, false, name);
	}

	public ItemModFood(int healAmount, float saturation, boolean isWolfFood, String name) {
		super(healAmount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(Reference.MODID, name);
		this.setCreativeTab(DivineRPGTabs.food);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add("Fills " + (double) getHealAmount(item) + " Hunger Points");
		list.add(getHealAmount(item) * getSaturationModifier(item) * 2.0F + " Saturation");
		list.add(!isWolfsFavoriteMeat() ? ChatFormats.BLUE + "Pet Food:" + ChatFormats.RESET + " false"
		        : ChatFormats.BLUE + "Pet Food:" + ChatFormats.RESET + " true");
	}
}