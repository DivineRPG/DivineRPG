package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;
import net.minecraft.world.World;


public class EntitySaguaroWorm extends EntityDivineMob {
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.createKey(EntitySaguaroWorm.class, DataSerializers.BOOLEAN);
    public EntitySaguaroWorm(EntityType<? extends EntitySaguaroWorm> type, World worldIn) {
        super(type, worldIn);
    }
    @Override
    public boolean needsSpecialAI() {
        return true;
    }
    public double getMountedYOffset() {
        return (double)(2.5F);
    }
    protected PathNavigator createNavigator(World worldIn) {
        return new ClimberPathNavigator(this, worldIn);
    }

    protected void registerData() {
        super.registerData();
        dataManager.register(PROVOKED, Boolean.valueOf(false));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    public boolean getProvoked() {
        return this.dataManager.get(PROVOKED).booleanValue();
    }

    public void setProvoked(boolean provoked) {
        dataManager.set(PROVOKED, Boolean.valueOf(provoked));
    }
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            PlayerEntity player = this.world.getClosestPlayer(this, 10.0D);
            this.setAttackTarget(player);
            if (player == null) {
                this.setProvoked(false);
            } else {
                this.setProvoked(true);
                if (this.ticksExisted % 50 == 0) {
                    this.attack(player);
                }
            }
        }
        if (!this.getProvoked()) {
            this.renderYawOffset = 0;
        }
    }
    public void attack(LivingEntity e) {
        double y = this.getBoundingBox().minY + 2.7D;
        double tx = e.getPosX() - getPosX();
        double ty = e.getBoundingBox().minY - y;
        double tz = e.getPosZ() - getPosZ();

        for (double h = -1.5; h < 1.5; h += 0.5) {
            for (double r = 0; r < 1.5 - Math.abs(h); r += 0.5) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                    //TODO - add saguaro worm shot
//                    EntitySaguaroWormShot shot = new EntitySaguaroWormShot(this.world, this);
//                    shot.posX = this.posX + r * Math.cos(theta);
//                    shot.posY = this.posY + 5 + h;
//                    shot.posZ = this.posZ + r * Math.sin(theta);
//                    shot.shoot(tx, ty, tz, 0.9f, 5);
//                    world.spawnEntity(shot);
                }
            }
        }
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.saguaroWormHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.saguaroWormDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.saguaroWormSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.saguaroWormFollowRange);
    }
    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
            setProvoked(tag.getBoolean("Provoked"));
    }

    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putBoolean("Provoked", this.getProvoked());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SAGUARO_WORM;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SAGUARO_WORM;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SAGUARO_WORM;
    }
}
