package divinerpg.objects.entities.entity.vanilla;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityEnderSpider extends EntityEnderman {

    public EntityEnderSpider(World worldIn) {
        super(worldIn);
        this.setSize(0.5F, 0.55F);
        this.experienceValue = 20;
    }

    @Override
    public float getEyeHeight() {
        return 0.45F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.HELL_SPIDER;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_ENDER_SPIDER;
    }

    @Override
    public boolean getCanSpawnHere() {
        return (world.provider.getDimension() == 0 || world.provider.getDimension() == 1) && super.getCanSpawnHere();
    }
}
