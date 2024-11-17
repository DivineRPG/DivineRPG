package net.divinerpg.entities.vethea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityLadyLuna extends EntityDivineRPGBoss {
    //1 == arcanic, 2 == ranged, 3 == melee
    private int deathTicks;
    private List<ChunkCoordinates> acidPositions = new ArrayList<ChunkCoordinates>();

    public EntityLadyLuna(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(1.25F, 3.9F);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(19, 500);
        this.dataWatcher.addObject(20, 1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.ladyLunaHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.ladyLunaDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.ladyLunaSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.ladyLunaFollowRange);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.worldObj.isRemote && this.ticksExisted % 5 == 0) {
            for (int x = (int) this.posX - 2; x < (int) this.posX + 2; x++) {
                for (int y = (int) this.boundingBox.minY; y < (int) this.boundingBox.minY + 4; y++) {
                    for (int z = (int) this.posZ - 2; z < (int) this.posZ + 2; z++) {
                        if (this.worldObj.getBlock(x, y, z).getMaterial() == Material.leaves || this.worldObj.getBlock(x, y, z).getMaterial() == Material.wood) this.worldObj.setBlockToAir(x, y, z);
                    }
                }
            }
        }

        if (!this.worldObj.isRemote && this.worldObj.getBlock((int) Math.round(this.posX) - 1, MathHelper.floor_double(this.posY) - 1, (int) Math.round(this.posZ) - 1).isOpaqueCube() && this.worldObj.getBlock((int) Math.round(this.posX) - 1, MathHelper.floor_double(this.posY), (int) Math.round(this.posZ) - 1) == Blocks.air) {
            this.worldObj.setBlock((int) Math.round(this.posX) - 1, MathHelper.floor_double(this.posY), (int) Math.round(this.posZ) - 1, VetheaBlocks.lunicAcid);
            if(!this.acidPositions.contains(Util.newChunkCoordinates((int) Math.round(this.posX) - 1, MathHelper.floor_double(this.posY), (int) Math.round(this.posZ) - 1)))this.acidPositions.add(Util.newChunkCoordinates((int) Math.round(this.posX) - 1, MathHelper.floor_double(this.posY), (int) Math.round(this.posZ) - 1));
        }
        
        if(!this.worldObj.isRemote && this.getProtectionType() == 1 && this.ticksExisted%30 == 0) {
            Iterator<ChunkCoordinates> iter = this.acidPositions.iterator();
            while(iter.hasNext()) {
                ChunkCoordinates c = iter.next();
                if(this.worldObj.getBlock(c.posX, c.posY, c.posZ) != VetheaBlocks.lunicAcid) iter.remove();
                else if(this.rand.nextInt(4) == 0) {
                    EntityLadyLunaSparkler e = new EntityLadyLunaSparkler(this.worldObj, this);
                    e.setPosition(c.posX+0.5, c.posY, c.posZ+0.5);
                    this.worldObj.spawnEntityInWorld(e);
                }
            }
        }

        if (this.getProtectionTimer() == 0) {
            this.setProtectionType(this.rand.nextInt(3) + 1);
            setProtectionTimer(200 + this.rand.nextInt(200));
        } else if (this.getProtectionTimer() > 0) {
            this.setProtectionTimer(getProtectionTimer() - 1);
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        switch (this.rand.nextInt(3)) {
            case 0:
                return Sounds.ladyLuna1.getPrefixedName();
            case 1:
                return Sounds.ladyLuna2.getPrefixedName();
            case 2:
                return Sounds.ladyLuna3.getPrefixedName();
            default:
                return null;
        }
    }

    @Override
    protected String getHurtSound() {
        return Sounds.ladyLunaHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    public int getProtectionType() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public int getProtectionTimer() {
        return this.dataWatcher.getWatchableObjectInt(19);
    }

    public void setProtectionType(int i) {
        if(i==1) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
        else this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.ladyLunaSpeed);
        this.dataWatcher.updateObject(20, i);
    }

    public void setProtectionTimer(int i) {
        this.dataWatcher.updateObject(19, i);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if (source.isExplosion()) return false;
        if (source.isMagicDamage() && this.getProtectionType() == 1)
            return false;
        else if ((source.isProjectile() || source.damageType.equals("thrown")) && this.getProtectionType() == 2)
            return false;
        else if (!source.isProjectile() && !source.isMagicDamage() && this.getProtectionType() == 3)
            return false;
        return super.attackEntityFrom(source, par2);
    }

    @Override
    public boolean attackEntityAsMob(Entity e) {
        int dam = (int) EntityStats.ladyLunaDamage;

        boolean var4 = e.attackEntityFrom(DamageSource.causeMobDamage(this), dam);
        if (var4) {
            this.worldObj.createExplosion(this, e.posX, e.posY, e.posZ, 2, false);
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
            int var5 = EnchantmentHelper.getFireAspectModifier(this);
            if (var5 > 0)
                e.setFire(var5 * 4);
        }
        return var4;
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        switch (this.rand.nextInt(6)) {
            case 0:
                this.dropItem(VetheaItems.everbright, 1);
                break;
            case 1:
                this.dropItem(VetheaItems.everfright, 1);
                this.dropItem(VetheaItems.everArrow, 128);
                break;
            case 2:
                this.dropItem(VetheaItems.evernight, 1);
                break;
            case 3:
                this.dropItem(VetheaItems.everlight, 1);
                break;
            case 4:
                this.dropItem(VetheaItems.evernight, 1);
                break;
            case 5:
                this.dropItem(VetheaItems.eversight, 1);
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
        return "Lady Luna";
    }

    @Override
    public String name() {
        return "Lady Luna";
    }

    @Override
    public IChatComponent chat() {
        return null;
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("Immunity", this.getProtectionType());
        tag.setInteger("ImmunityCooldown", this.getProtectionTimer());
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.setProtectionType(tag.getInteger("Immunity"));
        this.setProtectionTimer(tag.getInteger("ImmunityCooldown"));
    }
}
