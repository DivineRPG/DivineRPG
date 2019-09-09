package divinerpg.capabilities;

import divinerpg.DivineRPG;
import divinerpg.api.IArcana;
import divinerpg.networking.message.MessageArcanaBar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.MathHelper;

public class Arcana implements IArcana {
    public static final float regenPointsPerTick = 0.25F;
    public static final int regenDelayInTicks = 50;
    public static final float arcanaMax = 200.0F;
    private float arcana = arcanaMax;

    private int regenDelay = 0;

    @Override
    public void consume(EntityPlayer player, float points) {
        if (player.capabilities.isCreativeMode) {
            return;
        }
        regenDelay = regenDelayInTicks;
        set(getArcana() - points);
        sendPacket(player);
    }

    @Override
    public void fill(EntityPlayer player, float points) {
        set(points + getArcana());
        sendPacket(player);
    }

    @Override
    public void regen(EntityPlayer player) {
        if (regenDelay > 0) {
            regenDelay -= 1;
            return;
        }
        set(getArcana() + regenPointsPerTick);
        sendPacket(player);
    }

    private void sendPacket(EntityPlayer player) {
        if (player instanceof EntityPlayerMP)
            DivineRPG.network.sendTo(new MessageArcanaBar(getArcana(), false), (EntityPlayerMP) player);
    }

    @Override
    public void set(float points) {
        this.arcana = MathHelper.clamp(points, 0, arcanaMax);
    }

    @Override
    public float getArcana() {
        return this.arcana;
    }

    @Override
    public float getMaxArcana() {
        return this.arcanaMax;
    }

    public int getRegenDelay() {
        return regenDelay;
    }

    @Override
    public void setRegenDelay(int delay) {
        this.regenDelay = MathHelper.clamp(delay, 0, regenDelayInTicks);
    }
}