package net.divinerpg.blocks.vethea;

import java.util.Iterator;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BlockNightmareBed extends BlockBed {
	
	public BlockNightmareBed() {
		super();
        String name = "nightmareBedBlock";
        setStepSound(Block.soundTypeStone);
        setCreativeTab(null);
        setBlockName(name);
        setHardness(9);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
	}
}
