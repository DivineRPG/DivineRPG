package divinerpg.objects.items.arcana;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemArcaniteBlaster extends RangedWeaponBase {
    public ItemArcaniteBlaster() {
        super("arcanite_blaster", null, BulletType.ARCANITE_BLASTER, SoundRegistry.GHAST_CANNON, SoundCategory.PLAYERS,
                6500, 7, null, 20);
    }

    @Override
    protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType,
                               Class<? extends EntityThrowable> clazz) {
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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.bowDam("30x23"));
        super.addInformation(stack, worldIn, list, flagIn);
    }
}