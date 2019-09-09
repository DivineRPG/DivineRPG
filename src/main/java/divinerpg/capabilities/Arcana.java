package divinerpg.capabilities;

import divinerpg.DivineRPG;
import divinerpg.api.arcana.IArcana;
import divinerpg.networking.message.MessageArcanaBar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.MathHelper;

public class Arcana implements IArcana {
    private int tickDelay = 1;
    private float max = 200;
    private float arcana = max;

    @Override
    public void consume(EntityPlayer player, float points) {
        if (player.capabilities.isCreativeMode) return;

        set(getArcana() - points);
        sendPacket(player);
    }

    @Override
    public void fill(EntityPlayer player, float points) {
        float prev = getArcana();
        set(prev + points);

        if (prev != getArcana())
            sendPacket(player);
    }

    @Override
    public void regen(EntityPlayer player) {

        int delay = tickDelay;
        // If fully drained, need to add 2 seconds more
        if (getArcana() == 0) {
            delay += 40;
        }

        if (player.world.getTotalWorldTime() % delay == 0) {
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
            throw new IllegalArgumentException("Max of arcana cn't be less then null!");
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
            throw new IllegalArgumentException("Tick delay beetween regen can't be less than one!");
        }

        tickDelay = delay;
    }

    private void sendPacket(EntityPlayer player) {
        if (player instanceof EntityPlayerMP)
            DivineRPG.network.sendTo(new MessageArcanaBar(this), (EntityPlayerMP) player);
    }
}