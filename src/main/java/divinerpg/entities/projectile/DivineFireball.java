package divinerpg.entities.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.event.EventHooks;

import static net.minecraft.world.entity.projectile.ProjectileDeflection.NONE;

public class DivineFireball extends Fireball {
    public byte explosionPower = 0;

    public DivineFireball(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
    }

    public DivineFireball(EntityType<? extends DivineFireball> type, Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(type, shooter, new Vec3(accelX, accelY, accelZ), world);
        setOwner(shooter);
    }

    public DivineFireball(EntityType<? extends DivineFireball> type, Level world, LivingEntity shooter, double accelX, double accelY, double accelZ, byte explosionPower) {
        super(type, shooter, new Vec3(accelX, accelY, accelZ), world);
        setOwner(shooter);
        this.explosionPower = explosionPower;
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount > 200) {
            discard();
        }
    }

    @Override
    public ProjectileDeflection deflection(Projectile projectile) {
        return NONE;
    }

    @Override
    protected void onHit(HitResult result) {
        if (tickCount > 1) {
            super.onHit(result);
            if (!level().isClientSide() && explosionPower > 0) {
                boolean flag = EventHooks.canEntityGrief(level().getServer().getLevel(level().dimension()), getOwner());
                level().explode(
                        this,
                        getX(),
                        getY(),
                        getZ(),
                        (float) explosionPower,
                        flag,
                        Level.ExplosionInteraction.MOB
                );
                discard();
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (tickCount > 1) {
            super.onHitEntity(result);
            if (level() instanceof ServerLevel level) {
                Entity entity = result.getEntity();
                Entity owner = getOwner();
                DamageSource source = damageSources().fireball(this, owner);

                if (entity.hurtServer(level, source, 6.0F) && owner instanceof LivingEntity) {
                    EnchantmentHelper.doPostAttackEffects(level, entity, source);
                }
            }
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putByte("ExpolosionPower", explosionPower);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        explosionPower = input.getByteOr("ExplosionPower", (byte) 1);
    }
}