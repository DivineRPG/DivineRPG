package naturix.divinerpg.capabilities;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.networking.message.MessageArcanaBar;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.MathHelper;

public class Arcana implements IArcana {
    private float arcana = 200.0F;
    private float cooldown = 5.0F;
    private float max = 200.0F;

    /*
        Inner counter for cooldown
     */
    private float cooldownCounter = cooldown;


    @Override
    public void consume(EntityLivingBase player, float points) {
        set(getArcana() - points);
        sendPacket(player);
    }

    @Override
    public void fill(EntityLivingBase player, float points) {
        set(points + getArcana());
        sendPacket(player);
    }

    @Override
    public void set(float points) {
        this.arcana = MathHelper.clamp(points,0,max);
    }

    @Override
    public float getArcana() {
        return this.arcana;
    }

    @Override
    public float getCoolDown() {
        return cooldown;
    }

    @Override
    public void setColDown(float number) {
        this.cooldown = MathHelper.clamp(number, 0, max);
    }

    @Override
    public float getMax() {
        return this.max;
    }

    @Override
    public void setMax(float number) {
        this.max = number > 0
                ? 0
                : number;
    }

    @Override
    public void regen(EntityPlayer player) {
        if (cooldownCounter > 0){
            cooldownCounter -= 1;
            return;
        }

        cooldownCounter = cooldown;
        set(getArcana() + 1);
        sendPacket(player);
    }

    private void sendPacket(EntityLivingBase player){

        if (player instanceof EntityPlayerMP)
            DivineRPG.network.sendTo(new MessageArcanaBar(getArcana(), false), (EntityPlayerMP) player);
    }
}