package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class WildwoodTomo extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID,
            "entities/twilight/wildwood_tomo");

    public WildwoodTomo(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 0.6F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(110);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CROAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}