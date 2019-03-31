package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoGreen extends Ayeraco {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ayeraco_green");
    private Ayeraco aBlue;
    private Ayeraco aRed;
    private Ayeraco aYellow;
    private Ayeraco aPurple;
    private String blueUUID;
    private String redUUID;
    private String yellowUUID;
    private String purpleUUID;

    public AyeracoGreen(World worldIn) {
        super(worldIn);
    }

    public void initOthers(Ayeraco aBlue, Ayeraco aRed, Ayeraco aYellow, Ayeraco aPurple) {
        this.aBlue = aBlue;
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
        return true;
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
            if (aBlue == null && blueUUID != null) {
                aBlue = (Ayeraco) findEntityByUUID(blueUUID);
                blueUUID = null;
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
        blueUUID = tag.getString("blueUUID");
        redUUID = tag.getString("redUUID");
        yellowUUID = tag.getString("yellowUUID");
        purpleUUID = tag.getString("purpleUUID");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setString("blueUUID", aBlue.getPersistentID().toString());
        tag.setString("redUUID", aRed.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
        tag.setString("purpleUUID", aPurple.getPersistentID().toString());
    }

    @Override
    public Color getBarColor() {
        return Color.GREEN;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
