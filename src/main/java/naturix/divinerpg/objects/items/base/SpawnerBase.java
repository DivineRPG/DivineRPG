package naturix.divinerpg.objects.items.base;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

public class SpawnerBase extends Item {

	protected String name;

	public SpawnerBase(String name, Entity entityIn) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DRPGCreativeTabs.spawner);
	}

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

	// @Override(non-Javadoc)
	// public ActionResult<ItemStack> onItemRightClick(World worldgen, EntityPlayer
	// entity, EnumHand hand) {
	// float var4 = 1.0F;
	// ActionResult<ItemStack> ar = super.onItemRightClick(worldgen, entity, hand);
	// int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * (double)
	// var4);
	// int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * (double)
	// var4 + 1.62D);
	// int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)
	// var4);
	// if (true) {
	// worldgen.spawnEntity(entityIn);
	// }

	// return ar;
	// }
}