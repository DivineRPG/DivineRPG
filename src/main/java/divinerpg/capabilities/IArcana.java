package divinerpg.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public interface IArcana {
    // Consumes arcana and sends packet
    public void consume(EntityPlayer player, float points);

    // Adds arcana and send packet
    public void fill(EntityPlayer player, float points);

    // Player regeneration of arcana and send pakect 
    public void regen(EntityPlayer player);

    public void set(float points);

    public float getArcana();

    public float getMaxArcana();

    public float getRegenDelay();

    public void setRegenDelay(int delay);
}