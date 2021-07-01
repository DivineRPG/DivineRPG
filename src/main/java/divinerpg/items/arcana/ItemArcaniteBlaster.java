package divinerpg.items.arcana;

import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemArcaniteBlaster extends ItemModRanged {

    public ItemArcaniteBlaster() {
        super("arcanite_blaster", null, BulletType.ARCANITE_BLASTER, SoundRegistry.GHAST_CANNON, SoundCategory.PLAYERS,
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