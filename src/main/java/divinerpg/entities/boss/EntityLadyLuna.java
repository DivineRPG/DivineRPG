package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EntityLadyLuna extends EntityDivineBoss {

    public EntityLadyLuna(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.setRandomProtectionValues();
    }

    public enum ProtectionType {
        ARCANA(0), RANGED(1), MELEE(2);

        private int numVal;

        ProtectionType(int numVal) {
            this.numVal = numVal;
        }

        public int value() {
            return numVal;
        }
    }

    public ProtectionType protectionType;
    private int protectionTimer;

    private List<BlockPos> acidPositions = new ArrayList<BlockPos>();

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, PiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide && this.tickCount % 5 == 0) {
            for (int x = (int) this.getX() - 2; x < (int) this.getX() + 2; x++) {
                for (int y = (int) this.getBoundingBox().minY; y < (int) this.getBoundingBox().minY + 4; y++) {
                    for (int z = (int) this.getZ() - 2; z < (int) this.getZ() + 2; z++) {
                        if (this.level.getBlockState(new BlockPos(x, y, z)).getMaterial() == Material.LEAVES || this.level.getBlockState(new BlockPos(x, y, z)).getMaterial() == Material.WOOD)
                            this.level.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 1);
                    }
                }
            }
        }

        BlockPos current = new BlockPos((int)getX() - 1, (int)getY(), (int)getZ() - 1);
        BlockPos below = new BlockPos((int)getX() - 1, (int)getY() - 1, (int)getZ() - 1);
        BlockState belowState = this.level.getBlockState(below);

        if(this.level.getBlockState(current).getBlock() == Blocks.AIR) {
            if(belowState.canOcclude() && belowState.hasLargeCollisionShape()) {
                this.level.setBlock(current, BlockRegistry.lunicAcid.defaultBlockState(), 1);
                acidPositions.add(current);
            }
        }

        if (!this.level.isClientSide && this.getProtectionType() == ProtectionType.ARCANA && this.tickCount % 30 == 0) {
            Iterator<BlockPos> iter = this.acidPositions.iterator();
            while (iter.hasNext()) {
                BlockPos pos = iter.next();

                if (this.level.getBlockState(pos).getBlock() != BlockRegistry.lunicAcid) iter.remove();
                else if (this.random.nextInt(4) == 0) {
                    //TODO - Lady luna sparkler
//                    EntityLadyLunaSparkler e = new EntityLadyLunaSparkler(this.world, this);
//                    e.setPosition(pos.getX() + 0.5, pos.getY() + 0, pos.getZ() + 0.5);
//                    this.level.spawnEntity(e);
                }
            }
        }

        if (this.getProtectionTimer() <= 0) {
            this.setRandomProtectionValues();
        } else if (this.getProtectionTimer() > 0) {
            this.setProtectionTimer(getProtectionTimer() - 1);
        }
    }

    public void setProtectionType(ProtectionType type) {
        if(type == ProtectionType.ARCANA) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
        }
        else
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32D);
       this.protectionType = type;
    }

    public void setProtectionTimer(int i) {
        this.protectionTimer = i;
    }

    public ProtectionType getProtectionType() {
        return this.protectionType;
    }

    public int getProtectionTimer() {
        return this.protectionTimer;
    }

    @Override
    public boolean hurt(DamageSource source, float par2) {
        if (source.isExplosion()) return false;

        ProtectionType type = this.getProtectionType();
        if (source.isMagic() && type == ProtectionType.ARCANA)
            return false;
        else if ((source.isProjectile() || source.getMsgId().equals("thrown")) && type == ProtectionType.RANGED)
            return false;
        else if (!source.isProjectile() && !source.isMagic() && type == ProtectionType.MELEE)
            return false;
        return super.hurt(source, par2);
    }

    @Override
    public boolean doHurtTarget(Entity e) {
        int dam = 20;

        boolean var4 = e.hurt(DamageSource.mobAttack(this), dam);
        if (var4) {
            this.level.explode(this, e.getX(), e.getY(), e.getZ(), 2, Explosion.Mode.DESTROY);
            this.xo *= 0.6D;
            this.zo *= 0.6D;
            int var5 = EnchantmentHelper.getFireAspect(this);
            if (var5 > 0)
                e.setSecondsOnFire(var5 * 4);
        }
        return var4;
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Immunity", this.getProtectionType().value());
        tag.putInt("ImmunityCooldown", this.getProtectionTimer());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        this.setProtectionType(protectionTypeForInt(tag.getInt("Immunity")));
        this.setProtectionTimer(tag.getInt("ImmunityCooldown"));
    }

    private static ProtectionType protectionTypeForInt(int i) {
        switch(i) {
            case 0:
                return ProtectionType.ARCANA;
            case 1:
                return ProtectionType.RANGED;
            case 2:
                return ProtectionType.MELEE;
            default:
                return null;
        }
    }

    @Override
    public int getMaxSpawnClusterSize() {return 3;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    private void setRandomProtectionValues() {
        this.setProtectionType(protectionTypeForInt(this.random.nextInt(3)));
        this.setProtectionTimer(200 + this.random.nextInt(200));
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.ladyLunaHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.ladyLunaDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.ladyLunaSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.ladyLunaFollowRange);
    }
}
