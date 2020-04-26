package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityEnt extends VetheaMob {

    public EntityEnt(World worldIn) {
        super(worldIn);
        this.setSize(2F, 4.4f);
        this.addAttackingAI();
    }


    @Override
    public int getSpawnLayer() {
        return 0;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_ENT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENT_HURT;
    }
}