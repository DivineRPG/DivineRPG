package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.arcana.Paratiku;
import naturix.divinerpg.objects.entities.entity.arcana.Seimer;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemArcanaSpawnEgg extends ItemMod {

	public ItemArcanaSpawnEgg(String name) {
		super(name, DivineRPGTabs.spawner);
		setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {	ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());
		Item item = stack.getItem();
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		//FIXME - Still needs 2 mobs, achievement and auto json gen
//		Fyracryx fyracryx = new Fyracryx(world, player);
		Seimer seimer = new Seimer(world, player);
//		GolemOfRejuv golem = new GolemOfRejuv(world, player);
		Paratiku paratiku = new Paratiku(world, player);
		if(!world.isRemote){
			if(item == ModItems.fyracryxSpawner){
//				fyracryx.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
//				world.spawnEntity(fyracryx);
			}
			if(item == ModItems.seimerSpawner){
				seimer.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
				world.spawnEntity(seimer);
			}
			if(item == ModItems.golemSpawner){
//				golem.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
//				world.spawnEntity(golem);
			}
			if(item == ModItems.paratikuSpawner){
				paratiku.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
				world.spawnEntity(paratiku);
			}
//			player.triggerAchievement(DivineRPGAchievements.littleCreature);
			stack.shrink(1);
			return EnumActionResult.PASS;
		}
		return EnumActionResult.FAIL;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {	Item item = stack.getItem();
		if(item == ModItems.fyracryxSpawner)
			list.add(TooltipHelper.getInfoText("tooltip.arcana_spawn.fyracryx"));
		
		if(item == ModItems.seimerSpawner)
			list.add(TooltipHelper.getInfoText("tooltip.arcana_spawn.seimer"));
		
		if(item == ModItems.golemSpawner)
			list.add(TooltipHelper.getInfoText("tooltip.arcana_spawn.golem"));
		
		if(item == ModItems.paratikuSpawner)
			list.add(TooltipHelper.getInfoText("tooltip.arcana_spawn.paratiku"));
	}
}