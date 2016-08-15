package net.divinerpg.entities.vethea;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineArrow;
import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityQuadro extends EntityDivineRPGBoss {

    public int        ability;
    private final int SLOW = 0, FAST = 1, MSLOW = 2, MFAST = 3;

    private int abilityCoolDown;

    private int    rangedAttackCounter;
    public boolean dir;
    private int    deathTicks;

    public EntityQuadro(World w) {
        super(w);
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1, false));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 80));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        ability = SLOW;
        this.setSize(2F, 2F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(22);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.quadroHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.quadroSpeedFast);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.quadroFollowRange);
    }

    @Override
    protected void updateAITasks() {
        if (!this.worldObj.isRemote && this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) this.attackEntityWithRangedAttack((EntityLivingBase) this.entityToAttack, 0);
        if (this.abilityCoolDown == 0) {
            ability = this.rand.nextInt(4);
            this.abilityCoolDown = 500;
            this.rangedAttackCounter = 0;
            this.dir = true;
            int s = this.rand.nextInt(9);
            List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(30, 30, 30));
            for (EntityPlayer p : players) {
                switch (s) {
                    case 0:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroDieBefore.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.die")));
                        break;
                    case 1:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroEnough.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.enough")));
                        break;
                    case 2:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroPunch.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.punch")));
                        break;
                    case 3:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroIsNext.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.next")));
                        break;
                    case 4:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroKillMine.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.mine")));
                        break;
                    case 5:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroMyKill.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.kill")));
                        break;
                    case 6:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroNoDie.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.no")));
                        break;
                    case 7:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroSitDown.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote) {
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.sit")));
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.deserve")));
                        }
                        break;
                    default:
                        this.worldObj.playSoundAtEntity(p, Sounds.quadroTasteFist.getPrefixedName(), 1.0F, 1.0F);
                        if (!this.worldObj.isRemote)
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.quadro.taste")));
                        break;
                }
            }
        }
        if (this.abilityCoolDown == 480) {
            this.abilityCoolDown--;
            this.dir = false;
        }
        if (this.abilityCoolDown > 0) {
            this.abilityCoolDown--;
        }

        if (ability == MSLOW) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(EntityStats.quadroSpeedSlow);
            this.setAIMoveSpeed((float) EntityStats.quadroSpeedSlow);
        } else if (ability == MFAST) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(EntityStats.quadroSpeedFast);
            this.setAIMoveSpeed((float) EntityStats.quadroSpeedFast);
        } else if (ability == SLOW) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
            this.setAIMoveSpeed(0);
        } else if (ability == FAST) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
            this.setAIMoveSpeed(0);
        }
        super.updateAITasks();
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return getLivingSound();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.quadroticLump, 25);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2) {
        switch (ability) {
            case FAST:
                if ((this.rangedAttackCounter % 5) == 0) {
                    EntityDivineArrow var2 = new EntityDivineArrow(this.worldObj, this, par1, 1.6f, 6f, 1, "quadroArrow");
                    this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                    this.worldObj.spawnEntityInWorld(var2);
                }
                this.rangedAttackCounter++;
                break;
            case SLOW:
                if ((this.rangedAttackCounter % 15) == 0) {
                    EntityDivineArrow var4 = new EntityDivineArrow(this.worldObj, this, par1, 1.6f, 6f, 2, "quadroArrow");
                    this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                    this.worldObj.spawnEntityInWorld(var4);
                }
                this.rangedAttackCounter++;
                break;
            default:
                break;
        }
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

    @Override
    public String mobName() {
        return "Quadro";
    }

    @Override
    public String name() {
        return "Quadro";
    }

    @Override
    public IChatComponent chat() {
        return null;
    }
}
