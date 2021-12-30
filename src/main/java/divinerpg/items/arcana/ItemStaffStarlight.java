package divinerpg.items.arcana;

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
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemStaffStarlight extends ItemModRanged {

    /**
     * Amount of spawned entities
     */
    private final int count;

    private final ITextComponent starsInfo;

    /**
     * @param name   name of ite,
     * @param arcana - arcana consuming amount
     * @param count  - count of spawning entities
     */
    public ItemStaffStarlight(String name, int arcana, int count) {
        super(name, RarityList.COMMON, EntityRegistry.STARLIGHT, null, SoundRegistry.STARLIGHT, SoundCategory.MASTER, -1, 0, null, arcana);
        this.count = count;

        starsInfo = LocalizeUtils.i18n(count > 1 ? "tooltip.staff_of_starlight" : "tooltip.starlight");
    }

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType, EntityType entityType) {
        int blockReachDistance = 32;
        Vector3d vec3d = player.getEyePosition(1);
        Vector3d vec3d1 = player.getViewVector(1);
        Vector3d vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockRayTraceResult pos = player.level.clip(new RayTraceContext(vec3d, vec3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, player));

            if (!world.isClientSide) {
                for (int i = 0; i < count; i++) {
                    EntityStar star = new EntityStar(EntityRegistry.STARLIGHT, (double) pos.getBlockPos().getX() + 0.5D, (double) pos.getBlockPos().getY() + 25D, (double) pos.getBlockPos().getZ() + 0.5D, world);
                    star.moveTo(pos.getBlockPos().getX(), pos.getBlockPos().getY() + 20, pos.getBlockPos().getZ());
                    world.addFreshEntity(star);
                }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(20));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(starsInfo);
    }

}