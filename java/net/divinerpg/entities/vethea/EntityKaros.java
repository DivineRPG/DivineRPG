package net.divinerpg.entities.vethea;

import java.util.ArrayList;
import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityKaros extends EntityDivineRPGBoss {
	
    private int       ability;
    private final int DEFAULT = 0, CEILING = 1, CANNONS = 2, FLOOR = 3;

    private int                    abilityCooldown;
    private int[][]                cannonList = new int[36][3];
    private List<ChunkCoordinates> ceiling    = new ArrayList<ChunkCoordinates>();
    private List<ChunkCoordinates> cannons    = new ArrayList<ChunkCoordinates>();

    private int deathTicks;

    private boolean hasLoadedBlocks = false;

    public EntityKaros(World par1) {
        super(par1);
        addAttackingAI();
        ability = DEFAULT;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.karosHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.karosDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.karosSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.karosFollowRange);
    }

    @Override
    protected void updateAITasks() {
        this.manageAbilities();
        super.updateAITasks();
    }

    public void manageAbilities() {
        if (this.abilityCooldown == 0) {
            this.abilityCooldown = 200;
            switch (this.rand.nextInt(3)) {
                case 0:
                    ability = CEILING;
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
                    this.playSound(Sounds.ceilingExplosions.getPrefixedName(), 1.0F, 1.0F);
                    if (!this.worldObj.isRemote) {
                        List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(30, 30, 30));
                        for (EntityPlayer p : players) {
                            p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.karos.explosion")));
                        }
                    }
                    break;
                case 1:
                    ability = CANNONS;
                    break;
                case 2:
                    ability = FLOOR;
                    break;
                default:
                    break;
            }
        } else if (this.abilityCooldown > 0) {
            this.abilityCooldown--;
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if (source.isExplosion()) return false;
        return super.attackEntityFrom(source, par2);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!hasLoadedBlocks) {
            if (!this.worldObj.isRemote) {
                List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(30, 30, 30));
                for (EntityPlayer p : players) {
                    this.worldObj.playSoundAtEntity(p, Sounds.karosIntro.getPrefixedName(), 1.0F, 1.0F);
                    p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.karos.game")));
                    p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.karos.begin")));
                }
            }
            for (int x = -40; x < 40; x++) {
                for (int y = -5; y < 20; y++) {
                    for (int z = -40; z < 40; z++) {
                        if (this.worldObj.getBlock(x + (int) this.posX, y + (int) this.posY, z + (int) this.posZ) == VetheaBlocks.helioticBeam) {
                            ChunkCoordinates c = new ChunkCoordinates();
                            c.posX = x + (int) this.posX;
                            c.posY = y + (int) this.posY;
                            c.posZ = z + (int) this.posZ;
                            ceiling.add(c);
                        } else if (this.worldObj.getBlock(x + (int) this.posX, y + (int) this.posY, z + (int) this.posZ) == VetheaBlocks.karosCannon) {
                            ChunkCoordinates c = new ChunkCoordinates();
                            c.posX = x + (int) this.posX;
                            c.posY = y + (int) this.posY;
                            c.posZ = z + (int) this.posZ;
                            cannons.add(c);
                        }
                    }
                }
            }
            hasLoadedBlocks = true;
        }

        int var2;
        if (ability == CEILING && this.ceiling.size() != 0) {
            var2 = this.rand.nextInt(46);
            if ((this.abilityCooldown % 8) == 0) {
                ChunkCoordinates c = ceiling.get(this.rand.nextInt(ceiling.size()));
                VetheaBlocks.helioticBeam.dispense(this.worldObj, c.posX, c.posY, c.posZ);
            }
        } else if (ability == CANNONS && this.cannons.size() != 0) {
            var2 = this.rand.nextInt(36);
            if ((this.abilityCooldown % 4) == 0) {
                ChunkCoordinates c = cannons.get(this.rand.nextInt(cannons.size()));
                VetheaBlocks.karosCannon.dispense(this.worldObj, c.posX, c.posY, c.posZ);
            }
        } else if (ability == FLOOR) {
            for (int i = 0; i < 3; i++) {
                double var4 = 0;
                while (var4 < 2 * Math.PI) {
                    int var1 = (int) Math.round(Math.sin(var4) * i);
                    int var3 = (int) Math.round(Math.cos(var4) * i);
                    if (this.worldObj.getBlock((int) this.posX + var1, (int) this.posY - 1, (int) this.posZ + var3) == VetheaBlocks.karosHeatTileGreen) {
                        this.worldObj.setBlock((int) this.posX + var1, (int) this.posY - 1, (int) this.posZ + var3, VetheaBlocks.karosHeatTileRed);
                    }
                    var4 += Math.PI / 8.0D;
                }
            }
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        int s = this.rand.nextInt(4);
        List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(30, 30, 30));
        for (EntityPlayer p : players) {
            switch (s) {
                case 0:
                    if (!this.worldObj.isRemote)
                        p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.karos.laugh")));
                    break;
                case 1:
                    if (!this.worldObj.isRemote)
                        p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.karos.doom")));
                    break;
                case 2:
                    if (!this.worldObj.isRemote)
                        p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.karos.cmon")));
                    break;
                default:
                    if (!this.worldObj.isRemote)
                        p.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.karos.weak")));
                    break;
            }

        }

        switch (s) {
            case 0:
                return Sounds.karosLaugh.getPrefixedName();
            case 1:
                return Sounds.meetDoom.getPrefixedName();
            case 2:
                return Sounds.tryYourBest.getPrefixedName();
            default:
                return Sounds.youCantKillMe.getPrefixedName();
        }
    }

    @Override
    protected String getHurtSound() {
        return null;
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.rockChunks, this.rand.nextInt(3) + 1);
        this.dropItem(VetheaItems.karosLump, 20);
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

        int var4, var5;

        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                var4 = 1000;

                while (var4 > 0) {
                    var5 = EntityXPOrb.getXPSplit(var4);
                    var4 -= var5;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
                }
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
        return "Dr Karos";
    }

    @Override
    public String name() {
        return "Dr Karos";
    }

    @Override
    public IChatComponent chat() {
        return null;
    }
}
