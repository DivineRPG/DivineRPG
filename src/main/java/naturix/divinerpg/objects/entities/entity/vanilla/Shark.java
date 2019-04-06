package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGSwimming;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Shark extends EntityDivineRPGSwimming {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/shark");

    public Shark(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 0.6f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SHARK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SHARK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SHARK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
