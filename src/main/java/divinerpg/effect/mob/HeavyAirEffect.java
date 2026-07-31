package divinerpg.effect.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.GameType;

import static divinerpg.registries.BlockRegistry.dungeonAir;
import static divinerpg.registries.MobEffectRegistry.HEAVY_AIR;

public class HeavyAirEffect extends MobEffect {
    public HeavyAirEffect() {super(MobEffectCategory.HARMFUL, 3223347);}
    @Override public void onEffectAdded(LivingEntity entity, int amplifier) {
        super.onEffectAdded(entity, amplifier);
        if(entity instanceof ServerPlayer s && s.gameMode.getGameModeForPlayer() == GameType.SURVIVAL) s.setGameMode(GameType.ADVENTURE);
    }



    @Override public void onMobRemoved(ServerLevel level, LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
        if(entity instanceof ServerPlayer s && s.gameMode.getGameModeForPlayer() == GameType.ADVENTURE) s.setGameMode(GameType.SURVIVAL);
    }
    @Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return duration == 10;}
    @Override public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int i) {
        if(entity.level().getBlockState(new BlockPos(entity.getBlockX(), (int) (entity.getY() + entity.getEyeHeight()), entity.getBlockZ())).is(dungeonAir)) {
            entity.addEffect(new MobEffectInstance(HEAVY_AIR, 20, 1, true, false, false));
            return true;
        } if(entity instanceof ServerPlayer s && s.gameMode.getGameModeForPlayer() == GameType.ADVENTURE) s.setGameMode(GameType.SURVIVAL);
        return false;
    }
}