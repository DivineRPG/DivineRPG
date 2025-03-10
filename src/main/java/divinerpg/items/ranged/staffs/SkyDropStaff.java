package divinerpg.items.ranged.staffs;

import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class SkyDropStaff extends ItemRangedWeapon {
    public final int projectileCount;
    public final int damage;
    public SkyDropStaff(Supplier<EntityType<? extends Projectile>> projectileType, int arcana, int damage, int count, int delay, int uses) {
        super(projectileType, uses);
        sound = SoundRegistry.STARLIGHT.get();
        cooldown = delay;
        arcanaConsumedUse = arcana;
        this.damage = damage;
        projectileCount = count;
        withTooltip(LocalizeUtils.arcanaDam(damage)).withTooltip(LocalizeUtils.skyShots(count));
    }
    @Override protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable LivingEntity target) {
        for(int i = 0; i < projectileCount; i++) super.shoot(level, shooter, hand, weapon, projectileItems, velocity, inaccuracy, isCrit, target);
    }
    @Override protected void shootProjectile(LivingEntity shooter, Projectile projectile, int i, float velocity, float inaccuracy, float angle, @Nullable LivingEntity livingEntity1) {
        int blockReachDistance = 32;
        Vec3 vec3d = shooter.getEyePosition(1);
        Vec3 vec3d1 = shooter.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = shooter.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, shooter));
        projectile.moveTo(pos.getBlockPos().getX() + shooter.getRandom().nextDouble() - .5, pos.getBlockPos().getY() + 20, pos.getBlockPos().getZ() + shooter.getRandom().nextDouble() - .5);
    }
}