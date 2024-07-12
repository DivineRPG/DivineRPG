package divinerpg.entities.vanilla.overworld;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityDesertCrawler extends EntityCrawler {
    protected static final EntityDataAccessor<Boolean> HAS_SEEN = SynchedEntityData.defineId(EntityDesertCrawler.class, EntityDataSerializers.BOOLEAN);
    private boolean hasSeen;
    public EntityDesertCrawler(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HAS_SEEN, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("HasSeen", this.hasSeen);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.hasSeen = compound.getBoolean("HasSeen");
    }

    @Override
    public void tick() {
        super.tick();
        if(level().getNearestPlayer(this, 16D) != null){
            Player player = level().getNearestPlayer(this, 16D);
            if(hasLineOfSight(player)){
                hasSeen = true;
                goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
                goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
                targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
            }
        }
    }

    public boolean hasSeen(){
        return this.hasSeen;
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }
}
