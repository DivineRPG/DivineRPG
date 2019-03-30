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

public class AyeracoBlue extends Ayeraco {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ayeraco_blue");
    private Ayeraco aGreen;
    private Ayeraco aRed;
    private Ayeraco aYellow;
    private Ayeraco aPurple;
    private String greenUUID;
    private String redUUID;
    private String yellowUUID;
    private String purpleUUID;

    public AyeracoBlue(World worldIn) {
        super(worldIn);
    }

    public void initOthers(Ayeraco aGreen, Ayeraco aRed, Ayeraco aYellow, Ayeraco aPurple) {
        this.aGreen = aGreen;
        this.aRed = aRed;
        this.aYellow = aYellow;
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
    protected void tickAbility() {
        this.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 2));
        if (this.aGreen != null && !this.aGreen.isDead) {
            aGreen.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 2));
        }
        if (this.aYellow != null && !this.aYellow.isDead) {
            aYellow.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 2));
        }
        if (this.aRed != null && !this.aRed.isDead) {
            aRed.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 2));
        }
        if (this.aPurple != null && !this.aPurple.isDead) {
            aPurple.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 2));
        }
    }

    @Override
    protected boolean canTeleport() {
        if (this.aPurple != null && this.aPurple.abilityActive())
            return true;
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            if (aGreen == null && greenUUID != null) {
                aGreen = (Ayeraco) findEntityByUUID(greenUUID);
                greenUUID = null;
            }
            if (aRed == null && redUUID != null) {
                aRed = (Ayeraco) findEntityByUUID(redUUID);
                redUUID = null;
            }
            if (aYellow == null && yellowUUID != null) {
                aYellow = (Ayeraco) findEntityByUUID(yellowUUID);
                yellowUUID = null;
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
        redUUID = tag.getString("redUUID");
        yellowUUID = tag.getString("yellowUUID");
        purpleUUID = tag.getString("purpleUUID");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setString("greenUUID", aGreen.getPersistentID().toString());
        tag.setString("redUUID", aRed.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
        tag.setString("purpleUUID", aPurple.getPersistentID().toString());
    }

    @Override
    public Color getBarColor() {
        return Color.BLUE;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
