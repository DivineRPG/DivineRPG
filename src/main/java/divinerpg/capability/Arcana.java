package divinerpg.capability;

import divinerpg.config.Config;
import divinerpg.registries.NetworkingRegistry;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;

public class Arcana {
    private int tickDelay = 4;
    private float max = 200;
    private float arcana = Config.maxArcana.get();

    public Arcana() {
        this(200);
    }

    public Arcana(float initialChargeLevel) {
        arcana = initialChargeLevel;
    }

    public float getArcana() {
        return arcana;
    }

    public void consume(PlayerEntity player, float points) {
        if (player.isCreative()) return;

        set(getArcana() - points);
        sendPacket(player);
    }

    public void fill(PlayerEntity player, float points) {
        float prev = getArcana();
        set(prev + points);

        if (prev != getArcana()){
             sendPacket(player);
        }
    }

    public void regen(PlayerEntity player) {
        if (player.level.getGameTime() % tickDelay == 0) {
            fill(player, 1);
        }
    }

    public void set(float points) {
        arcana = MathHelper.clamp(points, 0, getMaxArcana());
    }


    public float getMaxArcana() {
        return max;
    }

    public void setMaxArcana(float max) {
        if (max < 0) {
            throw new IllegalArgumentException("Max of arcana can't be less then null!");
        }

        this.max = max;
    }

    public int getRegenDelay() {
        return tickDelay;
    }

    public void setRegenDelay(int delay) {
        if (delay < 1) {
            throw new IllegalArgumentException("Tick delay beetween regen can't be less than one!");
        }

        tickDelay = delay;
    }

    private void sendPacket(PlayerEntity player) {
        if (!(player instanceof FakePlayer) && player instanceof ServerPlayerEntity && player != null) {
            NetworkingRegistry.INSTANCE.sendTo(new PacketArcanaBar(this),((ServerPlayerEntity) player).connection.connection, NetworkDirection.PLAY_TO_CLIENT);
        }
    }


    public static class ArcanaStorage implements Capability.IStorage<Arcana> {
        @Override
        public INBT writeNBT(Capability<Arcana> capability, Arcana instance, Direction side) {
            FloatNBT floatNBT = FloatNBT.valueOf(instance.arcana);
            return floatNBT;
        }

        @Override
        public void readNBT(Capability<Arcana> capability, Arcana instance, Direction side, INBT nbt) {
            float arcana = 0;
            if (nbt.getType() == FloatNBT.TYPE) {
                arcana = ((FloatNBT) nbt).getAsFloat();
            }
            instance.set(arcana);
        }
    }

    public static Arcana createADefaultInstance() {
        return new Arcana();
    }
}