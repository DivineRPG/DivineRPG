package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityBohemite extends VetheaMob {

    public EntityBohemite(World worldIn) {
        super(worldIn);
        this.setSize(1F, 2f);
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_BOHEMITE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BOHEMITE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BOHEMITE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BOHEMITE_HURT;
    }
}