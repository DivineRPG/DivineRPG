package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.objects.entities.entity.projectiles.EntityWreckBouncingProjectile;
import divinerpg.objects.entities.entity.projectiles.EntityWreckExplosiveShot;
import divinerpg.objects.entities.entity.projectiles.EntityWreckShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class EntityWreck extends EntityDivineBoss {

    private final int MELEE = 0, ARCANA = 1, RANGED = 2;
    private final int DEFAULT = 0, CHARGE = 1, PULL = 2, FIRE = 3, BOUNCE = 4, FREEZE = 5, SPEED = 6, EXPLOSIONS = 7, STRENGTH = 8;
    private int waitTick;
    private int abilityTimer;
    private boolean dead = false;
    private boolean loaded = false;

    private int ability;
    private int abilityType;

    public EntityWreck(World worldIn) {
        super(worldIn);
        this.setSize(2F, 2.4f);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_WRECK;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);


    }

    public void manageAbilities() {
        EntityPlayer player = this.world.getClosestPlayerToEntity(this, 64.0D);
        if (getHealth() < 1024 / 3) {
            this.setAbilityType(RANGED);
        } else if (getHealth() < 1024 * 2 / 3 && getHealth() > 1024 / 3) {
            this.setAbilityType(ARCANA);
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1);
            this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
        } else {
            this.setAbilityType(MELEE);
        }

        if (abilityTimer > 0) {
            abilityTimer--;
        }

        if ((this.getAbilityType() == 1 && (this.getAbility() == CHARGE || this.getAbility() == PULL)) || (this.getAbilityType() == 2 && (this.getAbility() == FIRE || this.getAbility() == BOUNCE || this.getAbility() == FREEZE)))
            this.setAbility(DEFAULT);

        if (this.getAbility() == DEFAULT && abilityTimer == 0) {
            abilityTimer = 200;
            switch (this.getAbilityType()) {
                case MELEE:
                    switch (this.rand.nextInt(2)) {
                        case 0:
                            this.setAbility(PULL);
                            this.setAIMoveSpeed(0);
                            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
                            break;
                        case 1:
                            this.setAbility(CHARGE);
                            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
                            break;
                        default:
                            break;
                    }
                    break;
                case ARCANA:
                    switch (this.rand.nextInt(3)) {
                        case 0:
                            this.setAbility(FIRE);
                            break;
                        case 1:
                            this.setAbility(BOUNCE);
                            break;
                        case 2:
                            this.setAbility(FREEZE);
                            break;
                        default:
                            break;
                    }
                    break;
                case RANGED:
                    switch (this.rand.nextInt(3)) {
                        case 0:
                            this.setAbility(SPEED);
                            break;
                        case 1:
                            this.setAbility(EXPLOSIONS);
                            break;
                        case 2:
                            this.setAbility(STRENGTH);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

            this.message();
        }

        if (this.getAbility() == CHARGE && this.abilityTimer == 0) {
            this.setAbility(DEFAULT);
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        }

        if (this.getAbility() == FIRE) {
            if (player != null) {
                for (int i = 1; i < 20; ++i) {
                    int var2 = (int) (((this.posX - player.posX)) * i) / 5;
                    int var3 = (int) (((this.posZ - player.posZ)) * i) / 5;
                    if (this.world.getBlockState(new BlockPos((int) this.posX - var2, (int) this.posY, (int) this.posZ - var3)).getBlock() == Blocks.AIR) {
                        this.world.setBlockState(new BlockPos((int) this.posX - var2, (int) this.posY, (int) this.posZ - var3), Blocks.FIRE.getDefaultState());
                    }
                }
                this.setAbility(DEFAULT);
            }
        }
        if (this.getAbility() == FREEZE) {
            if (player != null) {
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 5));
                this.setAbility(DEFAULT);
                abilityTimer = 100;
            }
        }
        if (!this.world.isRemote) this.attackEntityWithRangedAttack(player);
    }

    private void message() {
        List list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) list.get(var1);

                switch (this.getAbility()) {
                    case CHARGE:
                        player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.charge"));
                        break;
                    case PULL:
                        this.playSound(SoundRegistry.FEEL_SOUL_ARKSIANE, 1.0F, 1.0F);
                        if (!this.world.isRemote)
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.pull"));
                        break;
                    case FIRE:
                        player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.fire"));
                        break;
                    case FREEZE:
                        this.playSound(SoundRegistry.STOP_AT_ONCE, 1.0F, 1.0F);
                        if (!this.world.isRemote) {
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.freeze"));
                        }
                        break;
                    case SPEED:
                        this.playSound(SoundRegistry.WRECK_SPEED, 1.0F, 1.0F);
                        if (!this.world.isRemote)
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.speed"));
                        break;
                    case EXPLOSIONS:
                        this.playSound(SoundRegistry.EXPLOSIONS, 1.0F, 1.0F);
                        if (!this.world.isRemote)
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.explosion"));
                        break;
                    case STRENGTH:
                        this.playSound(SoundRegistry.WRECK_STRENGTH, 1.0F, 1.0F);
                        if (!this.world.isRemote)
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.strength"));
                        break;
                    default:
                        break;
                }
            }
        }

    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!world.isRemote && !loaded) {
            List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
            for (EntityPlayer p : players) {
                p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.wreck.run"));
                p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.wreck.smell"));
            }
            this.playSound(SoundRegistry.WRECK_INTRO, 1.0F, 1.0F);
            loaded = true;
        }

        if (dead) {
            return;
        } else {
            EntityPlayer player = this.world.getClosestPlayerToEntity(this, 64.0D);
            if (this.getAbility() == PULL) {
                if (player != null && !player.isCreative()) {
                    player.addVelocity((this.posX - player.posX) * 0.069, (this.posY - player.posY) * 0.069, (this.posZ - player.posZ) * 0.069);
                }
            }
            manageAbilities();
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        if (this.getAbilityType() != MELEE) return false;
        float amount = (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();

        int knockback = 0;

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), amount);

        if (var4) {
            if (this.getAbility() == PULL) {
                this.setAbility(CHARGE);
                this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
                this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
                knockback = 2;
            }
            if (knockback > 0) {
                par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int var5 = EnchantmentHelper.getFireAspectModifier(this);

            if (var5 > 0) {
                par1Entity.setFire(var5 * 4);
            }
        }

        return var4;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase entity) {
        if (entity == null) return;
        double tx = entity.posX - this.posX;
        double ty = entity.getEntityBoundingBox().minY - this.posY;
        double tz = entity.posZ - this.posZ;
        switch (this.getAbility()) {
            case BOUNCE:
                EntityWreckBouncingProjectile projectile = new EntityWreckBouncingProjectile(this.world, this, 35);
                projectile.shoot(tx, ty, tz, 1.6f, 12f);
                this.world.spawnEntity(projectile);
                this.setAbility(DEFAULT);
                break;
            case SPEED:
                if (this.abilityTimer % 5 == 0) {
                    EntityWreckShot shot = new EntityWreckShot(this.world, this, 15);
                    shot.shoot(tx, ty, tz, 1.6f, 12f);
                    this.world.spawnEntity(shot);
                }
                if (this.abilityTimer <= 100) {
                    this.setAbility(DEFAULT);
                }
                break;
            case EXPLOSIONS:
                if ((this.abilityTimer % 40) == 0) {
                    EntityWreckExplosiveShot shot = new EntityWreckExplosiveShot(this.world, this);
                    shot.shoot(tx, ty, tz, 1.6f, 12f);
                    this.world.spawnEntity(shot);
                }
                if (this.abilityTimer == 0) this.setAbility(DEFAULT);
                break;
            case STRENGTH:
                if ((this.abilityTimer % 40) == 0) {
                    EntityWreckShot shot = new EntityWreckShot(this.world, this, 40);
                    shot.shoot(tx, ty, tz, 1.6f, 12f);
                    this.world.spawnEntity(shot);
                }
                if (this.abilityTimer == 0) this.setAbility(DEFAULT);
                break;
            default:
                break;
        }
    }

    public int getAbilityType() {
        return this.abilityType;
    }

    public void setAbilityType(int type) {
        this.abilityType = type;
    }

    public int getAbility() {
        return this.ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }


    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIAttackMelee(this, 1, true));
        this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityPigZombie.class));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Override
    public void onDeathUpdate() {
        if (!this.dead) {
            this.dead = true;
        }
        super.onDeathUpdate();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
}
