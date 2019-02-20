package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.vanilla.Grizzle;
import naturix.divinerpg.objects.entities.entity.vanilla.GrizzleWhite;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnEgg extends ItemBase {
	public ItemSpawnEgg(String name) {
		super(name, CreativeTabs.MISC);
		this.name = name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> infoList, ITooltipFlag flagIn) {
		if (this == ModItems.eggGrizzle || this == ModItems.eggGrizzleWhite) {
			infoList.add("Spawns a pet grizzle");
		}
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
	        float hitX, float hitY, float hitZ) {
		RayTraceResult rtr = player.rayTrace(4.5f, 1);
		double i = rtr.getBlockPos().getX();
		double j = rtr.getBlockPos().getY();
		double k = rtr.getBlockPos().getZ();
		ItemStack stack = new ItemStack(this);
		if (!world.isRemote) {
			if (this == ModItems.eggGrizzle) {
				Grizzle e = new Grizzle(world, player);
				e.setLocationAndAngles(i, j + 1, k, 0.0F, 0.0F);
				world.spawnEntity(e);
			}

			if (this == ModItems.eggGrizzleWhite) {
				GrizzleWhite e = new GrizzleWhite(world, player);
				e.setLocationAndAngles(i, j + 1, k, 0.0F, 0.0F);
				world.spawnEntity(e);
			}
			// player.triggerAchievement(DivineRPGAchievements.petCollector);
			stack.shrink(1);
			return EnumActionResult.PASS;
		}
		return EnumActionResult.FAIL;
	}
}
