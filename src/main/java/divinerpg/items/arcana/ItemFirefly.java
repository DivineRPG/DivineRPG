package divinerpg.items.arcana;

import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFirefly extends ItemModRanged {
    public ItemFirefly() {
        super("firefly", RarityList.COMMON, EntityRegistry.FIREFLY, null, SoundRegistry.FIREFLY, SoundCategory.PLAYERS, -1, 0, null, 5);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.homingShots());
        tooltip.add(LocalizeUtils.rangedDam(15));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType,
                               EntityType<?> entityType) {

        ThrowableEntity bullet = new EntityFirefly(EntityRegistry.FIREFLY, player, world);
        bullet.moveTo(player.xo, player.getEyeY(), player.zo);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
        world.addFreshEntity(bullet);
    }

}
