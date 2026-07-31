package divinerpg.attachments.data;

import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import divinerpg.attachments.data.base.ServerHandledAttachment;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.entity.Entity;

import divinerpg.entities.base.FactionEntity.Faction;

public class Reputation extends ServerHandledAttachment<Integer> {
    public final Supplier<Faction> faction;
    public Reputation(String name, Supplier<Faction> faction) {
        super(name, () -> faction.get().startingReputation, Codec.INT, ByteBufCodecs.INT);
        this.faction = faction;
    }
    public void modify(Entity e, int reputation) {
        setSilent(e, get(e) + reputation);
    }
}