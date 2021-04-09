package divinerpg.capability;

import divinerpg.config.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraftforge.common.util.*;

public class Arcana implements IArcana {
    private int tickDelay = 4;
    private float max = (float) Config.maxArcana.get();
    private float arcana = max;

    @Override
    public void consume(PlayerEntity player, float points) {
        if (player.isCreative()) return;

        set(getArcana() - points);
        sendPacket(player);
    }

    @Override
    public void fill(PlayerEntity player, float points) {
        float prev = getArcana();
        set(prev + points);

        if (prev != getArcana())
            sendPacket(player);
    }

    @Override
    public void regen(PlayerEntity player) {
        if (player.level.getGameTime() % tickDelay == 0) {
            fill(player, 1);
        }
    }

    @Override
    public void set(float points) {
        arcana = MathHelper.clamp(points, 0, getMaxArcana());
    }

    @Override
    public float getArcana() {
        return arcana;
    }

    @Override
    public float getMaxArcana() {
        return max;
    }

    @Override
    public void setMaxArcana(float max) {
        if (max < 0) {
            throw new IllegalArgumentException("Max of arcana can't be less then null!");
        }

        this.max = max;
    }

    @Override
    public int getRegenDelay() {
        return tickDelay;
    }

    @Override
    public void setRegenDelay(int delay) {
        if (delay < 1) {
            throw new IllegalArgumentException("Tick delay between regen can't be less than one!");
        }

        tickDelay = delay;
    }

    private void sendPacket(PlayerEntity player) {
        if (!(player instanceof FakePlayer) && player instanceof ServerPlayerEntity) {
            //TODO - send arcana bar networking
//            DivineRPG.network.sendTo(new MessageArcanaBar(this), (ServerPlayerEntity) player);
        }
    }
}