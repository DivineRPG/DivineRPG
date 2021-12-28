package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityMeteor;
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
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMeteorMash extends ItemModRanged {
    public ItemMeteorMash() {
        super("meteor_mash", RarityList.COMMON, null, null, SoundRegistry.STARLIGHT, SoundCategory.MASTER, -1, 0, null, 35);
    }

    @Override
    protected boolean canUseRangedWeapon(PlayerEntity player, ItemStack stack) {
        Vector3d start  = player.getEyePosition(1);
        Vector3d vec31 = player.getViewVector(1);
        Vector3d end = start.add(vec31.x * 32, vec31.y * 32, vec31.z * 32);
        RayTraceContext pos = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player);

        if (pos != null) {
            return false;
        }

        return super.canUseRangedWeapon(player, stack);
    }

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType, EntityType entityType) {
                Vector3d start  = player.getEyePosition(1);
        Vector3d vec31 = player.getViewVector(1);
        Vector3d end = start.add(vec31.x * 32, vec31.y * 32, vec31.z * 32);
        RayTraceContext pos = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player);

        if (!world.isClientSide) {
            ThrowableEntity entity = new EntityMeteor(EntityRegistry.METEOR, (double) pos.getTo().x + 0.5D, (double) pos.getTo().y + 25D,
                    (double) pos.getTo().z + 0.5D, world);
            entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(entity);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.meteormash"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
