package divinerpg.items.vanilla;

import divinerpg.entities.projectile.DivineThrowable;
import divinerpg.entities.projectile.EntityCorruptedBullet;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCorruptedCannon extends ItemModRanged {

    public ItemCorruptedCannon() {
    super("corrupted_cannon",
            RarityList.COMMON,
            null,
            null,
            SoundRegistry.GHAST_CANNON,
            SoundCategory.MASTER,
            -1,
            4,
            () -> ItemRegistry.corruptedBullet,
            0);
}

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType, EntityType entityType) {
        for (int i = 0; i < 4; i++) {
            DivineThrowable bullet = new EntityCorruptedBullet(EntityRegistry.CORRUPTED_BULLET, player, world);
            bullet.xo += (random.nextDouble() - random.nextDouble()) / 2;
            bullet.yo += (random.nextDouble() - random.nextDouble()) / 2;
            bullet.zo += (random.nextDouble() - random.nextDouble()) / 2;

            bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(bullet);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.bowDam("4x10"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
