package divinerpg.items.vanilla;

import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemCorruptedCannon extends ItemModRanged {

    public ItemCorruptedCannon() {
    super("corrupted_cannon",
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
