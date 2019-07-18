package naturix.divinerpg.capabilities;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.networking.message.MessageArcanaBar;
import net.minecraft.entity.player.EntityPlayerMP;

public class Arcana implements IArcana
{
    private float arcana = 200.0F; 

    @Override
    public void consume(float points)
    {
        this.arcana -= points;

        if (this.arcana < 0.0F) this.arcana = 0.0F;
    }

    @Override
    public void fill(float points)
    {
        this.arcana = points + getArcana();
    }

    @Override
    public void set(float points)
    {
        this.arcana = points;
    }

    @Override
    public float getArcana()
    {
        return this.arcana;
    }
    @Override
    public void updateAllBars() {
		if(getArcana() != 200F){
			fill(1);
		} else {
			fill(0);
		}
		if(getArcana() >= 200F){
			arcana = 200F;
		}
		}
}