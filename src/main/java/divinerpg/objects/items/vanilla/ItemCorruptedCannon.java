package divinerpg.objects.items.vanilla;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.projectiles.EntityCorruptedBullet;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCorruptedCannon extends RangedWeaponBase {
    private Random rand = new Random();

    public ItemCorruptedCannon(String name) {
        super(name,
                null,
                null,
                ModSounds.GHAST_CANNON,
                SoundCategory.MASTER,
                -1,
                4,
                () -> ModItems.corruptedBullet,
                0);
    }

    @Override
    protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType, Class<? extends EntityThrowable> clazz) {
        for (int i = 0; i < 4; i++) {
            EntityThrowable bullet = new EntityCorruptedBullet(world, player);
            bullet.posX += (this.rand.nextDouble() - this.rand.nextDouble()) / 2;
            bullet.posY += (this.rand.nextDouble() - this.rand.nextDouble()) / 2;
            bullet.posZ += (this.rand.nextDouble() - this.rand.nextDouble()) / 2;

            bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(bullet);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.bowDam("4x10"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
