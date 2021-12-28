package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemArcaniteBlaster extends ItemModRanged {

    public ItemArcaniteBlaster() {
        super("arcanite_blaster", RarityList.COMMON, null, BulletType.ARCANITE_BLASTER, SoundRegistry.GHAST_CANNON, SoundCategory.PLAYERS,
                6500, 7, null, 20);
    }

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType,
                               EntityType entityType) {
        Random rand = world.random;

        for (int i = 0; i < 30; i++) {
            ThrowableEntity entity = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET, player, world, BulletType.ARCANITE_BLASTER);
            entity.xo += (rand.nextDouble() - rand.nextDouble()) * 1.5;
            entity.yo += (rand.nextDouble() - rand.nextDouble()) * 1.5;
            entity.zo += (rand.nextDouble() - rand.nextDouble()) * 1.5;
            entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(entity);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.bowDam("30x23"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}