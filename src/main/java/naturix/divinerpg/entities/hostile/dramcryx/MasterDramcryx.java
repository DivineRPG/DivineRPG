package naturix.divinerpg.entities.hostile.dramcryx;

import naturix.divinerpg.utils.ChunkCoord;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MasterDramcryx extends JungleStegosaurus {

    private int noregenCounter = 0;

    public MasterDramcryx(World worldIn) {
        super(worldIn);
        isImmuneToFire = true;
    }

    public MasterDramcryx(World world, ChunkCoord cityCenter) {
        super(world);
        isImmuneToFire = true;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (noregenCounter > 0) {
            noregenCounter--;
        } else {
            PotionEffect effect = getActivePotionEffect(MobEffects.REGENERATION);
            if (effect == null || effect.getDuration() <= 0) {
                addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 30, 3, false, false));
            }
        }
    }

    public void setNoregenCounter(int c) {
        this.noregenCounter = c;
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        boolean rc = super.isEntityInvulnerable(source);
        if (rc) {
            return rc;
        }
        if (source.isFireDamage()) {
            return true;
        }
        if (source.isMagicDamage()) {
            return true;
        }
        return false;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        noregenCounter = compound.getInteger("noregen");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("noregen", noregenCounter);
    }

    @Override
    protected boolean isMaster() {
        return true;
    }
}