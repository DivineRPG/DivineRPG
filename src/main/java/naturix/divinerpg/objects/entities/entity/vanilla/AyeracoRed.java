package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoRed extends Ayeraco {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ayeraco_red");
    private Ayeraco aGreen;
    private Ayeraco aBlue;
    private Ayeraco aYellow;
    private Ayeraco aPurple;
    private String greenUUID;
    private String blueUUID;
    private String yellowUUID;
    private String purpleUUID;
    private int healTick;

    public AyeracoRed(World worldIn) {
        super(worldIn);
        this.healTick = 0;
    }

    public void initOthers(Ayeraco aGreen, Ayeraco aBlue, Ayeraco aYellow, Ayeraco aPurple) {
        this.aGreen = aGreen;
        this.aBlue = aBlue;
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
        if (this.healTick == 0) {
            if (this.aGreen != null && !this.aGreen.isDead) {
                aGreen.heal(1);
            }
            if (this.aBlue != null && !this.aBlue.isDead) {
                aBlue.heal(1);
            }
            if (this.aYellow != null && !this.aYellow.isDead) {
                aYellow.heal(1);
            }
            if (this.aPurple != null && !this.aPurple.isDead) {
                aPurple.heal(1);
            }
        } else {
            healTick--;
        }
    }

    @Override
    protected boolean canTeleport() {
        if (this.aPurple != null && this.aPurple.abilityActive()) {
            return true;
        }
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
            if (aBlue == null && blueUUID != null) {
                aBlue = (Ayeraco) findEntityByUUID(blueUUID);
                blueUUID = null;
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
        blueUUID = tag.getString("blueUUID");
        yellowUUID = tag.getString("yellowUUID");
        purpleUUID = tag.getString("purpleUUID");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setString("greenUUID", aGreen.getPersistentID().toString());
        tag.setString("blueUUID", aBlue.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
        tag.setString("purpleUUID", aPurple.getPersistentID().toString());
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
