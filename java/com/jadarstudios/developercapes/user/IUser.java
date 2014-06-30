/**
 * DeveloperCapes by Jadar
 * License: MIT License
 * (https://raw.github.com/jadar/DeveloperCapes/master/LICENSE)
 * version 3.3.0.0
 */
package com.jadarstudios.developercapes.user;

import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;

/**
 * This is the interface that you must implement to create your own user type
 * 
 * @author Jadar
 */
public interface IUser
{
    /**
     * @return The {@link ResourceLocation} that contains the cape file
     */
    public ResourceLocation getResource();
    
    /**
     * @return The {@link ITextureObject} that contains the cape
     */
    public ITextureObject getTexture();
}