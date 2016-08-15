package net.divinerpg.items.base;

import java.util.ArrayList;
import java.util.List;

import net.divinerpg.entities.base.EntityDivineArrow;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModBow extends ItemBow {

	public static List<Item> bowList = new ArrayList<Item>();
    public static final int                DEFAULT_MAX_USE_DURATION = 72000;
    @SideOnly(Side.CLIENT)
    protected IIcon[]                      IIconArray;
    protected String                       name;
    protected String                       textureName;
    protected final String[]               texture;
    protected int                          damageMin;
    protected int						   damageMax;
    protected int                          maxUseDuration;
    protected boolean                      unbreakable;
    protected Item                         arrow;
    protected boolean                      needArrow = true;
    protected String arrowTex;
    private String sound = "random.bow";
    private boolean vethean = false;

    public ItemModBow(String name, int uses, int damageMin, int damageMax, Item arrow) {
        this(name, uses, damageMin, damageMax, DEFAULT_MAX_USE_DURATION, arrow);
    }
    
    public ItemModBow(String name, int uses, int damageMin, int damageMax, String arrowTex) {
        this(name, uses, damageMin, damageMax, DEFAULT_MAX_USE_DURATION, null);
        this.arrowTex = arrowTex;
    }
    
    public ItemModBow(String name, int uses, int damageMin, int damageMax, Item arrow, String arrowTex) {
        this(name, uses, damageMin, damageMax, DEFAULT_MAX_USE_DURATION, arrow);
        this.arrowTex = arrowTex;
    }
    
    public ItemModBow(String name, int uses, int damageMin, int damageMax, int maxUseDuraction) {
        this(name, uses, damageMin, damageMax, maxUseDuraction, null);
    }
    
    public ItemModBow(String name, int uses, int damageMin, int damageMax, int maxUseDuraction, Item arrow, String arrowTex) {
        this(name, uses, damageMin, damageMax, maxUseDuraction, arrow);
        this.arrowTex = arrowTex;
    }

    public ItemModBow(String name, int uses, int damageMin, int damageMax, int maxUseDuraction, Item arrow) {
        setMaxDurability(uses);
        this.name = name;
        this.textureName = Reference.PREFIX + name;
        if (arrow == null) needArrow = false;
        else this.arrow = arrow;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.maxUseDuration = maxUseDuraction;
        unbreakable = true;
        this.maxStackSize = 1;
        this.setCreativeTab(DivineRPGTabs.ranged);
        this.texture = new String[] { textureName + "_0", textureName + "_1", textureName + "_2", textureName + "_3" };
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
        bowList.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon) {
        itemIcon = icon.registerIcon(texture[0]);
        IIconArray = new IIcon[texture.length];
        for(int i = 0; i < texture.length; i++)
            IIconArray[i] = icon.registerIcon(texture[i]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int icon) {
        return IIconArray[icon];
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (player.getItemInUse() == null) return itemIcon;
        int pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (pulling >= 18/(DEFAULT_MAX_USE_DURATION/this.getMaxItemUseDuration(stack))) return IIconArray[3];
        if (pulling > 13/(DEFAULT_MAX_USE_DURATION/this.getMaxItemUseDuration(stack))) return IIconArray[2];
        if (pulling > 0) return IIconArray[1];
        return IIconArray[0];
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemUseCount) {
        int maxItemUse = getMaxItemUseDuration(stack) - itemUseCount;
        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, maxItemUse);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) return;
        maxItemUse = event.charge;
        boolean infiniteAmmo = !needArrow || player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
        if (infiniteAmmo || player.inventory.hasItem(arrow)) {
        	float timeRatio = DEFAULT_MAX_USE_DURATION/this.getMaxItemUseDuration(stack);
            float scaledItemUse = ((float) maxItemUse / 20.0F)*timeRatio;
            scaledItemUse = (scaledItemUse * scaledItemUse + scaledItemUse * 2) / 3;
            if ((double) scaledItemUse < 0.1) return;
            if (scaledItemUse > 1) scaledItemUse = 1;
            EntityDivineArrow entityarrow;
            if(this.arrow != null && this.arrowTex == null) entityarrow = new EntityDivineArrow(world, player, scaledItemUse*2, damageMin, damageMax, arrow.getUnlocalizedName().replace("item.", ""));
            else entityarrow = new EntityDivineArrow(world, player, scaledItemUse*2, damageMin, damageMax, this.arrowTex);
            entityarrow.setAmmoItem(arrow);
            if (scaledItemUse == 1) entityarrow.setIsCritical(true);
            int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
            if (powerLevel > 0) entityarrow.setDamage(entityarrow.getDamage() + (double) powerLevel * 0.5 + 0.5);
            int punchLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
            if (punchLevel > 0) entityarrow.setKnockbackStrength(punchLevel);
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) entityarrow.setFire(100);
            if (!unbreakable) stack.damageItem(1, player);
            world.playSoundAtEntity(player, this.sound, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + scaledItemUse * 0.5F);
            if (infiniteAmmo) entityarrow.canBePickedUp = 2;
            else player.inventory.consumeInventoryItem(arrow);
            if (!world.isRemote) world.spawnEntityInWorld(entityarrow);
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return maxUseDuration;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(TooltipLocalizer.bowDam(damageMin + "-" + damageMax));
        double speed = (double) DEFAULT_MAX_USE_DURATION / (double) getMaxItemUseDuration(stack);
        if (speed > 1) list.add(speed + " Times Faster");
        if (speed < 1) list.add((1 / speed) + " Times Slower");
        list.add(!unbreakable ? TooltipLocalizer.usesRemaining(stack.getMaxDurability() - stack.getMetadata()) : TooltipLocalizer.infiniteUses());
        if(this.arrowTex == "bluefireArrow" || this.arrowTex == "snowstormArrow") list.add(TooltipLocalizer.explosiveShots());
        list.add(this.arrow == null ? TooltipLocalizer.infiniteAmmo() : TooltipLocalizer.ammo(this.arrow));
        if(this.vethean) list.add(TooltipLocalizer.vethean());
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        ArrowNockEvent nockEvent = new ArrowNockEvent(player, stack);
        MinecraftForge.EVENT_BUS.post(nockEvent);
        if (nockEvent.isCanceled()) return nockEvent.result;
        boolean infiniteAmmo = !needArrow || player.capabilities.isCreativeMode || (EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0 && player.inventory.hasItem(arrow));
        if (infiniteAmmo || player.inventory.hasItem(arrow))
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }
    
    public ItemModBow setSound(String newSound) {
    	this.sound = newSound;
    	return this;
    }
    
    public ItemModBow setVethean() {
    	this.setCreativeTab(DivineRPGTabs.vethea);
    	this.vethean = true;
    	return this;
    }
}