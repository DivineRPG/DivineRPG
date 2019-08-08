package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.events.Ticker;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class ItemOrbOfLight extends ItemMod {

	public ItemOrbOfLight() {
		super("orb_of_light");
		setCreativeTab(DivineRPGTabs.utility);
	}
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int var4, boolean var5) {
		if(Ticker.tick%2 == 0) {
		world.setLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ), 15);
        world.markBlockRangeForRenderUpdate((int)entity.posX, (int)entity.posY, (int)entity.posX, 12, 12, 12);
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY +1, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY +1, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY +1, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY -1, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY -1, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY -1, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX +1, (int)entity.posY, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY, (int)entity.posZ -1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX -1, (int)entity.posY, (int)entity.posZ));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ +1));
        world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ -1));
		}
	}
}