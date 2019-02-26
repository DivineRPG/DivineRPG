package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EnderSpider extends EntityEnderman {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/ender_spider");

    public EnderSpider(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 0.9F);
        this.setHealth(this.getMaxHealth());
        this.experienceValue = 20;
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
        return DRPGSoundHandler.HELL_SPIDER;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && world.provider.getDimension() == 1;
    }
}
