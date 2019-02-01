package naturix.divinerpg.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;

public class Rainbour extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/rainbour");

    public Rainbour(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1f);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(18.0D);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.RAINBOUR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.RAINBOUR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.RAINBOUR_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.posY < 40.0D
                && world.loadedEntityList.size() > 20 && world.getWorldType() != WorldType.FLAT	&& world.provider.getDimension() != 1	&& world.provider.getDimension() != -1;
                
                
    }
}
