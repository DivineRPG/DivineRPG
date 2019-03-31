package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoYellow extends Ayeraco {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ayeraco_yellow");
    private Ayeraco aGreen;
    private Ayeraco aBlue;
    private Ayeraco aRed;
    private Ayeraco aPurple;
    private String greenUUID;
    private String blueUUID;
    private String redUUID;
    private String purpleUUID;

    public AyeracoYellow(World worldIn) {
        super(worldIn);
    }

    public void initOthers(Ayeraco aGreen, Ayeraco aBlue, Ayeraco aRed, Ayeraco aPurple) {
        this.aGreen = aGreen;
        this.aBlue = aBlue;
        this.aRed = aRed;
        this.aPurple = aPurple;
    }

    @Override
    public void onDeath(DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        world.setBlockState(beamLocation, Blocks.AIR.getDefaultState());
    }

    @Override
    protected boolean canBlockProjectiles() {
        if (this.aGreen != null && this.aGreen.abilityActive()) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean canTeleport() {
        if (this.aPurple != null && this.aPurple.abilityActive()) {
            return true;
        }
        return false;
    }

    @Override
    protected void tickAbility() {
        this.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1, 1));
        if (this.aGreen != null && !this.aGreen.isDead) {
            aGreen.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1, 1));
        }
        if (this.aBlue != null && !this.aBlue.isDead) {
            aBlue.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1, 1));
        }
        if (this.aRed != null && !this.aRed.isDead) {
            aRed.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1, 1));
        }
        if (this.aPurple != null && !this.aPurple.isDead) {
            aPurple.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1, 1));
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            if (aGreen == null && greenUUID != null) {
                aGreen = (Ayeraco) findEntityByUUID(greenUUID);
                greenUUID = null;
            }
            if (aBlue == null && blueUUID != null) {
                aBlue = (Ayeraco) findEntityByUUID(blueUUID);
                blueUUID = null;
            }
            if (aRed == null && redUUID != null) {
                aRed = (Ayeraco) findEntityByUUID(redUUID);
                redUUID = null;
            }
            if (aPurple == null && purpleUUID != null) {
                aPurple = (Ayeraco) findEntityByUUID(purpleUUID);
                purpleUUID = null;
            }
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        greenUUID = tag.getString("greenUUID");
        blueUUID = tag.getString("blueUUID");
        redUUID = tag.getString("redUUID");
        purpleUUID = tag.getString("purpleUUID");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setString("greenUUID", aGreen.getPersistentID().toString());
        tag.setString("blueUUID", aBlue.getPersistentID().toString());
        tag.setString("redUUID", aRed.getPersistentID().toString());
        tag.setString("purpleUUID", aPurple.getPersistentID().toString());
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
