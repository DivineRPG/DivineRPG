package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGSwimming;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Liopleurodon extends EntityDivineRPGSwimming {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/liopleurodon");

    public Liopleurodon(World worldIn) {
        super(worldIn);
        this.setSize(6F, 1f);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13.0D);
    }

    @Override
    protected float getSoundVolume() {
        return 0.05F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.LIOPLEURODON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.LIOPLEURODON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.LIOPLEURODON_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
