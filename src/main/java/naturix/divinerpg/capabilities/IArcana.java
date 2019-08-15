package naturix.divinerpg.capabilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public interface IArcana
{
    /*
        Consumes arcana and sends packet
     */
    public void consume(EntityLivingBase player, float points);

    /*
        Restoring arcana and send packet
     */
    public void fill(EntityLivingBase player, float points);

    public void set(float points);
    
    public float getArcana();

    public float getCoolDown();
    public void setColDown(float number);

    public float getMax();
    public void setMax(float number);
    
    public void regen(EntityPlayer player);
}