package naturix.divinerpg.entities;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.CannonBase;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCustomArrow extends EntityTippedArrow {

	public EntityCustomArrow(World a) {
		super(a);
	}

	public EntityCustomArrow(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityCustomArrow(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entity) {
		super.onCollideWithPlayer(entity);
		int i = MathHelper.floor(this.getEntityBoundingBox().minX + 0.001D);
		int j = MathHelper.floor(this.getEntityBoundingBox().minY + 0.001D);
		int k = MathHelper.floor(this.getEntityBoundingBox().minZ + 0.001D);
		World world = this.world;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		int i = MathHelper.floor(this.getEntityBoundingBox().minX + 0.001D);
		int j = MathHelper.floor(this.getEntityBoundingBox().minY + 0.001D);
		int k = MathHelper.floor(this.getEntityBoundingBox().minZ + 0.001D);
		World world = this.world;
		Entity entity = (Entity) shootingEntity;
		{
		}
		if (getBlock(this.world, i, j, k) != Blocks.AIR || getBlock(this.world, i, j - 1, k) != Blocks.AIR
				|| getBlock(this.world, i, j + 1, k) != Blocks.AIR || getBlock(this.world, i + 1, j, k) != Blocks.AIR
				|| getBlock(this.world, i - 1, j, k) != Blocks.AIR || getBlock(this.world, i, j, k + 1) != Blocks.AIR
				|| getBlock(this.world, i, j, k - 1) != Blocks.AIR) {
			this.world.removeEntity(this);
		}
	}

	public Block getBlock(World par1World, int i, int j, int k) {
		return par1World.getBlockState(new BlockPos(i, j, k)).getBlock();
	}
	

	@SideOnly(Side.CLIENT)
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustomArrow.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(),
				new ItemStack(ModItems.acid).getItem(), Minecraft.getMinecraft().getRenderItem()));
	}

	public void preInit(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId + ":acid"), EntityCustomArrow.class, "entitybulletgun", 1,
				CannonBase.instance, 64, 1, true);
		ForgeRegistries.ITEMS.register(ModItems.acid);
	}

}
