package divinerpg.entities.base;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.*;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

public abstract class EntityDivineBoss extends EntityDivineMonster {
    protected ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);
    public EntityDivineBoss(EntityType<? extends EntityDivineBoss> type, Level worldIn) {
        super(type, worldIn);
        xpReward = XP_REWARD_BOSS;
    }
    @Override public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((s) -> s.withHoverEvent(createHoverEvent()).withInsertion(getStringUUID()).withBold(true));
    }
    @Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {return false;}
    @Override public void knockback(double strength, double x, double z) {}
    @Override public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossEvent.setName(getDisplayName());
    }
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(hasCustomName()) bossEvent.setName(getDisplayName());
    }
    @Override protected void customServerAiStep() {bossEvent.setProgress(getHealth() / getMaxHealth());}
    @Override public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossEvent.addPlayer(player);
    }
    @Override public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        bossEvent.removePlayer(player);
    }
}