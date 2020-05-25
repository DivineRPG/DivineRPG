package divinerpg.objects.entities.entity;

import divinerpg.objects.entities.entity.iceika.EntityWorkshopMerchant;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopTinkerer;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class EntityDivineVillager extends EntityVillager {
    private UUID lastBuyingPlayer;
    private EntityPlayer buyingPlayer;
    private MerchantRecipeList buyingList;
    private final String[] messages;

    protected EntityDivineVillager(World world) {
        this(world, new String[0]);
    }

    protected EntityDivineVillager(World w, String... messages) {
        super(w);
        this.setSize(1.0F, 2.0F);
        this.setCanPickUpLoot(false);
        this.addDefaultEquipmentAndRecipies(75);
        this.messages = messages;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityEvoker.class, 12.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVindicator.class, 8.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVex.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAITradePlayer(this));
        this.tasks.addTask(2, new EntityAILookAtTradePlayer(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.27D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.27D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);

    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    protected boolean canDropLoot() {
        return false;
    }

    @Override
    protected void updateAITasks() {
    }

    @Override
    public void setProfession(int professionId) {
        super.setProfession(5);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = itemstack.getItem() == Items.NAME_TAG;

        if (flag) {
            itemstack.interactWithEntity(player, this, hand);
            return true;
        } else if (!this.holdingSpawnEggOfClass(itemstack, this.getClass()) && this.isEntityAlive() && !this.isTrading()
                && !this.isChild() && !player.isSneaking()) {
            if (!this.world.isRemote) {
                extraInteract(player);
                this.setCustomer(player);
            }
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    public final void extraInteract(EntityPlayer player) {
        ITextComponent message = new TextComponentString("");
        ITextComponent npcName = LocalizeUtils.getClientSideTranslation(player, String.format("entity.%s.name", EntityList.getEntityString(this)));
        npcName.getStyle().setColor(TextFormatting.AQUA);
        message.appendSibling(npcName);
        message.appendText(": ");
        message.appendSibling(LocalizeUtils.getClientSideTranslation(player, messages[rand.nextInt(messages.length)]));
        player.sendMessage(message);
    }

    public abstract void addRecipies(MerchantRecipeList list);

    @Override
    public EntityVillager createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        if (this.buyingList != null) {
            var1.setTag("Trades", this.buyingList.getRecipiesAsTags());
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        if (var1.hasKey("Trades")) {
            NBTTagCompound var2 = var1.getCompoundTag("Trades");
            if (this instanceof EntityWorkshopTinkerer || this instanceof EntityWorkshopMerchant)
                this.buyingList = new InfiniteTradeList(var2);
            else
                this.buyingList = new MerchantRecipeList(var2);
        }
    }

    @Override
    public void useRecipe(MerchantRecipe recipe) {
        recipe.incrementToolUses();

        if (recipe.getToolUses() == 1) {
            if (this.buyingPlayer != null) {
                this.lastBuyingPlayer = this.buyingPlayer.getUniqueID();
            } else {
                this.lastBuyingPlayer = null;
            }
        }
    }

    @Override
    public void verifySellingItem(ItemStack stack) {
    }

    @Override
    public MerchantRecipeList getRecipes(EntityPlayer player) {
        if (this.buyingList == null) {
            this.addDefaultEquipmentAndRecipies(75);
        }
        return this.buyingList;
    }

    private void addDefaultEquipmentAndRecipies(int par1) {
        MerchantRecipeList rec = new MerchantRecipeList();

        addRecipies(rec);

        if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }

        for (int var3 = 0; var3 < par1 && var3 < rec.size(); ++var3) {
            this.buyingList.add(rec.get(var3));
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }
}
