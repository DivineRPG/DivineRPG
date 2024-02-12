package divinerpg.capability;

import divinerpg.registries.MobEffectRegistry;
import divinerpg.util.DivineRPGPacketHandler;
import divinerpg.util.packets.PacketArcanaBar;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.network.NetworkDirection;

public class Arcana implements IArcana {
    private int tickDelay = 4;
    private float max = 200;
    private float arcana = max;

    @Override
    public void consume(Player player, float points) {
        if (player.isCreative()) return;

        set(getArcana() - points);
        sendPacket(player);
    }

    @Override
    public void fill(Player player, float points) {
        float prev = getArcana();
        set(prev + points);

        if (prev != getArcana())
            sendPacket(player);
    }

    @Override
    public void regen(Player player) {
        if (player.level().getGameTime() % tickDelay == 0) {
            fill(player, player.hasEffect(MobEffectRegistry.KORMA_ARCANA.get()) ? 4 : 1);
        }
    }

    @Override
    public void set(float points) {
        if (points < getMaxArcana()) {
            arcana = points;
        }else {
            arcana = getMaxArcana();
        }
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

    private void sendPacket(Player player) {
        if (!(player instanceof FakePlayer) && player instanceof ServerPlayer) {
            DivineRPGPacketHandler.INSTANCE.sendTo(new PacketArcanaBar(this), ((ServerPlayer) player).connection.connection, NetworkDirection.PLAY_TO_CLIENT);
        }
    }



    public void saveNBTData(CompoundTag compound) {
        compound.putFloat("arcana", arcana);
    }

    public void loadNBTData(CompoundTag compound) {
        arcana = compound.getFloat("arcana");
    }

    @Override
    public CompoundTag serializeNBT() {
        return new CompoundTag();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}