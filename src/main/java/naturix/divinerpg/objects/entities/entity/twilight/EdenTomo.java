package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EdenTomo extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/eden_tomo");

    public EdenTomo(World worldIn) {
        super(worldIn);
        this.setSize(1.1F, 1.0F);
        this.experienceValue = 40;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8);
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