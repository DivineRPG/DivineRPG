package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoPurple extends Ayeraco {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ayeraco_purple");
    private Ayeraco aGreen;
    private Ayeraco aBlue;
    private Ayeraco aRed;
    private Ayeraco aYellow;
    private String greenUUID;
    private String blueUUID;
    private String redUUID;
    private String yellowUUID;

    public AyeracoPurple(World worldIn) {
        super(worldIn);
    }

    public void initOthers(Ayeraco aGreen, Ayeraco aBlue, Ayeraco aRed, Ayeraco aYellow) {
        this.aGreen = aGreen;
        this.aBlue = aBlue;
        this.aRed = aRed;
        this.aYellow = aYellow;
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
        return true;
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
            if (aYellow == null && yellowUUID != null) {
                aYellow = (Ayeraco) findEntityByUUID(yellowUUID);
                yellowUUID = null;
            }
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        greenUUID = tag.getString("greenUUID");
        blueUUID = tag.getString("blueUUID");
        redUUID = tag.getString("redUUID");
        yellowUUID = tag.getString("yellowUUID");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setString("greenUUID", aGreen.getPersistentID().toString());
        tag.setString("blueUUID", aBlue.getPersistentID().toString());
        tag.setString("redUUID", aRed.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
    }

    @Override
    public Color getBarColor() {
        return Color.PURPLE;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
