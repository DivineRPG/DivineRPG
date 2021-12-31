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

public class ItemGeneralsStaff extends ItemModRanged {

    public ItemGeneralsStaff() {
        super("generals_staff", RarityList.COMMON, EntityRegistry.GENERALS_STAFF, null, SoundRegistry.STARLIGHT, SoundCategory.MASTER, -1, 12,
                null, 20);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(18));
        tooltip.add(LocalizeUtils.i18n("tooltip.generals_staff.split"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType,
                               EntityType<?> entityType) {

        ThrowableEntity bullet = new EntityGeneralsStaff(EntityRegistry.GENERALS_STAFF, player, world);
        bullet.moveTo(player.xo, player.getEyeY(), player.zo);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
        world.addFreshEntity(bullet);
    }

}
