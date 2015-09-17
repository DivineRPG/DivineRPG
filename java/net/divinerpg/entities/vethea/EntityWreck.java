package net.divinerpg.entities.vethea;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.entities.vethea.projectile.EntityWreckBouncingProjectile;
import net.divinerpg.entities.vethea.projectile.EntityWreckExplosiveShot;
import net.divinerpg.entities.vethea.projectile.EntityWreckShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityWreck extends EntityDivineRPGBoss {

    private final int MELEE   = 0, ARCANA = 1, RANGED = 2;
    private final int DEFAULT = 0, CHARGE = 1, PULL = 2, FIRE = 3, BOUNCE = 4, FREEZE = 5, SPEED = 6, EXPLOSIONS = 7, STRENGTH = 8;
    private int       waitTick;
    private int       abilityTimer;
    private int       deathTicks;
    private boolean   loaded  = false;

    public EntityWreck(World par1) {
        super(par1);
        this.setSize(1f, 1.7f);
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1, false));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 80));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.setAbility(DEFAULT);
        this.setAbilityType(MELEE);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.wreckHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.wreckDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.wreckSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.wreckFollowRange);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(17, MELEE);
        this.dataWatcher.addObject(18, DEFAULT);
    }

    @Override
    protected void updateAITasks() {
        this.manageAbilities();
        super.updateAITasks();
    }

    public void manageAbilities() {
        EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
        if (getHealth() < 5000 / 3) {
            this.setAbilityType(RANGED);
        } else if (getHealth() < 5000 * 2 / 3 && getHealth() > 5000 / 3) {
            this.setAbilityType(ARCANA);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1);
            this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
        }

        if (abilityTimer > 0) {
            abilityTimer--;
        }

        if ((this.getAbilityType() == 1 && (this.getAbility() == CHARGE || this.getAbility() == PULL)) || (this.getAbilityType() == 2 && (this.getAbility() == FIRE || this.getAbility() == BOUNCE || this.getAbility() == FREEZE))) this.setAbility(DEFAULT);

        if (this.getAbility() == DEFAULT && abilityTimer == 0) {
            abilityTimer = 200;
            switch (this.getAbilityType()) {
                case MELEE:
                    switch (this.rand.nextInt(2)) {
                        case 0:
                            this.setAbility(PULL);
                            this.setAIMoveSpeed(0);
                            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(EntityStats.wreckSpeed);
                            break;
                        case 1:
                            this.setAbility(CHARGE);
                            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.wreckSpeedFast);
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
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.wreckSpeed);
        }

        if (this.getAbility() == FIRE) {
            if (player != null) {
                for (int i = 1; i < 20; ++i) {
                    int var2 = (int) (((this.posX - player.posX)) * i) / 5;
                    int var3 = (int) (((this.posZ - player.posZ)) * i) / 5;
                    if (this.worldObj.getBlock((int) this.posX - var2, (int) this.posY, (int) this.posZ - var3) == Blocks.air) this.worldObj.setBlock((int) this.posX - var2, (int) this.posY, (int) this.posZ - var3, Blocks.fire);
                }
                this.setAbility(DEFAULT);
            }
        }
        if (this.getAbility() == FREEZE) {
            if (player != null) {
                player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
                this.setAbility(DEFAULT);
                abilityTimer = 100;
            }
        }
        if (!this.worldObj.isRemote) this.attackEntityWithRangedAttack(player);
    }

    private void message() {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) list.get(var1);
                
                switch (this.getAbility()) {
                    case CHARGE:
                        player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.charge")));
                        break;
                    case PULL:
                        this.playSound(Sounds.feelSoulArksiane.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.pull")));
                        break;
                    case FIRE:
                        player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.fire")));
                        break;
                    case FREEZE:
                        this.playSound(Sounds.stopAtOnce.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote) {
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.freeze")));
                        }
                        break;
                    case SPEED:
                        this.playSound(Sounds.wreckSpeed.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.speed")));
                        break;
                    case EXPLOSIONS:
                        this.playSound(Sounds.explosions.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.explosion")));
                        break;
                    case STRENGTH:
                        this.playSound(Sounds.wreckStrength.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.strength")));
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
        if (!worldObj.isRemote && !loaded) {
            List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(30, 30, 30));
            for (EntityPlayer p : players) {
                p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.run")));
                p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.wreck.smell")));
                this.worldObj.playSoundAtEntity(p, Sounds.wreckIntro.getPrefixedName(), 1.0F, 1.0F);
            }
            loaded = true;
        }
        EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
        if (this.getAbility() == PULL) {
            if (player != null) {
                player.addVelocity((this.posX - player.posX) * 0.069, (this.posY - player.posY) * 0.069, (this.posZ - player.posZ) * 0.069);
            }
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        if (this.getAbilityType() != MELEE) return false;
        float amount = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

        int knockback = 0;

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), amount);

        if (var4) {
            if (this.getAbility() == PULL) {
                this.setAbility(CHARGE);
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.wreckSpeedFast);
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
        double ty = entity.boundingBox.minY - this.posY;
        double tz = entity.posZ - this.posZ;
        switch (this.getAbility()) {
            case BOUNCE:
                EntityWreckBouncingProjectile projectile = new EntityWreckBouncingProjectile(this.worldObj, this, 35);
                projectile.setThrowableHeading(tx, ty, tz, 1.6f, 12f);
                this.worldObj.spawnEntityInWorld(projectile);
                this.setAbility(DEFAULT);
                break;
            case SPEED:
                if (this.abilityTimer % 5 == 0) {
                    EntityWreckShot shot = new EntityWreckShot(this.worldObj, this, 15);
                    shot.setThrowableHeading(tx, ty, tz, 1.6f, 12f);
                    this.worldObj.spawnEntityInWorld(shot);
                }
                if (this.abilityTimer <= 100) {
                    this.setAbility(DEFAULT);
                }
                break;
            case EXPLOSIONS:
                if ((this.abilityTimer % 40) == 0) {
                    EntityWreckExplosiveShot shot = new EntityWreckExplosiveShot(this.worldObj, this);
                    shot.setThrowableHeading(tx, ty, tz, 1.6f, 12f);
                    this.worldObj.spawnEntityInWorld(shot);
                }
                if (this.abilityTimer == 0) this.setAbility(DEFAULT);
                break;
            case STRENGTH:
                if ((this.abilityTimer % 40) == 0) {
                    EntityWreckShot shot = new EntityWreckShot(this.worldObj, this, 40);
                    shot.setThrowableHeading(tx, ty, tz, 1.6f, 12f);
                    this.worldObj.spawnEntityInWorld(shot);
                }
                if (this.abilityTimer == 0) this.setAbility(DEFAULT);
                break;
            default:
                break;
        }
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.arksianeLump, 25);
    }

    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;

        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
        }

        int var4;
        int var5;

        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                var4 = 1000;

                while (var4 > 0) {
                    var5 = EntityXPOrb.getXPSplit(var4);
                    var4 -= var5;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
                }
            }

            if (this.deathTicks == 1) {
                this.worldObj.playBroadcastSound(1018, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
            }
        }

        this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
        this.renderYawOffset = this.rotationYaw += 20.0F;

        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            var4 = 2000;

            while (var4 > 0) {
                var5 = EntityXPOrb.getXPSplit(var4);
                var4 -= var5;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
            }
            this.setDead();
        }
    }

    public int getAbilityType() {
        return this.dataWatcher.getWatchableObjectInt(17);
    }

    public void setAbilityType(int type) {
        this.dataWatcher.updateObject(17, type);
    }

    public int getAbility() {
        return this.dataWatcher.getWatchableObjectInt(18);
    }

    public void setAbility(int ability) {
        this.dataWatcher.updateObject(18, ability);
    }

    @Override
    public String mobName() {
        return "Wreck";
    }

    @Override
    public String name() {
        return "Wreck";
    }

    @Override
    public IChatComponent chat() {
        return null;
    }
}
