package net.divinerpg.api.items;

import java.util.List;
import java.util.Set;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemShickaxe extends ItemTool {

    private static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(Block.blockRegistry);
    
    protected String name;
    
    public ItemShickaxe(ToolMaterial toolMaterial, String name) {
        super(0, toolMaterial, blocksEffectiveAgainst);
        setCreativeTab(DivineRPGTabs.tools);
        setTextureName(Reference.PREFIX + name);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }

    @Override
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return !(block == Blocks.bedrock);
    }

    @Override
    public boolean func_150897_b(Block block) {
        return isEfficient(block);
    }

    protected boolean isEfficient(Block block) {
        return block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 :
                (block != Blocks.diamond_block && block != Blocks.diamond_ore ?
                        (block != Blocks.emerald_ore && block != Blocks.emerald_block ?
                                (block != Blocks.gold_block && block != Blocks.gold_ore ?
                                        (block != Blocks.iron_block && block != Blocks.iron_ore ?
                                                (block != Blocks.lapis_block && block != Blocks.lapis_ore ?
                                                        (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ?
                                                                (block.getMaterial() == Material.rock ? true :
                                                                        (block.getMaterial() == Material.iron ? true :
                                                                                block.getMaterial() == Material.anvil)) :
                                                                this.toolMaterial.getHarvestLevel() >= 2) :
                                                        this.toolMaterial.getHarvestLevel() >= 1) :
                                                this.toolMaterial.getHarvestLevel() >= 1) :
                                        this.toolMaterial.getHarvestLevel() >= 2) :
                                this.toolMaterial.getHarvestLevel() >= 2) :
                        this.toolMaterial.getHarvestLevel() >= 2);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (!player.canPlayerEdit(x, y, z, par7, stack)) return false;

        UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
        if (MinecraftForge.EVENT_BUS.post(event)) return false;

        if (event.getResult() == Result.ALLOW) {
            stack.damageItem(1, player);
            return true;
        }

        Block block = world.getBlock(x, y, z);

        if (par7 != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt)) {
            Block block1 = Blocks.farmland;
            world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), block1.stepSound.getStepResourcePath(),
                    (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

            if (world.isRemote) return true;

            world.setBlock(x, y, z, block1);
            stack.damageItem(1, player);
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(Util.BLUE + "Efficiency: " + toolMaterial.getEfficiencyOnProperMaterial());
        if (stack.getMaxDamage() != -1) list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses");
        else list.add(Util.GREEN + "Infinite Uses");
        list.add(Util.DARK_AQUA + Reference.MOD_NAME);
    }
}
