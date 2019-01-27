package naturix.divinerpg.entities.entity;

import java.util.Iterator;
import java.util.UUID;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.iceika.WorkshopMerchant;
import naturix.divinerpg.entities.entity.iceika.WorkshopTinkerer;
import naturix.divinerpg.entities.entity.vethia.TheHunger;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public abstract class EntityDivineRPGVillager extends EntityVillager {

    private int                randomTickDivider;
    private Village            villageObj;
    private UUID               lastBuyingPlayer;
    private EntityPlayer       buyingPlayer;
    private MerchantRecipeList buyingList;
    private int                timeUntilReset;
    private boolean            needsInitilization;
    private int                wealth;
    private float              buying;

    public EntityDivineRPGVillager(World var1) {
        super(var1);
        this.setSize(1.0F, 2.0F);
        this.randomTickDivider = 0;
        this.villageObj = null;
        //this.getNavigator().setBreakDoors(true);
        this.setPathPriority(PathNodeType.WATER, 0.0F);
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.3F, 0.35F));
        this.tasks.addTask(1, new EntityAITradePlayer(this));
        this.tasks.addTask(1, new EntityAILookAtTradePlayer(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(5, new EntityAIWander(this, 0.27D));
        setProfession(1234);
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public void setProfession(int i) {
        super.setProfession(12345);
    }

    @Override
    protected void updateAITasks() {
        if (this.randomTickDivider-- <= 0) {
            BlockPos blockpos = new BlockPos(this);
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.world.getVillageCollection().getNearestVillage(blockpos, 32);

            if (this.villageObj == null) {
                this.detachHome();
            } else {
                this.villageObj.setDefaultPlayerReputation(30);
            }
        }

        if (this.timeUntilReset > 0) {
            if (this.timeUntilReset <= 0) {
                if (this.buyingList.size() > 1) {
                    Iterator iterator = this.buyingList.iterator();
                    if (needsInitilization) {
                        while (iterator.hasNext()) {
                            MerchantRecipe merchantrecipe = (MerchantRecipe) iterator.next();

                            if (merchantrecipe.isRecipeDisabled()) {
                            	merchantrecipe.increaseMaxTradeUses(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                            }
                        }
                    }

                    this.addDefaultEquipmentAndRecipies(75);
                    this.needsInitilization = false;

                    if (this.villageObj != null && this.lastBuyingPlayer != null) {
                        this.villageObj.modifyPlayerReputation(this.lastBuyingPlayer, 30);
                    }
                }
                this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0));
            }
        }
        super.updateAITasks();
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            extraInteract(player);
            player.openGui(DivineRPG.instance, guiID(), this.world, getEntityId(), 0, 0);
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    public abstract void extraInteract(EntityPlayer p);

    public abstract int guiID();

    public abstract void addRecipies(MerchantRecipeList list);

    @Override
    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setInteger("Profession", 1234);
        var1.setInteger("Riches", this.wealth);

        if (this.buyingList != null) {
            var1.setTag("Offers", this.buyingList.getRecipiesAsTags());
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.setProfession(1234);
        this.wealth = var1.getInteger("Riches");

        if (var1.hasKey("Offers")) {
            NBTTagCompound var2 = var1.getCompoundTag("Offers");
            if (this instanceof TheHunger || this instanceof WorkshopTinkerer || this instanceof WorkshopMerchant) this.buyingList = new InfiniteTradeList(var2);
            else this.buyingList = new MerchantRecipeList(var2);
        }
    }

    @Override
    public void useRecipe(MerchantRecipe recipe) {
    	recipe.incrementToolUses();

        if (recipe.getToolUses() == 1) {
            this.timeUntilReset = 40;
            this.needsInitilization = true;

            if (this.buyingPlayer != null) {
                this.lastBuyingPlayer = this.buyingPlayer.getUniqueID();
            } else {
                this.lastBuyingPlayer = null;
            }
        }

        if (recipe.getItemToBuy().getItem() == Items.EMERALD) {
            this.wealth += recipe.getItemToBuy().getCount();
        }
    }

    public void func_110297_a_(ItemStack par1ItemStack) {}

    @Override
    public MerchantRecipeList getRecipes(EntityPlayer player) {
        if (this.buyingList == null) {
            this.addDefaultEquipmentAndRecipies(75);
        }
        return this.buyingList;
    }

    //@Override
    //public void verifySellingItem(ItemStack stack) {}

    private void addDefaultEquipmentAndRecipies(int par1) {
        if (this.buyingList != null) {
            this.buying = MathHelper.sqrt((float)this.buyingList.size()) * 0.2F;
        } else {
            this.buying = 0.0F;
        }

        MerchantRecipeList rec = new MerchantRecipeList();

        addRecipies(rec);

        if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }

        for (int var3 = 0; var3 < par1 && var3 < rec.size(); ++var3) {
            this.buyingList.add((MerchantRecipe) rec.get(var3));
        }
    }
}
