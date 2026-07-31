package divinerpg.entities.base;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.scores.PlayerTeam;

import javax.annotation.Nullable;

public class EntityDivineBoss extends EntityDivineMonster {
    protected ServerBossEvent bossEvent = new ServerBossEvent(uuid, getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);
    public EntityDivineBoss(EntityType<? extends EntityDivineBoss> type, Level worldIn) {
        super(type, worldIn);
        xpReward = XP_REWARD_BOSS;
    }
    @Override public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((s) -> s.withHoverEvent(createHoverEvent()).withInsertion(getStringUUID()).withBold(true));
    }
    @Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {return false;}
    @Override public void knockback(double power, double xd, double zd, DamageSource source, float damage) {}
    @Override public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossEvent.setName(getDisplayName());
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
    if(hasCustomName()) bossEvent.setName(getDisplayName());
    }
    @Override protected void customServerAiStep(ServerLevel level) {bossEvent.setProgress(getHealth() / getMaxHealth());}
    @Override public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossEvent.addPlayer(player);
    }
    @Override public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        bossEvent.removePlayer(player);
    }
}