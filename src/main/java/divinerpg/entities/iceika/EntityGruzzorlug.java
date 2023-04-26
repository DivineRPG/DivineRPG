package divinerpg.entities.iceika;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityCorruptedBullet;
import divinerpg.registries.EntityRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityGruzzorlug extends EntityDivineMonster implements RangedAttackMob {
    protected static final EntityDataAccessor<Integer> ITEM = SynchedEntityData.defineId(EntityGruzzorlug.class, EntityDataSerializers.INT);

    public EntityGruzzorlug(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ITEM, 0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityGroglin.class, true));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public int heldItem() {
        return this.entityData.get(ITEM);
    }

    int tickCounter;
    @Override
    public void tick() {
        super.tick();
        tickCounter++;
        if(tickCounter < 300){
            entityData.set(ITEM, 0);
        }
        if(tickCounter == 300){
            entityData.set(ITEM, 1);
        }
        if(tickCounter == 600){
            entityData.set(ITEM, 2);
        }
        if(tickCounter == 900){
            tickCounter = 0;
        }
        if(entityData.get(ITEM) == 2) {
            goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float) getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        }

    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("tickCounter", tickCounter);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        tickCounter = tag.getInt("tickCounter");
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distance) {
        if (isAlive() && getTarget() != null && !level.isClientSide && entityData.get(ITEM) == 2) {
            EntityCorruptedBullet projectile = new EntityCorruptedBullet(EntityRegistry.CORRUPTED_BULLET.get(), this, level);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level.addFreshEntity(projectile);
        }
    }

    @Override
    public void die(DamageSource source) {
        if (entityData.get(ITEM) == 1 && level.random.nextBoolean()) {
            level.addFreshEntity(new ItemEntity(level, getX(), getY(), getZ(), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_pickaxe")))));
        }
        if (entityData.get(ITEM) == 2 && level.random.nextBoolean()) {
            level.addFreshEntity(new ItemEntity(level, getX(), getY(), getZ(), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_cannon")))));
        }
        super.die(source);
    }
}