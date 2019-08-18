package naturix.divinerpg.objects.items.arcana;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArcaniteBlaster extends RangedWeaponBase {
	public ItemArcaniteBlaster() {
		super("arcanite_blaster",
				null,
				BulletType.ARCANITE_BLASTER,
				ModSounds.GHAST_CANNON,
				SoundCategory.PLAYERS,
				6500, 4,
				null,
				20);
	}

	@Override
	protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType, Class<? extends EntityThrowable> clazz) {
		Random rand = world.rand;

		for (int i = 0; i < 30; i++) {
			EntityThrowable entity = new EntityShooterBullet(world, player, BulletType.ARCANITE_BLASTER);
			entity.posX += (rand.nextDouble() - rand.nextDouble()) * 1.5;
			entity.posY += (rand.nextDouble() - rand.nextDouble()) * 1.5;
			entity.posZ += (rand.nextDouble() - rand.nextDouble()) * 1.5;
			entity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(entity);
		}
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {
    	list.add(TooltipLocalizer.bowDam("30x23"));
    	super.addInformation(stack, worldIn,list,flagIn);
	}
}