package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Cyclops extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/cyclops");

    public Cyclops(World worldIn) {
        super(worldIn);
        this.setSize(1.5F, 3.9F);
        this.setHealth(this.getMaxHealth());
        this.experienceValue = 40;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    public boolean isValidLightLevel() {
        return world.canSeeSky(getPosition());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.CYCLOPS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.CYCLOPS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.CYCLOPS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.getPosition().getY() > world.getSeaLevel();
    }
}
