package net.divinerpg.client.render.block;

import net.divinerpg.api.model.DivineModel;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityStatue extends TileEntity {
	
    public ResourceLocation texture;
    public DivineModel model;
    
    public TileEntityStatue() {
        
    }

    public TileEntityStatue(ResourceLocation texture, DivineModel model) {
        this.model = model;
        this.texture = texture;
    }
}