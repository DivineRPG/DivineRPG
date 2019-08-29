package divinerpg.objects.entities.entity.arcana;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class DungeonPrisoner extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID,
            "entities/arcana/dungeon_prisoner");

    public DungeonPrisoner(World world) {
        super(world);
        this.setSize(0.6F, 2.15F);
    }

    @Override
    public float getEyeHeight() {
        return 1.8F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(85.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(17.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        DungeonDemon demon = new DungeonDemon(this.world);
        this.playSound(ModSounds.DUNGEON_PRISONER_CHANGE, 1, 1);
        demon.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.world.spawnEntity(demon);
        this.setDead();
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DUNGEON_PRISONER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.DUNGEON_PRISONER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DUNGEON_PRISONER_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}