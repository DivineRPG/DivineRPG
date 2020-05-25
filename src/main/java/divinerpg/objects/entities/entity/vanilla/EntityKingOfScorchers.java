package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.ai.ILaunchThrowable;
import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersMeteor;
import divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityKingOfScorchers extends EntityDivineBoss implements ILaunchThrowable {
    public EntityKingOfScorchers(World worldIn) {
        super(worldIn);
        this.setSize(2.0F, 2.5F);
        this.isImmuneToFire = true;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();

        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));

        // regular shoots
        this.tasks.addTask(7, new AIDivineFireballAttack(
                this,
                this::createFireball,
                15,
                64,
                null,
                SoundEvents.ENTITY_BLAZE_SHOOT));

        this.tasks.addTask(8, new AIDivineFireballAttack(
                this,
                this::createMeteors,
                20 * 60,
                64,
                null,
                SoundEvents.ENTITY_BLAZE_SHOOT));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64);
    }

    @Override
    public float getEyeHeight() {
        return 1F;
    }

    public Entity createMeteors(EntityLivingBase parent, Entity victim) {
        if (!(victim instanceof EntityLivingBase))
            return null;

        List<Entity> meteors = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            EntityKingOfScorchersMeteor meteor = new EntityKingOfScorchersMeteor(world, ((EntityLivingBase) victim));

            Random rand = meteor.world.rand;

            meteor.posX = rand.nextDouble() - rand.nextDouble() * 2;
            meteor.posX += 10;
            meteor.posZ = rand.nextDouble() - rand.nextDouble() * 2;

            meteor.motionX = (rand.nextDouble() - rand.nextDouble()) / 5;
            meteor.motionY = -0.7;
            meteor.motionZ = (rand.nextDouble() - rand.nextDouble()) / 5;

            meteors.add(meteor);
        }

        while (meteors.size() > 1) {
            world.spawnEntity(meteors.get(0));
            meteors.remove(0);
        }


        return meteors.get(0);
    }

    @Override
    public EntityThrowable createThowable(World world, EntityLivingBase parent, double x, double y, double z) {
        return new EntityKingOfScorchersShot(world, parent);
    }

    @Override
    public float getInaccuracy(World world) {
        return 1;
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if (source.isExplosion())
            return false;
        return super.attackEntityFrom(source, par2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.KING_OF_SCORCHERS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KING_OF_SCORCHERS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_KING_OF_SCORCHERS;
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }
    
}
