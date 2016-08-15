package net.divinerpg.entities.vethea;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.entities.vethea.projectile.EntityRaglokBomb;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRaglok extends EntityDivineRPGBoss {

    private int       ability;
    private final int DEFAULT = 0, LIGHTNING = 1, BLIND = 2, BOMBS = 3, SLOW = 4;

    private double prevPlayerX, prevPlayerY, prevPlayerZ;

    private int     abilityCooldown;
    private boolean loaded = false;
    private int     rangedAttackCounter;
    private int     deathTicks;

    public EntityRaglok(World par1) {
        super(par1);
        addAttackingAI();
        this.isImmuneToFire = true;
        ability = DEFAULT;
        this.setSize(1.5F, 4.0F);
    }

    @Override
    protected void updateAITasks() {
        this.manageAbilities();
        super.updateAITasks();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.raglokHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.raglokDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.raglokSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.raglokFollowRange);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!loaded && !this.worldObj.isRemote) {
            List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(30, 30, 30));
            for (EntityPlayer p : players) {
                p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.dare")));
                this.worldObj.playSoundAtEntity(p, Sounds.raglokAwaken.getPrefixedName(), 1.0F, 1.0F);
            }
            loaded = true;
        }
    }

    public void manageAbilities() {
        EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
        if (abilityCooldown == 0 || ability == DEFAULT) {
            abilityCooldown = 400;
            switch (this.rand.nextInt(4)) {
                case 0:
                    ability = LIGHTNING;
                    this.rangedAttackCounter = 0;
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
                    break;
                case 1:
                    ability = BLIND;
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3);
                    break;
                case 2:
                    ability = BOMBS;
                    this.rangedAttackCounter = 0;
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3);
                    break;
                case 3:
                    ability = SLOW;
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3);
                    break;
                default:
                    break;
            }
            this.message();
        } else if (abilityCooldown > 0) {
            abilityCooldown--;
        }

        if (ability == BLIND) {
            if (player != null) {
                player.addPotionEffect(new PotionEffect(Potion.blindness.id, 25, 0, true));
            }
        }
        if (ability == SLOW) {
            if (player != null) {
                player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 1, true));
            }
        }
        if (ability == LIGHTNING) {
            if (abilityCooldown % 40 == 0 && player != null) {
                this.worldObj.spawnEntityInWorld(new EntityLightningBolt(this.worldObj, prevPlayerX, prevPlayerY, prevPlayerZ));
                this.rangedAttackCounter++;
            } else if (abilityCooldown % 40 != 0 && abilityCooldown % 20 == 0 && player != null) {
                this.prevPlayerX = player.posX;
                this.prevPlayerY = player.posY;
                this.prevPlayerZ = player.posZ;
            }
            if (this.rangedAttackCounter == 10) {
                ability = DEFAULT;
            }
        }
        if (ability == BOMBS) {
            if (abilityCooldown % 30 == 0 && player != null) {

                for (int i = 0; i < 4; i++) {
                    EntityRaglokBomb var2 = new EntityRaglokBomb(this.worldObj);
                    var2.setPosition(player.posX, player.posY + 5, player.posZ);
                    var2.motionX = (rand.nextDouble() - rand.nextDouble()) / 5;
                    var2.motionY = -0.14;
                    var2.motionZ = (rand.nextDouble() - rand.nextDouble()) / 5;
                    this.worldObj.spawnEntityInWorld(var2);
                    ++this.rangedAttackCounter;
                }
            }
            if (this.rangedAttackCounter == 12) {
                ability = DEFAULT;
            }
        }
    }

    private void message() {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) list.get(var1);
                switch (ability) {
                    case LIGHTNING:
                        this.playSound(Sounds.raglokGuardian.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote) {
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.think")));
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.great")));
                        }
                        break;
                    case BLIND:
                        this.playSound(Sounds.raglokDark.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.future")));
                        break;
                    case BOMBS:
                        this.playSound(Sounds.raglokRain.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote) {
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.rain")));
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.kill")));
                        }
                        break;
                    case SLOW:
                        this.playSound(Sounds.raglokNothing.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            player.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.compare")));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Integer(100));
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getDeathSound() {
        if (!this.worldObj.isRemote) {
            List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(30, 30, 30));
            for (EntityPlayer p : players) {
                p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.raglok.avenge")));
            }
        }
        EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
        if (player != null) {
            for (int i = 0; i < 10; i++) {
                this.worldObj.spawnEntityInWorld(new EntityLightningBolt(this.worldObj, player.posX, player.posY, player.posZ));
            }
        }
        return Sounds.raglokAvenge.getPrefixedName();
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        int var2 = (int) EntityStats.raglokDamage;

        int var3 = 0;

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
        if (var4) {
            if (ability == SLOW) var3 = 5;

            if (var3 > 0) {
                par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * var3 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * var3 * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }
            int var5 = EnchantmentHelper.getFireAspectModifier(this);
            if (var5 > 0)
                par1Entity.setFire(var5 * 4);
        }
        return var4;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(source.isExplosion()) return false;
        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.heliosisLump, 25);
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
                if (this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D) != null) this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D).attackEntityFrom(DamageSource.magic, 16);
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

    @Override
    public String mobName() {
        return "Raglok";
    }

    @Override
    public String name() {
        return "Raglok";
    }

    @Override
    public IChatComponent chat() {
        return null;
    }
}
