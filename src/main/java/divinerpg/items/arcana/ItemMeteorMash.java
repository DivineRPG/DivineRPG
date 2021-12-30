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
import net.minecraft.util.math.*;
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
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType, EntityType entityType) {
        int blockReachDistance = 32;
        Vector3d vec3d = player.getEyePosition(1);
        Vector3d vec3d1 = player.getViewVector(1);
        Vector3d vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockRayTraceResult pos = player.level.clip(new RayTraceContext(vec3d, vec3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, player));


        if (!world.isClientSide) {
            ThrowableEntity entity = new EntityMeteor(EntityRegistry.METEOR, (double) pos.getBlockPos().getX() + 0.5D, (double) pos.getBlockPos().getY() + 25D,
                    (double) pos.getBlockPos().getZ() + 0.5D, world);
            entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            entity.moveTo(pos.getLocation());
            world.addFreshEntity(entity);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.meteormash"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
